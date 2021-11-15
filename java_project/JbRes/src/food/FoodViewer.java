package food;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import controller.BadInputController;
import controller.Menu;
import jdbc.ConnectionProvider;
import members.Members;
import members.MembersDao;
import orders.Orders;

public class FoodViewer {
	private Scanner scanner;
	private BadInputController inputC;
	FoodDao foodDao = FoodDao.getInstance();
	List<Food> list = null;
	Connection conn = null;

	static private FoodViewer dao = new FoodViewer();

	static public FoodViewer getInstance() {
		return dao;
	}

	private FoodViewer() {
	}

	public FoodViewer(Scanner scanner, BadInputController inputC) {
		this.scanner = scanner;
		this.inputC = inputC;
	}

	public void manageFood() {
		while (true) {
			try {
				conn = ConnectionProvider.getConnection();
				conn.setAutoCommit(false);

				System.out.println();
				System.out.println("-------------------------------------------------------------------");
				System.out.print(Menu.F_SHOW_ALL + ". 현재 음식 목록   ");
				System.out.print(Menu.F_INSERT + ". 새 음식 등록   ");
				System.out.print(Menu.F_EXIT + ". 뒤로 가기\n");
				System.out.println("-------------------------------------------------------------------");
				int userChoice = inputC.checkInt("> ", Menu.F_SHOW_ALL, Menu.F_EXIT);

				if (userChoice == Menu.F_INSERT) {
					insert(conn);

				} else if (userChoice == Menu.F_EXIT) {
					break;

				} else if (userChoice == Menu.F_SHOW_ALL) {
					showAll();
					foodManager(list);

				}
			} catch (SQLException e) {
				System.out.println("<fail>");
			}
		}
	}

	private void insert(Connection conn) {
		try {
			System.out.println();
			System.out.println("-------------------------------------------------------------------");
			System.out.println("새 음식의 이름을 입력해주세요.");
			System.out.println("-------------------------------------------------------------------");
			String name = inputC.checkStr("> ");
			System.out.println();
			System.out.println("-------------------------------------------------------------------");
			System.out.println("새 음식의 가격을 입력해주세요.");
			System.out.println("-------------------------------------------------------------------");
			String price1 = inputC.checkInt("> ");
			int price2 = Integer.parseInt(price1);

			Food food = new Food(name, price2);

			int result = foodDao.insertFood(conn, food);
			if (result == 1) {
				conn.commit();
				System.out.println("<등록이 완료되었습니다.>");
			}
			System.out.println("-------------------------------------------------------------------");
			System.out.println("[확인] 계속 진행하려면 엔터를 눌러주세요.");
			scanner.nextLine();

		} catch (SQLException e) {
			System.out.println("<fail>");
		}
	}

	private void update(int fid) {
		try {
			System.out.println();
			System.out.println("-------------------------------------------------------------------");
			System.out.println("수정할 음식의 이름을 입력해주세요.");
			System.out.println("-------------------------------------------------------------------");
			String fname = inputC.checkStr("> ");
			System.out.println();
			System.out.println("-------------------------------------------------------------------");
			System.out.println("수정할 음식의 가격을 입력해주세요.");
			System.out.println("-------------------------------------------------------------------");
			String fprice1 = inputC.checkInt("> ");

			int fprice2 = Integer.parseInt(fprice1);

			int result = foodDao.updateFood(conn, fid, fname, fprice2);
			if (result == 1) {
				conn.commit();
				System.out.println("<음식정보 변경이 완료되었습니다.>");
				System.out.println("-------------------------------------------------------------------");
				System.out.println("[확인] 계속 진행하려면 엔터를 눌러주세요.");
				scanner.nextLine();
			}

		} catch (SQLException e) {
			System.out.println("<fail>");
		}
	}

	private void foodManager(List<Food> list) {
		while (true) {
			System.out.println();
			System.out.println("-------------------------------------------------------------------");
			System.out.print(Menu.F_UPDATE + ". 음식 정보 변경   ");
			System.out.print(Menu.F_DELETE + ". 음식 정보 삭제   ");
			System.out.print(Menu.F_EXIT + ". 뒤로 가기\n");
			System.out.println("-------------------------------------------------------------------");
			int userChoice = inputC.checkInt("> ", Menu.F_UPDATE, Menu.F_EXIT);

			if (userChoice == Menu.F_UPDATE) {
				System.out.println();
				System.out.println("-------------------------------------------------------------------");
				System.out.println("음식 번호를 입력하거나 취소하려면 [0]을 입력해주세요.");
				System.out.println("-------------------------------------------------------------------");
				int fid = inputC.checkInt("> ", 0, list.get(list.size() - 1).getFid());
				update(fid);
				break;
			} else if (userChoice == Menu.F_DELETE) {
				System.out.println();
				System.out.println("-------------------------------------------------------------------");
				System.out.println("음식 번호를 입력하거나 취소하려면 [0]을 입력해주세요.");
				System.out.println("-------------------------------------------------------------------");
				int fid = inputC.checkInt("> ", 0, list.get(list.size() - 1).getFid());
				delete(fid);
				break;
			} else if (userChoice == Menu.F_EXIT) {
				break;
			}
		}
	}

	private void delete(int fid) {
		try {
			int result = foodDao.deleteFood(conn, fid);

			if (result == 1) {
				conn.commit();
				System.out.println("<음식 정보가 삭제되었습니다.>");
			}

		} catch (SQLException e) {
			System.out.println("<fail>");
		}
	}

	public void showAll() {
		try {
			conn = ConnectionProvider.getConnection();
			list = foodDao.selectAllFood(conn);
			if (!list.isEmpty()) {
				System.out.println();
				System.out.println();
				System.out.println("           < 자비레스 메뉴  >");
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
				System.out.println("음식 번호\t음식명\t\t가격\t");
				System.out.println("──────────────────────────────────");

				for (Food f : list) {
					String fname = f.getFname();
					
					for (int i = 1; i <= 6; i++) {
						String space = "";
						for (int j = i; j <= 6; j++) {
							if (fname.length() == i) {
								space += "　";
							}
						}
						fname += space;
					}
					if (fname.length() > 9) {
						fname = fname.substring(0, 8);
						fname += "...";
					}

					System.out.println(f.getFid() + "\t" + fname + "\t" + f.getFprice());
				}
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
				System.out.println();
			}
		} catch (SQLException e) {
			System.out.print("");
		}
	}
}
