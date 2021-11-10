package members;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MembersDao {

	private MembersDao() {

	}

	static private MembersDao dao = new MembersDao();

	static public MembersDao getInstance() {
		return dao;
	}

	public List<Members> selectAll(Connection conn) {
		Statement st = null;
		ResultSet set = null;
		List<Members> list = new ArrayList<Members>();

		try {
			st = conn.createStatement();
			String sql = "select * from members";
			set = st.executeQuery(sql);

			while (set.next()) {
				list.add(new Members(set.getInt(1), set.getString(2), set.getString(3), set.getInt(4),
						set.getString(5)));
			}
			
		} catch (SQLException e) {
			System.out.println("(목록을 불러오는데 실패했습니다.)");
			e.printStackTrace();
		} finally {
			// JdbcUtil.close 메소드
		}
		return list;
	}

	public Members searchByName(Connection conn, String mname) {
		PreparedStatement pst = null;
		ResultSet set = null;
		Members mem = null;

		String sql = "select * from members where mname like ?";

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, mname);

			set = pst.executeQuery();

			if (set.next()) {
				mem = new Members(set.getInt(1), set.getString(2), set.getString(3), set.getInt(4), set.getString(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// JdbcUtil.close 메소드
		}
		return mem;
	}

	public Members searchByPhone(Connection conn, String lastNum) {
		PreparedStatement pst = null;
		ResultSet set = null;
		Members mem = null;

		String sql = "select * from members where mphone like %?";

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, lastNum);

			set = pst.executeQuery();

			if (set.next()) {
				mem = new Members(set.getInt(1), set.getString(2), set.getString(3), set.getInt(4), set.getString(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// JdbcUtil.close 메소드
		}
		return mem;
	}

	public int insert(Connection conn, Members mem) {
		PreparedStatement pst = null;
		int result = 0;

		String sql = "insert into members (mid, mname, mphone) values (members_id_seq.nextval,?,?)";

		try {
			pst = conn.prepareStatement(sql);

			pst.setString(1, mem.getMname());
			pst.setString(2, mem.getMphone());
			
			result = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// JdbcUtil.close 메소드
		}
		return result;
	}

	public int update(Connection conn, int mid, String newName, String newPhone) {
		PreparedStatement pst = null;
		int result = 0;

		String sql = "update members set mname=?, mphone=? where mid=?";

		try {
			pst = conn.prepareStatement(sql);

			pst.setString(1, newName);
			pst.setString(2, newPhone);
			pst.setInt(3, mid);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// JdbcUtil.close 메소드
		}
		return result;
	}

	public int delete(Connection conn, int mid) {
		PreparedStatement pst = null;
		int result = 0;

		String sql = "delete members where mid=?";

		try {
			pst = conn.prepareStatement(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// JdbcUtil.close 메소드
		}
		return result;
	}

}
