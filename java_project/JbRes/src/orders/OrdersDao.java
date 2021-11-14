package orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import members.MembersDao;
import members.Members;

public class OrdersDao {
	MembersDao membersDao = MembersDao.getInstance();

	private OrdersDao() {
	}
	
	private static OrdersDao dao = new OrdersDao();

	static public OrdersDao getInstance() {
		return dao;
	}


	// 주문하기
	public int addOrder(Connection conn, Orders orders) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "insert into orders (oid,tid,fid,ordertime) values (ORDERS_ID_seq.nextval, ?, ?, sysdate)";
		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orders.getTid());
			pstmt.setInt(2, orders.getFid());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		return result;
	}

	// 해당 테이블 주문정보 삭제
	public int deleteOrders(Connection conn, int tid) {
		PreparedStatement pstmt = null;
		int result = 0;

		String sql = "delete from orders where tid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tid);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}

		return result;
	}

	// 각각의 테이블이 주문한 음식의 리스트를 구하는 메소드
	public List<FoodOrders> selectAllFoodList(Connection conn, int tid) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<FoodOrders> result = new ArrayList<FoodOrders>();

		try {
			String sql = "select tid, fname, fprice from orders natural join food where tid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tid);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				result.add(new FoodOrders(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}

		} catch (SQLException e) {
			System.out.println("예외");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return result;
	}


	// 빈테이블 체크하기(총합 가격이 0인지 체크하기)

		public int checkEmptyTables(Connection conn, int tid) {
			int a = selectTotalPrice(conn, tid);
			if (a == 0) {

				System.out.println("<빈 테이블 입니다.>");
				return 0;

			}
			return 1;

		}

	// 테이블 번호를 받아 해당 테이블이 총 결제할 가격을 출력하는 메소드
	public int selectTotalPrice(Connection conn, int tid) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 검색 결과
		int a = 0;

		// Sql: Select
		String sql = "select sum(fprice) from food natural join orders where tid=?";

		// 결과 -> 1 또는 0행 -> while 대신 if
		try {
			pstmt = conn.prepareStatement(sql);
			// sql 파라미터 설정
			pstmt.setInt(1, tid);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				a = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}

		return a;

	}
	
	

}
