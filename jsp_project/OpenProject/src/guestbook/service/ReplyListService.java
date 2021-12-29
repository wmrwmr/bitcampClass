package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import guestbook.dao.ReplyDao;
import guestbook.domain.ReplyListItem;
import jdbc.ConnectionProvider;

public class ReplyListService {

	private ReplyListService() {
	}

	private static ReplyListService service = new ReplyListService();

	public static ReplyListService getInstance() {
		return service;
	}
	
	
	public List<ReplyListItem> getList(HttpServletRequest request){
		
		String idx = request.getParameter("idx");
		
		List<ReplyListItem> list = null;

		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			list = ReplyDao.getInstance().selectReplyList(conn, Integer.parseInt(idx));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
