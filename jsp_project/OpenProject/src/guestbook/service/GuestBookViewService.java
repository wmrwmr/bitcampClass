package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.dao.GuestBookDao;
import guestbook.domain.PageView;
import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;

public class GuestBookViewService {
	
	private GuestBookViewService() {}
	private static GuestBookViewService service = new GuestBookViewService();
	public static GuestBookViewService getInstance() {
		return service;
	}
	
	public PageView getPageView(HttpServletRequest request, HttpServletResponse response) {
		
		PageView pageView = null;
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			pageView = GuestBookDao.getInstance().selectByIdx(conn, Integer.parseInt(request.getParameter("idx")));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}
		
		return pageView;
		
		
	}

}
