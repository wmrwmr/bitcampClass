package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.util.JdbcUtil;
import member.domain.Member;
import member.domain.RegRequest;

public class MemberDao {

	private MemberDao() {
	}

	private static MemberDao dao = new MemberDao();

	public static MemberDao getInstance() {
		return dao;
	}

	// Connection 객체, Member 객체를 전달 받아 데이터베이스에 데이터 입력
	public int insertMember(Connection conn, RegRequest request) throws SQLException {

		int resultCnt = 0;
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO member (userid, password, username, photo) VALUES (?,?,?,?)";
		// String sql = "INSERT INTO member (userid, password, username) VALUES
		// (?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, request.getUserid());
			pstmt.setString(2, request.getPw());
			pstmt.setString(3, request.getUsername());
			pstmt.setString(4, request.getFileName());

			resultCnt = pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}

		return resultCnt;
	}

	// 로그인 처리를 위한 select 메소드
	public Member selectByIdPw(Connection conn, String userId, String pw) 
			throws SQLException {

		Member member = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from member where userid=? and password=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, pw);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new Member(rs.getInt("idx"), // 1
						rs.getString("userid"), // 2
						rs.getString("password"), // 3
						rs.getString("username"), // 4
						rs.getString("regdate"), // 6
						rs.getString("photo")); // 5
			}

		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

		return member;
	}

	public Member selectById(Connection conn, String userId) throws SQLException {
		
		Member member = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from member where userid=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			

			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new Member(rs.getInt("idx"), // 1
						rs.getString("userid"), // 2
						rs.getString("password"), // 3
						rs.getString("username"), // 4
						rs.getString("regdate"), // 6
						rs.getString("photo")); // 5
			}

		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

		return member;
	}

}
