package guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import guestbook.domain.ReplyListItem;
import guestbook.domain.ReplyRequest;
import jdbc.util.JdbcUtil;

public class ReplyDao {
	
	private ReplyDao() {}
	private static ReplyDao dao = new ReplyDao();
	public static ReplyDao getInstance() {
		return dao;
	}
	
	public int insertReply(Connection conn, ReplyRequest request) throws SQLException {
		
		int resultCnt = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO reply (content, memberidx, guestbookidx) VALUES (?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, request.getMessage());
			pstmt.setInt(2, request.getMemberIdx());
			pstmt.setInt(3, request.getGuestbookIdx());
			
			resultCnt = pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return resultCnt;
	}
	
	
	public List<ReplyListItem> selectReplyList(Connection conn, int guestbookIdx) throws SQLException{
		
		List<ReplyListItem> list = new ArrayList<ReplyListItem>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select r.idx, r.content, r.regdate, r.memberidx, r.guestbookidx, m.username, m.photo from member m join reply r on m.idx=r.memberidx where r.guestbookidx=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, guestbookIdx);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ReplyListItem item = new ReplyListItem(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(5), 
						rs.getInt(4), 
						rs.getString(6), 
						rs.getString(7)); 
				
				list.add(item);
				
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return list;
		
	}

	public int deleteByIdx(Connection conn, int replyIdx) throws SQLException {
		
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		String sql = "delete from reply where idx=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, replyIdx);
			
			resultCnt = pstmt.executeUpdate();
				
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return resultCnt;
	}

}










