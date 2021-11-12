package members;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jdbc.JdbcUtil;

public class MembersDao {

	private MembersDao() {

	}

	static private MembersDao dao = new MembersDao();

	static public MembersDao getInstance() {
		return dao;
	}

	public List<Members> selectAllMembers(Connection conn) {
		Statement st = null;
		ResultSet set = null;
		List<Members> list = new ArrayList<Members>();

		try {
			st = conn.createStatement();
			String sql = "select * from members";
			set = st.executeQuery(sql);

			while (set.next()) {
				list.add(new Members(set.getInt(1), set.getString(2), set.getString(3), set.getInt(4)));
			}

		} catch (SQLException e) {
			System.out.println("<fail>");
		} finally {
			JdbcUtil.close(set);
			JdbcUtil.close(st);
		}
		return list;
	}

	public List<Members> selectByName(Connection conn, String mname) {
		PreparedStatement pst = null;
		ResultSet set = null;
		List<Members> list = new ArrayList<Members>();

		String sql = "select * from members where mname like ?";

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, mname);

			set = pst.executeQuery();

			while (set.next()) {
				list.add(new Members(set.getInt(1), set.getString(2), set.getString(3), set.getInt(4)));
			}

		} catch (SQLException e) {
			System.out.println("<fail>");
		} finally {
			JdbcUtil.close(set);
			JdbcUtil.close(pst);
		}
		return list;
	}

	public List<Members> selectByPhone(Connection conn, String lastPN) {
		PreparedStatement pst = null;
		ResultSet set = null;
		List<Members> list = new ArrayList<Members>();

		String sql = "select * from members where mphone like '%'||?";

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, lastPN);

			set = pst.executeQuery();

			while (set.next()) {
				list.add(new Members(set.getInt(1), set.getString(2), set.getString(3), set.getInt(4)));
			}

		} catch (SQLException e) {
			System.out.println("<fail>");
		} finally {
			JdbcUtil.close(set);
			JdbcUtil.close(pst);
		}
		return list;
	}

	public int insertMember(Connection conn, Members mem) {
		PreparedStatement pst = null;
		int result = 0;

		String sql = "insert into members (mid, mname, mphone) values (members_id_seq.nextval,?,?)";

		try {
			pst = conn.prepareStatement(sql);

			pst.setString(1, mem.getMname());
			pst.setString(2, mem.getMphone());

			result = pst.executeUpdate();

		} catch (SQLException e) {
			System.out.println("<중복된 연락처 또는 잘못된 입력으로 등록에 실패하였습니다.>");
		} finally {
			JdbcUtil.close(pst);
		}
		return result;
	}

	public int updateMember(Connection conn, int mid, String newName, String newPhone) {
		PreparedStatement pst = null;
		int result = 0;

		String sql = "update members set mname=?, mphone=? where mid=?";

		try {
			pst = conn.prepareStatement(sql);

			pst.setString(1, newName);
			pst.setString(2, newPhone);
			pst.setInt(3, mid);

			result = pst.executeUpdate();

		} catch (SQLException e) {
			System.out.println("<중복된 연락처 또는 잘못된 입력으로 수정에 실패하였습니다.>");
		} finally {
			JdbcUtil.close(pst);
		}
		return result;
	}

	public int addBonus(Connection conn, int mid, int payment) {
		PreparedStatement pst = null;
		int result = 0;
		int bonus = (int) payment/20;

		String sql = "update members set bonus = (select bonus from members where mid=?)+? where mid=?";

			try {
				pst = conn.prepareStatement(sql);
				
				pst.setInt(1, mid);
				pst.setInt(2, bonus);
				pst.setInt(3, mid);

				result = pst.executeUpdate();
				
			} catch (SQLException e) {
				System.out.println("<fail>");
			}
		return result;
	}

	public int deleteMember(Connection conn, int mid) {
		PreparedStatement pst = null;
		int result = 0;

		String sql = "delete members where mid=?";

		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, mid);

			result = pst.executeUpdate();

		} catch (SQLException e) {
			System.out.println("<fail>");
		} finally {
			JdbcUtil.close(pst);
		}
		return result;
	}

}
