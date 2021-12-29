package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.dao.GuestBookDao;
import guestbook.domain.EditRequest;
import guestbook.domain.Message;
import jdbc.ConnectionProvider;

public class GuestBookEditService {

	private GuestBookEditService() {
	}

	private static GuestBookEditService service = new GuestBookEditService();

	public static GuestBookEditService getInstance() {
		return service;
	}
	
	
	public Message getMessage(int idx, int memberIdx) {
		
		Message message = null;
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			message = GuestBookDao.getInstance().selectMessageByIdx(conn, idx, memberIdx);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return message;
	}
	
	
	public int editMessage(HttpServletRequest request, HttpServletResponse response) {
		
		int resultCnt = 0;
		
		// 사용자가 입력한 데이터들을 받고
		EditRequest editRequest = new EditRequest(
				Integer.parseInt(request.getParameter("guestbookIdx")) , 
				Integer.parseInt(request.getParameter("memberIdx")), 
				request.getParameter("subject"), 
				request.getParameter("content")
				);
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			resultCnt = GuestBookDao.getInstance().updateMessage(conn, editRequest);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return resultCnt;
	}
	

}
