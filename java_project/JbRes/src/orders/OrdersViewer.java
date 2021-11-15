package orders;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import controller.BadInputController;
import controller.Menu;
import food.FoodViewer;
import jdbc.ConnectionProvider;

public class OrdersViewer {
	private BadInputController inputC;
	public int total = 0;

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
	FoodViewer fdV;

	public OrdersViewer(Scanner scanner, BadInputController inputC, FoodViewer fdV) {
		this.scanner = scanner;
		this.inputC = inputC;
		this.fdV = fdV;
	}

	public void orderManager() {
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			System.out.println();
			System.out.println("-------------------------------------------------------------------");
			System.out.print(Menu.O_INSERT + ". 주문 추가   ");
			// System.out.print(Menu.O_DELETE + ". 주문 삭제 ");
			System.out.print(Menu.O_EXIT + ". 뒤로 가기\n");
			System.out.println("-------------------------------------------------------------------");
			int userChoice = inputC.checkInt("> ", Menu.O_INSERT, Menu.O_EXIT);
			if (userChoice == Menu.O_INSERT) {
				insert();
				conn.commit();
			} /*
				 * else if (userChoice == Menu.O_DELETE) { delete(); }
				 */ else {
			}
		} catch (SQLException e) {
			System.out.print("");
		}
	}

	private void insert() {
		try {
			tablePrinter();
			System.out.println();
			System.out.println("-------------------------------------------------------------------");
			System.out.println("몇 번 테이블에 주문하시겠습니까?");
			System.out.println("-------------------------------------------------------------------");
			String tid = inputC.checkInt("> ");
			int tid1 = Integer.parseInt(tid);

			fdV.showAll();
			System.out.println();
			System.out.println("-------------------------------------------------------------------");
			System.out.println("추가하길 원하는 메뉴의 번호를 입력해 주십시오.");
			System.out.println("-------------------------------------------------------------------");
			String fid = inputC.checkInt("> ");
			int fid1 = Integer.parseInt(fid);

			Orders orders = new Orders(tid1, fid1);

			int result = ordersDao.addOrder(conn, orders);
			if (result == 1) {
				conn.commit();
				System.out.println("<주문이 완료되었습니다.>");
			}
			System.out.println("-------------------------------------------------------------------");
			System.out.println("[확인] 계속 진행하려면 엔터를 눌러주세요.");
			scanner.nextLine();

		} catch (SQLException e) {
			System.out.print("");
		}
	}

	private void delete() {
		try {
			tablePrinter();
			System.out.println();
			System.out.println("-------------------------------------------------------------------");
			System.out.println("몇 번 테이블의 주문을 제거할까요?");
			System.out.println("-------------------------------------------------------------------");
			String tid = inputC.checkInt("> ");
			int tid1 = Integer.parseInt(tid);

			list = ordersDao.selectAllFoodList(conn, tid1);
			System.out.println();
			System.out.println("-------------------------------------------------------------------");
			System.out.println("몇 번째 주문을 제거할까요?");
			System.out.println("-------------------------------------------------------------------");
			String oid1 = inputC.checkInt("> ");
			int oid2 = Integer.parseInt(oid1);

			int result = ordersDao.deleteOrders(conn, oid2);

			if (result == 1) {
				conn.commit();
				System.out.println("<주문 정보가 삭제되었습니다.>");
			}

		} catch (SQLException e) {
			System.out.println("<fail>");
		}

	}

	public int payment() {
		try {
			conn = ConnectionProvider.getConnection();

			while (true) {
				Scanner sc = new Scanner(System.in);
				System.out.println();
				System.out.println("-------------------------------------------------------------------");
				System.out.println("결제할 테이블 번호를 입력하거나 뒤로 가려면 [0]을 입력해주세요");
				System.out.println("-------------------------------------------------------------------");
				System.out.print("> ");

				int select = Integer.parseInt(sc.nextLine());

				if (select == 0) {
					break;

				} else {

					// 체크 후 빈테이블이면 "빈테이블입니다 " 출력후 0을 반환, 아니면 1을 반환!!
					int emptyCheck = ordersDao.checkEmptyTables(conn, select);

					if (emptyCheck == 1) {
						// 결제 계속 진행
						total = ordersDao.selectTotalPrice(conn, select);
						list = ordersDao.selectAllFoodList(conn, select);

						System.out.println();
						System.out.println("<" + select + "번 테이블 주문내역>");
						for (FoodOrders food : list) {
							System.out.println(food.getFname() + " " + food.getFprice());
						}
						System.out.println();
						System.out.println("-------------------------------------------------------------------");
						System.out.println("합계 " + total + "원입니다. 결제 하시겠습니까?");
						System.out.println("-------------------------------------------------------------------");
						System.out.println("1. 네   2. 아니오");
						System.out.println("-------------------------------------------------------------------");
						int answer = inputC.checkInt("> ", 1, 2);

						if (answer == 1) {
							Date now = new Date();
							SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");

							// -----------------------------------------------------------------------------------------
							System.out.println();
							System.out.println();
							System.out.println("──────────────────────────────────");
							System.out.println();
							System.out.println("              [영수증]");
							System.out.println();
							System.out.println();
							System.out.println("[매장명] 자비레스");
							System.out.println("[사업자] 285-37-00231");
							System.out.println("[주소] 서울 강남구 역삼동 819-3 삼오빌딩 ");
							System.out.println("[TEL] 0507-1414-9601");
							System.out.println("" + sdf.format(now));
							System.out.println("----------------------------------");
							System.out.println("상품명\t\t\t금액");
							System.out.println("----------------------------------");

							for (FoodOrders food : list) {
								String fprice = String.valueOf(food.getFprice());

								if (fprice.length() > 3) {
									String fprice1 = fprice.substring(0, fprice.length() - 3);
									String fprice2 = fprice.substring(fprice.length() - 3, fprice.length());
									fprice = fprice1 + "," + fprice2;
								}

								String fname = food.getFname();
								for (int i = 1; i <= 13; i++) {
									String space = "";
									for (int j = i; j < 13; j++) {
										if (fname.length() == i) {
											space += "　";
										}
									}
									fname += space;
								}
								if (fname.length() > 13) {
									fname = fname.substring(0, 11);
									fname += "...";
								}
								System.out.printf("%s\t%8s원\n", fname, fprice);

							}
							System.out.println("----------------------------------");
							String totalS = String.valueOf(total);
							if (totalS.length() > 3) {
								String total1 = totalS.substring(0, totalS.length() - 3);
								String total2 = totalS.substring(totalS.length() - 3, totalS.length());
								totalS = total1 + "," + total2;
							}
							System.out.printf("합계 금액\t\t\t%8s원\n", totalS);
							System.out.println("----------------------------------");
							System.out.println("              <이용해 주셔서 감사합니다.>");
							System.out.println();
							System.out.println();
							System.out.println("──────────────────────────────────");
							System.out.println();
							System.out.println();
							// -----------------------------------------------------------------------------------------

							System.out.println();
							System.out.println("-------------------------------------------------------------------");
							System.out.println("<결제가 완료되었습니다. 이용해주셔서 감사합니다.>");
							System.out.println("-------------------------------------------------------------------");

							// 결제 완료후 테이블 번호로 주문 정보 삭제하는 메소드
							ordersDao.deleteOrders(conn, select);
							break;
						} else {
							total = 0;
						}

					} else if (emptyCheck == 0) {
						// 처음으로
						continue;
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}

	public void tablePrinter() {
		try {
			conn = ConnectionProvider.getConnection();

			//

			// -----------------------------------------------------------------------------------------
			String fname = null;
			for (int i = 1; i <= 5; i++) {
				System.out.println();
				System.out.println("┌───────────────┐");
				System.out.println("│[" + i + "]\t\t│");

				list = ordersDao.selectAllFoodList(conn, i);

				for (int j = 0; j <= 7; j++) {
					if (j < 6) {
						if (list.size() == 0 && j == 1) {
							System.out.println("│(빈 테이블)\t│");
						} else if (list.size() < j + 1) {
							System.out.println("│\t\t│");
						} else {
							if (j == 5 && list.size() > 6) {
								System.out.println("│(...)\t\t│");
							} else {
								fname = list.get(j).getFname();

								for (int k = 1; k <= 6; k++) {
									String space = "";
									for (int l = k; l <= 6; l++) {
										if (fname.length() == k) {
											space += "　";
										}
									}
									fname += space;
								}
								if (fname.length() > 10) {
									fname = fname.substring(0, 9);
									fname += "...";
								} else {
									fname += "\t";
								}
								System.out.println("│" + fname + "│");
							}
						}
					} else if (j == 6) {
						if (list.size() != 0) {
							String totalS = String.valueOf(ordersDao.selectTotalPrice(conn, i));

							if (totalS.length() > 3) {
								String total1 = totalS.substring(0, totalS.length() - 3);
								String total2 = totalS.substring(totalS.length() - 3, totalS.length());
								totalS = total1 + "," + total2;
							}

							System.out.println("│합계 = " + totalS + "원\t│");
						} else {
							System.out.println("│\t\t│");
						}
					} else {
						System.out.println("└───────────────┘");
					}
				}
			}

			// -----------------------------------------------------------------------------------------

//			for (int a = 1; a <= 5; a++) {
//				if (ordersDao.selectTotalPrice(conn, i) == 0) {
//					System.out.println("┌─────────┐");
//					System.out.println("│<" + i + "번 테이블 >	│");
//					System.out.println("│(빈 테이블)	│");
//					System.out.println("└───────────────┘");
//				} else {
//					System.out.println("┌───────────────┐");
//					System.out.println("│<" + i + "번 테이블 >	│");
//					list = ordersDao.selectAllFoodList(conn, i);
//
//					for (FoodOrders food : list) {
//						System.out.println("│" + food + " 	│");
//					}
//					System.out.print("│합계: ");
//					System.out.print(ordersDao.selectTotalPrice(conn, i));
//					System.out.print("원	│");
//					System.out.println();
//					System.out.println("└───────────────┘");
//				}
//			}

			// 1번

//			if (ordersDao.selectTotalPrice(conn, 1) == 0) {
//				System.out.println("┌──────────┐");
//				System.out.println("<1번 테이블 >");
//				System.out.println("(빈 테이블)");
//				System.out.println("└──────────┘");
//			} else {
//				System.out.println("┌──────────┐");
//				System.out.println("<1번 테이블 >");
//				list = ordersDao.selectAllFoodList(conn, 1);
//
//				for (FoodOrders food : list) {
//					System.out.println(food);
//				}
//
//				System.out.println();
//				System.out.print("합계: ");
//				System.out.print(ordersDao.selectTotalPrice(conn, 1));
//				System.out.print("원");
//				System.out.println();
//				System.out.println("└──────────┘");
//
//			}
//
//			// 2번
//
//			if (ordersDao.selectTotalPrice(conn, 2) == 0) {
//				System.out.println("┌──────────┐");
//				System.out.println("<2번 테이블 >");
//				System.out.println("(빈 테이블)");
//				System.out.println("└──────────┘");
//			} else {
//				System.out.println("┌──────────┐");
//				System.out.println("<2번 테이블 >");
//				list = ordersDao.selectAllFoodList(conn, 2);
//
//				for (FoodOrders food : list) {
//					System.out.println(food);
//				}
//				System.out.print("합계: ");
//				System.out.print(ordersDao.selectTotalPrice(conn, 2));
//				System.out.print("원");
//				System.out.println();
//				System.out.println("└──────────┘");
//
//			}
//
//			// 3번
//
//			if (ordersDao.selectTotalPrice(conn, 3) == 0) {
//				System.out.println("┌──────────┐");
//				System.out.println("<3번 테이블 >");
//				System.out.println("(빈 테이블)");
//				System.out.println("└──────────┘");
//			} else {
//				System.out.println("┌──────────┐");
//				System.out.println("<3번 테이블 >");
//				list = ordersDao.selectAllFoodList(conn, 3);
//
//				for (FoodOrders food : list) {
//					System.out.println(food);
//				}
//				System.out.print("합계: ");
//				System.out.print(ordersDao.selectTotalPrice(conn, 3));
//				System.out.print("원");
//				System.out.println();
//				System.out.println("└──────────┘");
//
//			}
//
//			// 4번
//
//			if (ordersDao.selectTotalPrice(conn, 4) == 0) {
//				System.out.println("┌──────────┐");
//				System.out.println("<4번 테이블 >");
//				System.out.println("(빈 테이블)");
//				System.out.println("└──────────┘");
//			} else {
//				System.out.println("┌──────────┐");
//				System.out.println("<4번 테이블 >");
//				list = ordersDao.selectAllFoodList(conn, 4);
//
//				for (FoodOrders food : list) {
//					System.out.println(food);
//				}
//				System.out.print("합계: ");
//				System.out.print(ordersDao.selectTotalPrice(conn, 4));
//				System.out.print("원");
//				System.out.println();
//				System.out.println("└──────────┘");
//
//			}
//
//			// 5번
//
//			if (ordersDao.selectTotalPrice(conn, 5) == 0) {
//				System.out.println("┌──────────┐");
//				System.out.println("<5번 테이블 >");
//				System.out.println("(빈 테이블)");
//				System.out.println("└──────────┘");
//			} else {
//				System.out.println("┌──────────┐");
//				System.out.println("<5번 테이블 >");
//				list = ordersDao.selectAllFoodList(conn, 5);
//
//				for (FoodOrders food : list) {
//					System.out.println(food);
//				}
//				System.out.print("합계: ");
//				System.out.print(ordersDao.selectTotalPrice(conn, 5));
//				System.out.print("원");
//				System.out.println();
//				System.out.println("└──────────┘");
//
//			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
