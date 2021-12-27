package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import guestbook.dao.GuestBookDao;
import guestbook.domain.Article;
import guestbook.domain.Message;
import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;
import member.domain.LoginInfo;

public class GuestBookGetMessage {

	private GuestBookGetMessage() {
	}

	private static GuestBookGetMessage service = new GuestBookGetMessage();

	public static GuestBookGetMessage getInstance() {
		return service;
	}

	public Message getMessage(HttpServletRequest request) throws SQLException {

		Message message = null;
		Connection conn = null;
		
		int idx= Integer.parseInt(request.getParameter("idx"));
		int memberIdx = ((LoginInfo) request.getSession().getAttribute("loginInfo")).getIdx();
		
		try {
			conn = ConnectionProvider.getConnection();
			
			message = GuestBookDao.getInstance().selectMessageByIdx(conn, idx, memberIdx);
			
			
		} finally {
			JdbcUtil.close(conn);
		}

		return message;

		
		
		
	}

}
