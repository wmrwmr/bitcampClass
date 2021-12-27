package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.dao.GuestBookDao;
import guestbook.domain.WriteRequest;
import jdbc.ConnectionProvider;

public class GuestBookWriteService {

	private GuestBookWriteService() {
	}

	private static GuestBookWriteService service = new GuestBookWriteService();

	public static GuestBookWriteService getInstance() {
		return service;
	}

	public int writeArticle(HttpServletRequest request, HttpServletResponse response) {

		int resultCnt = 0;

		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();
			
			String memberIdx = request.getParameter("memberIdx");
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");
			
			WriteRequest writeRequest = new WriteRequest(Integer.parseInt(memberIdx), subject, content);
			
			resultCnt = GuestBookDao.getInstance().insertArticle(conn, writeRequest);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultCnt;
	}

}
