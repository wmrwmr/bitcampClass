package orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import controller.BadInputController;
import controller.Menu;

import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import orders.FoodOrders;
import orders.Orders;
import orders.OrdersDao;

public class OrdersViewer {
	
	   // 클래스 내부에서 인스턴스를 생성!!!, 이 인스턴스를 직접 접근 안되도록!
	   private static Orders dao = new Orders();

	   // 내부에서 만들어진 인스턴스를 특정 메소드를 이용해서 받을 수 있도록 해주자!!! (싱글톤 패턴)
	   static public Orders getInstance() {
	      return dao;
	   }
	   
	   

	OrdersDao ordersDao = OrdersDao.getInstance();
	Orders orders = Orders.getInstance();

	FoodOrders foodOrders = FoodOrders.getInstance();

	List<FoodOrders> list = new ArrayList<>();
	Scanner scanner;
	Connection conn = null;
	
	public OrdersViewer(Scanner scanner) {
		this.scanner = scanner;
	}

	public void payment() {

		while (true) {

			try {

				conn = ConnectionProvider.getConnection();

				Scanner sc = new Scanner(System.in);
				System.out.println("결제할 테이블 번호를 입력하거나 뒤로 가려면 [0]을 입력해주세요");

				int select = Integer.parseInt(sc.nextLine());

				if (select == 0) {

					break;

				} else {

					// 체크 후 빈테이블이면 "빈테이블입니다 " 출력후 0을 반환, 아니면 1을 반환!!
					int emptyCheck = ordersDao.checkEmptyTables(conn, select);

					if (emptyCheck == 1) {
						// 결제 계속 진행
						int total = ordersDao.selectTotalPrice(conn, select);

						System.out.println("총 결제 가격은" + total + "원 입니다.");

						// 회원여부 체크 후 마일리지 적립 과정 여기에

						// 결제 완료후 테이블 번호로 주문 정보 삭제하는 메소드
						ordersDao.deleteOrders(conn, select);
						break;

					} else if (emptyCheck == 0) {
						// 처음으로
						continue;
					}

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}


	public void tablePrinter() {

		try {
			conn = ConnectionProvider.getConnection();
			
			// 1번

			if (ordersDao.selectTotalPrice(conn, 1) == 0) {
				System.out.println("┌──────────┐");
				System.out.println("<1번 테이블 >");
				System.out.println("(빈 테이블)");
				System.out.println("└──────────┘");
			} else {
				System.out.println("┌──────────┐");
				System.out.println("<1번 테이블 >");
				list = ordersDao.selectAllFoodList(conn, 1);

				for (FoodOrders food : list) {
					System.out.println(food);
				}
				
				System.out.println();
				System.out.print("합계: ");
				System.out.print(ordersDao.selectTotalPrice(conn, 1));
				System.out.print("원");
				System.out.println();
				System.out.println("└──────────┘");

			}
			
			
			// 2번
			
			
			
			if (ordersDao.selectTotalPrice(conn, 2) == 0) {
				System.out.println("┌──────────┐");
				System.out.println("<2번 테이블 >");
				System.out.println("(빈 테이블)");
				System.out.println("└──────────┘");
			} else {
				System.out.println("┌──────────┐");
				System.out.println("<2번 테이블 >");
				list = ordersDao.selectAllFoodList(conn, 2);

				for (FoodOrders food : list) {
					System.out.println(food);
				}
				System.out.print("합계: ");
				System.out.print(ordersDao.selectTotalPrice(conn, 2));
				System.out.print("원");
				System.out.println();
				System.out.println("└──────────┘");

			}
			
			// 3번
			
			if (ordersDao.selectTotalPrice(conn, 3) == 0) {
				System.out.println("┌──────────┐");
				System.out.println("<3번 테이블 >");
				System.out.println("(빈 테이블)");
				System.out.println("└──────────┘");
			} else {
				System.out.println("┌──────────┐");
				System.out.println("<3번 테이블 >");
				list = ordersDao.selectAllFoodList(conn, 3);

				for (FoodOrders food : list) {
					System.out.println(food);
				}
				System.out.print("합계: ");
				System.out.print(ordersDao.selectTotalPrice(conn, 3));
				System.out.print("원");
				System.out.println();
				System.out.println("└──────────┘");

			}
			
			// 4번
			
			if (ordersDao.selectTotalPrice(conn, 4) == 0) {
				System.out.println("┌──────────┐");
				System.out.println("<4번 테이블 >");
				System.out.println("(빈 테이블)");
				System.out.println("└──────────┘");
			} else {
				System.out.println("┌──────────┐");
				System.out.println("<4번 테이블 >");
				list = ordersDao.selectAllFoodList(conn, 4);

				for (FoodOrders food : list) {
					System.out.println(food);
				}
				System.out.print("합계: ");
				System.out.print(ordersDao.selectTotalPrice(conn, 4));
				System.out.print("원");
				System.out.println();
				System.out.println("└──────────┘");

			}
			
			
			// 5번
			
			if (ordersDao.selectTotalPrice(conn, 5) == 0) {
				System.out.println("┌──────────┐");
				System.out.println("<5번 테이블 >");
				System.out.println("(빈 테이블)");
				System.out.println("└──────────┘");
			} else {
				System.out.println("┌──────────┐");
				System.out.println("<5번 테이블 >");
				list = ordersDao.selectAllFoodList(conn, 5);

				for (FoodOrders food : list) {
					System.out.println(food);
				}
				System.out.print("합계: ");
				System.out.print(ordersDao.selectTotalPrice(conn, 5));
				System.out.print("원");
				System.out.println();
				System.out.println("└──────────┘");

			}
			
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
