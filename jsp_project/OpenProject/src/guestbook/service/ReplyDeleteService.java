package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import guestbook.dao.ReplyDao;
import jdbc.ConnectionProvider;

public class ReplyDeleteService {
	
	private ReplyDeleteService() {}
	
	private static ReplyDeleteService service = new ReplyDeleteService();
	
	public static ReplyDeleteService getInstance() {
		return service;
	}
	
	public int deleteReply(HttpServletRequest request) {
		
		int resultCnt = 0;
		
		String idx = request.getParameter("idx");
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			resultCnt = ReplyDao.getInstance().deleteByIdx(conn, Integer.parseInt(idx));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return resultCnt;
		
	}

}





