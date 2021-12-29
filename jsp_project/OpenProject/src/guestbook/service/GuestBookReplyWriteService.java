package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import guestbook.dao.ReplyDao;
import guestbook.domain.ReplyListItem;
import guestbook.domain.ReplyRequest;
import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;

public class GuestBookReplyWriteService {

	private GuestBookReplyWriteService() {
	}

	private static GuestBookReplyWriteService service = new GuestBookReplyWriteService();

	public static GuestBookReplyWriteService getInstance() {
		return service;
	}

	public int writeRepy(HttpServletRequest request, HttpServletResponse response) {

		int resultCnt = 0;

		String memberIdx = request.getParameter("memberIdx");
		String guestbookIdx = request.getParameter("guestbookIdx");
		String message = request.getParameter("message");

		ReplyRequest replyRequest = new ReplyRequest(Integer.parseInt(memberIdx), Integer.parseInt(guestbookIdx),
				message);

		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();

			resultCnt = ReplyDao.getInstance().insertReply(conn, replyRequest);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultCnt;

	}

	public List<ReplyListItem> writeRepy2(HttpServletRequest request, HttpServletResponse response) {

		// 데이터 입력
		writeRepy(request, response);

		int idx = Integer.parseInt(request.getParameter("guestbookIdx"));

		Connection conn = null;
		List<ReplyListItem> list = null;

		try {
			conn = ConnectionProvider.getConnection();

			list = ReplyDao.getInstance().selectReplyList(conn, idx);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}

		return list;
	}

	public String writeRepy3(HttpServletRequest request, HttpServletResponse response) {

		// JSON 형식의 데이터를 반환
		// JSON -> 문자열
		// insert
		writeRepy(request, response);

		// List<ReplyListItem> -> JSON
		int idx = Integer.parseInt(request.getParameter("guestbookIdx"));

		Connection conn = null;
		List<ReplyListItem> list = null;
		String jsonStr = null;

		try {
			conn = ConnectionProvider.getConnection();

			list = ReplyDao.getInstance().selectReplyList(conn, idx);
			
			// List<ReplyListItem> -> JSON
			Gson gson = new Gson();
			
			jsonStr = gson.toJson(list);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}

		return jsonStr;
	}
}
