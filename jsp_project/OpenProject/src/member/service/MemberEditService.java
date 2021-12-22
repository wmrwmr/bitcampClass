package member.service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import member.domain.EditRequest;
import member.domain.Member;

public class MemberEditService {

	private MemberEditService() {
	}

	private static MemberEditService service = new MemberEditService();

	public static MemberEditService getInstance() {
		return service;
	}

	// idx 값으로 Member 객체를 반환하는 메소드
	public Member getMember(int idx) {

		Member member = null;

		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();

			member = MemberDao.getInstance().selectByIdx(conn, idx);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return member;

	}

	public int editMember(HttpServletRequest request, HttpServletResponse response) {

		int resultCnt = 0;

		// 1. multipart 여부 확인
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		if (isMultipart) {

			// 2. 파일 저장을 위한 Factory 객체 생성
			DiskFileItemFactory factory = new DiskFileItemFactory();

			// 3. 요청을 구분( form 안에 있는 input 들을 분리 )
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			// 새로운 입력 파일
			File newFile = null;
			Connection conn = null;
			
			try {
				
				String idx = null;
				//String userid = null;
				String pw = null;
				String username = null;
				String oldfile = null;
				
				String filename = null;
				
				boolean newFileChk = false;
				String saveDir = request.getSession().getServletContext().getRealPath("/uploadfile");		
				
				
				List<FileItem> items = upload.parseRequest(request);
				
				Iterator<FileItem> itr = items.iterator();
				
				while(itr.hasNext()) {
					
					FileItem item = itr.next();
					
					if(item.isFormField()) {
						// not file
						
						String paramName = item.getFieldName();
						
						if(paramName.equals("pw")) {
							pw = getFieldValue(item); // ""
						} else if(paramName.equals("username")) {
							username = getFieldValue(item);
						} else if(paramName.equals("oldfile")) {
							oldfile = getFieldValue(item);
						} else if(paramName.equals("idx")) {
							idx = getFieldValue(item);
						}
						
					} else {
						// file
						
						if(item.getFieldName().equals("photo") && item.getSize()>0) {
							// 웹 저장경로
							// String uploadURI = "/uploadfile";
							// 시스템 경로
							
							// 새로운 파일 이름은 중복되지않는 숫자로 생성
							String newFileName = String.valueOf(System.nanoTime()) ;
							
							// file 저장을 위한 File 객체 생성
							newFile = new File(saveDir, newFileName);
							//File newFile = new File(request.getSession().getServletContext().getRealPath("/uploadfile"), String.valueOf(System.nanoTime()));
							
							
							// 파일 저장
							item.write(newFile);
							//item.write(new File(request.getSession().getServletContext().getRealPath("/uploadfile"), String.valueOf(System.nanoTime())));
							
							System.out.println("파일 저장 완료");
														
							filename = newFileName;
							
							newFileChk = true;
							
						}
						
					}
					
				}
				
				// DB : Update 
				if(filename == null) {
					filename = oldfile == null ? "starwars.png" : oldfile;
				}
				
				conn = ConnectionProvider.getConnection();
				resultCnt = MemberDao.getInstance().updateMember(conn, new EditRequest(Integer.parseInt(idx), pw, username, filename));
				
				if(newFileChk) {
					// oldfile 삭제
					if(oldfile != null && !oldfile.equals("starwars.png")) {
						File oldFile = new File(saveDir, oldfile);
						if(oldFile.exists()) {
							oldFile.delete();
						}
					}
				}
				
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
				// 저장된 파일이 있다면 파일을 삭제
				if(newFile != null && newFile.exists()) {
					newFile.delete();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return resultCnt;

	}
	
	private String getFieldValue(FileItem item) throws UnsupportedEncodingException {
		return item.getString("utf-8").isEmpty() ? null : item.getString("utf-8");
	}
	
	
	
	
	
	
	

}
