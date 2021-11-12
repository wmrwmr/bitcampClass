package food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jdbc.JdbcUtil;

public class FoodDao {

	// 싱글톤 패턴
	private FoodDao() {
	}

	private static FoodDao dao = new FoodDao();

	static public FoodDao getInstance() {
		return dao;
	}

	// 음식 리스트 전체 출력
	public List<Food> selectAllFood(Connection conn) {
		Statement stmt = null;
		ResultSet rs = null;
		List<Food> list = new ArrayList<Food>();
		try {
			stmt = conn.createStatement();
			String sql = "select * from food";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				list.add(new Food(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}

		} catch (SQLException e) {
			System.out.println("목록을 불러오는 데 실패했습니다.");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}

		return list;

	}

	// 음식 메뉴 추가(등록)
	public int insertFood(Connection conn, Food food) {
		PreparedStatement pst = null;
		int result = 0;

		String sql = "insert into food (fid, fname, fprice) values (food_id_seq.nextval,?,?)";
		try {
			pst = conn.prepareStatement(sql);

			pst.setString(1, food.getFname());
			pst.setInt(2, food.getFprice());

			result = pst.executeUpdate();

		} catch (SQLException e) {
			System.out.println("잘못된 입력으로 등록에 실패했습니다.");
		} finally {
			JdbcUtil.close(pst);
		}

		return result;
	}

	// 음식 이름/가격 업데이트
	public int updateFood(Connection conn, int fid, String fname, int fprice) {
		PreparedStatement pst = null;
		int result = 0;
		String sql = "update food set fname=?, fprice=? where fid=?";

		try {
			pst = conn.prepareStatement(sql);

			pst.setString(1, fname);
			pst.setInt(2, fprice);
			pst.setInt(3, fid);

			result = pst.executeUpdate();

		} catch (SQLException e) {
			System.out.println("잘못된 입력으로 수정에 실패했습니다.");
		} finally {
			JdbcUtil.close(pst);
		}
		return result;
	}

//음식 삭제
	public int deleteFood(Connection conn, int fid) {
		PreparedStatement pst = null;
		int result = 0;

		String sql = "delete food where fid=?";

		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, fid);

			result = pst.executeUpdate();

		} catch (SQLException e) {
			System.out.println("잘못된 입력으로 삭제에 실패했습니다.");
		} finally {
			JdbcUtil.close(pst);
		}
		return result;
	}
}
