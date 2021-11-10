package main;
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
import tables.Tables;
import tables.TablesDao;
import orders.Orders;
import orders.OrdersDao;




public class TestMain {
	
//	1. 테이블 선택		
//	2. 테이블이 예약인지 아닌지 체크 -> 예약이라면 리셋
//	3. 테이블의 주문이 비었는지 체크 -> 주문이없다면 리셋
//	4. 회원인지 물어보기 -> 맞다고 하면 회원 이름으로 검색해서 방문횟수 ++ -> vip 여부 체크
//  5. (vip 라면) 총 판매 금액 출력: orders와 food 조인해서 f.price와 곱해서 ~~~ 출력 * 0.9, 아니면 그냥 출력
// 	6. 돌아가기
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		TablesDao tablesDao = TablesDao.getInstance();
		OrdersDao ordersDao = OrdersDao.getInstance();

		Connection conn = null;

		List<Tables> list = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			list = ordersDao.selectAllTables(conn);

			for (Tables tables : list) {
				System.out.println(tables);

			}
			
			System.out.println("--------------------");
			System.out.println("계산할 테이블을 선택하세요");
			System.out.println("> ");
			
			int select = Integer.parseInt(sc.nextLine());
			
			switch (select) {
			
			case 1: 
				
				
			case 2:
				
			case 3:
				
			case 4:
				
			case 5:
			
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
}












