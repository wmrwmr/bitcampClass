package orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import tables.Tables;



public class OrdersDao {
	
	
	
	// 인스턴스 하나만 만들어 사용하도록 하는 패턴
	// 외부에서 인스턴스를 생성하지 못하도록 처리! -> 생성자의 접근제어자를 private
	private OrdersDao() {
	}

	// 클래스 내부에서 인스턴스를 생성!!!, 이 인스턴스를 직접 접근 안되도록!
	private static OrdersDao dao = new OrdersDao();

	// 내부에서 만들어진 인스턴스를 특정 메소드를 이용해서 받을 수 있도록 해주자!!! (싱글톤 패턴)
	static public OrdersDao getInstance() {
		return dao;
	}
	
	
	// 테이블 목록 출력 메소드
	public List<Tables> selectAllTables(Connection conn) {
		
		Statement stmt = null;
		ResultSet rs = null;
		List<Tables> result = new ArrayList<Tables>();

		try {
			// 결과 생성
			stmt = conn.createStatement();

			String sql = "select * from tables";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				result.add(new Tables(rs.getInt(1)));
			}

		} catch (SQLException e) {
			System.out.println("예외");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}

		return result;
	}
	
	// 테이블 총 가격을 뽑아오는 메소드
	
	public int selectTotalPrice(Connection conn, int tid) {

		PreparedStatement pstmt = null;
		int resultCnt = 0;
		// 검색 결과
		Orders orders = null;

		// Sql: Select
		String sql = "select sum(fprice) from food natural join orders where tid=?";

		// 결과 -> 1 또는 0행 -> while 대신 if
		try {
			pstmt = conn.prepareStatement(sql);
			// sql 파라미터 설정
			pstmt.setInt(1, tid);

			resultCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

		return resultCnt;

	}
	
	
}
