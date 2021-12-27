package guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import guestbook.domain.Article;
import guestbook.domain.Message;
import guestbook.domain.PageView;
import guestbook.domain.WriteRequest;
import jdbc.util.JdbcUtil;
import member.domain.Member;

public class GuestBookDao {

	private GuestBookDao() {
	}

	private static GuestBookDao dao = new GuestBookDao();

	public static GuestBookDao getInstance() {
		return dao;
	}

	public int insertArticle(Connection conn, WriteRequest writeRequest) throws SQLException {

		int resultCnt = 0;
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO guestbook (subject, content, memberidx) VALUES (?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writeRequest.getSubject());
			pstmt.setString(2, writeRequest.getContent());
			pstmt.setInt(3, writeRequest.getMemberIdx());

			resultCnt = pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}

		return resultCnt;
	}

	public List<Article> selectList(Connection conn, int index, int count) throws SQLException {

		List<Article> list = new ArrayList<Article>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select g.idx as idx , g.subject as subject, g.content as content, g.regdate as regdate, m.username as username, m.photo as photo from project.guestbook g join project.member m on g.memberidx=m.idx order by regdate desc limit ?, ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, index);
			pstmt.setInt(2, count);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new Article(
						rs.getInt("idx"), 
						rs.getString("subject"), 
						rs.getString("content"), 
						rs.getString("regdate"),
						rs.getString("username"),
						rs.getString("photo")));
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

		return list;
	}

	public int selectTotalCount(Connection conn) throws SQLException {
		int totalCount = 0;

		Statement stmt = null;
		ResultSet rs = null;

		String sql = "select count(*) from guestbook";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				totalCount = rs.getInt(1);
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}

		return totalCount;
	}

	public PageView selectByIdx(Connection conn, int idx) throws SQLException {
		
		PageView pageView = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select g.idx as idx, g.subject as subject, g.content as content, m.username as username, g.regdate as regdate, m.photo as photo, m.idx as memberidx, m.userid as userid from project.guestbook g join project.member m on g.memberidx=m.idx where g.idx=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);

			rs = pstmt.executeQuery();

			if(rs.next()) {
				pageView = new PageView(
						rs.getInt("idx"), 
						rs.getString("subject"), 
						rs.getString("content"), 
						rs.getString("regdate"),
						rs.getString("username"),
						rs.getString("photo"),
						rs.getInt("memberidx"),
						rs.getString("userid"));
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

		return pageView;
	}

	public Message selectMessageByIdx(Connection conn, int idx, int memberIdx) throws SQLException {
		
		Message message = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from guestbook where idx=? and memberidx=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.setInt(2, memberIdx);
			
			rs = pstmt.executeQuery();

			if(rs.next()) {
				message = new Message(
						rs.getInt("idx"), 
						rs.getString("subject"), 
						rs.getString("content"), 
						rs.getString("regdate"),
						rs.getInt("memberidx"));
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

		return message;
	}

}
