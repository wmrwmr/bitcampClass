package food;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import controller.BadInputController;
import controller.Menu;
import jdbc.ConnectionProvider;

public class FoodViewer {
	private Scanner scanner;
	private BadInputController inputC;
	FoodDao foodDao = FoodDao.getInstance();
	List<Food> list = null;
	Connection conn = null;

	public FoodViewer(Scanner scanner, BadInputController inputC) {
		this.scanner = scanner;
		this.inputC = inputC;
	}

	public void manageFood() {
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			System.out.println("---------------------------------------------------------");
			System.out.println("[" + Menu.SHOW_ALL + "] 현재 음식 목록");
			System.out.println("[" + Menu.INSERT + "] 새 음식 등록");
			System.out.println("[" + Menu.EXIT + "] 뒤로 가기");
			int userChoice = inputC.checkUserChoice("\n> ", Menu.EXIT, Menu.SHOW_ALL);

			if (userChoice == Menu.INSERT) {
				insert(conn);

			} else if (userChoice == Menu.EXIT) {
				// 뒤로가기

			} else if (userChoice == Menu.SHOW_ALL) {
				showAll();
			}
		} catch (SQLException e) {
			System.out.println("<fail>");
		}
	}

	private void insert(Connection conn) {
		try {
			String name = inputC.checkStr("새 음식의 이름을 입력해주세요.\n\n> ");
			String price1 = inputC.checkInt("새 음식의 가격을 입력해주세요.\n\n> ");
			int price2 = Integer.parseInt(price1);

			Food food = new Food(name, price2);

			int result = foodDao.insertFood(conn, food);
			if (result == 1) {
				conn.commit();
				System.out.println("<등록이 완료되었습니다.>");
			}
			System.out.println("---------------------------------------------------------");
			System.out.println("[확인] 계속 진행하려면 엔터를 눌러주세요.\n");
			scanner.nextLine();

		} catch (SQLException e) {
			System.out.println("<fail>");
		}
	}

	private void update(int fid) {
		try {
			String fname = inputC.checkStr("수정할 음식 이름을 입력하세요");
			String fprice1 = inputC.checkInt("수정할 음식 가격을 입력하세요");
			int fprice2 = Integer.parseInt(fprice1);

			int result = foodDao.updateFood(conn, fid, fname, fprice2);
			if (result == 1) {
				conn.commit();
				System.out.println("<음식정보 변경이 완료되었습니다.>");
			}

		} catch (SQLException e) {
			System.out.println("<fail>");
		}
	}

	private void foodManager(List<Food> list) {
		System.out.println("[" + Menu.UPDATE + "] 음식 정보 변경");
		System.out.println("[" + Menu.DELETE + "] 음식 정보 삭제");
		System.out.println("[" + Menu.EXIT + "] 뒤로 가기");
		int userChoice = inputC.checkUserChoice("\n> ", Menu.EXIT, Menu.DELETE);
		if (userChoice != 0) {
			System.out.println("---------------------------------------------------------");
			System.out.println("음식 번호를 입력하거나 취소하려면 [0]을 입력해주세요.");

			int checkFid = 0;
			while (checkFid == 0) {
				int fid = inputC.checkUserChoice("\n> ", 0, list.get(list.size() - 1).getFid());

				checkFid = 0;
				if (fid != 0) {
					for (Food food : list) {
						if (food.getFid() == fid) {
							checkFid = 1;
							break;
						}
					}
					if (checkFid == 0) {
						manageFood();
					} else {
						if (userChoice == Menu.UPDATE) {
							update(fid);
						} else if (userChoice == Menu.DELETE) {
							delete(fid);
						} else if (userChoice == Menu.EXIT)
							manageFood();
						System.out.println("---------------------------------------------------------");
						System.out.println("[확인] 계속 진행하려면 엔터를 눌러주세요.\n");
						scanner.nextLine();
					}
				} else {
					break;
				}
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

	private void showAll() {
		list = foodDao.selectAllFood(conn);
		if (!list.isEmpty()) {
			System.out.println("=========================================================");
			System.out.println("음식 번호\t음식명\t가격\t");
			System.out.println("=========================================================");

			for (Food food : list) {
				System.out.println(food);
			}
		}
	}
}
