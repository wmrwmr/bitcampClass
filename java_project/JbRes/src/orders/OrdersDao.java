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

//	1. 테이블 선택
//	2. 테이블의 주문이 비었는지 체크 -> 주문이없다면  "빈테이블 입니다." 출력후 exit;
//	3. 회원인지 물어보기 -> 맞다고 하면 회원 이름으로 검색해서 방문횟수 ++ (중복이라면 다띄우고 회원 번호로 선택) -> vip 여부 체크
//  4. (vip 라면) 총 판매 금액에 * 0.9해서 출력, 아니면 그냥 총 판매금액 출력 
//  5. 해당 테이블 주문 정보 삭제
// 	6. 메인 메뉴로 돌아간 후 예약이었던 테이블이면 해당 테이블의 예약 정보 점원이 수동으로 삭제

	// 결제 가격 출력 방법
	// System.out.println(selectTotalPrice(conn, select));

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

	// 전체 리스트를 구하는 메소드: select -> Connection을 전달받고, List<Dept>
	public List<FoodOrders> selectAllFoodList(Connection conn, int tid) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<FoodOrders> result = new ArrayList<FoodOrders>();

		try {
			// 결과 생성

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
