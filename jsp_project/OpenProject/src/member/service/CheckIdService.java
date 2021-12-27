package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;

public class CheckIdService {
	
	private CheckIdService() {}
	private static CheckIdService service = new CheckIdService();
	public static CheckIdService getInstance() {
		return service;
	}
	
	// 해당 아이디로  select => count 개수를 반환
	public int getMemberCount(HttpServletRequest request) {
		
		int resultCnt =  0;
		
		String userId = request.getParameter("userid");
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			resultCnt = MemberDao.getInstance().selectByIdCount(conn, userId);
			
		} catch (SQLException e) {
			e.printStackTrace();
			// 정상적인 체크가 안되었기 때문에 사요하지 못하도록 처리
			resultCnt = 1; 
		}
		
		
		return resultCnt;
	}

}
