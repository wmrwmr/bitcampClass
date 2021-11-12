package members;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.BadInputController;
import controller.Menu;
import jdbc.ConnectionProvider;

public class MembersViewer {
	private Scanner scanner;
	private BadInputController inputC;
	MembersDao memDao = MembersDao.getInstance();
	List<Members> list = null;
	Connection conn = null;

	public MembersViewer(Scanner scanner, BadInputController inputC) {
		this.scanner = scanner;
		this.inputC = inputC;
	}

	public void manageMembers(int payment) {
		while (true) {
			try {
				conn = ConnectionProvider.getConnection();
				conn.setAutoCommit(false);

				System.out.println("---------------------------------------------------------");
				System.out.println("[" + Menu.INSERT + "] 새 회원 등록");
				System.out.println("[" + Menu.SEARCH_NAME + "] 이름으로 조회");
				System.out.println("[" + Menu.SEARCH_PHONE + "] 연락처 뒤 4자리로 조회");
				System.out.println("[" + Menu.SHOW_ALL + "] 전체 회원 보기");
				System.out.println("[" + Menu.EXIT + "] 뒤로 가기");
				int userChoice = inputC.checkUserChoice("\n> ", Menu.EXIT, Menu.SHOW_ALL);

				if (userChoice == Menu.INSERT) {
					insert(conn);

				} else if (userChoice == Menu.SEARCH_NAME) {
					searchName(payment);

				} else if (userChoice == Menu.SEARCH_PHONE) {
					searchPhone(payment);

				} else if (userChoice == Menu.SHOW_ALL) {
					showAll(payment);

				} else {
					System.out.println();
					break;
				}
			} catch (SQLException e) {
				System.out.println("<fail>");
			}
		}
	}

	private void insert(Connection conn) {
		try {
			String name = inputC.checkStr("새 회원의 이름을 입력해주세요.\n\n> ");
			String phone = inputC.checkPhoneNum("새 회원의 연락처를 입력해주세요.\n\n> ");

			Members mem = new Members(name, phone);

			int result = memDao.insertMember(conn, mem);

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

	private void searchName(int payment) {
		System.out.print("검색할 회원의 이름을 입력해주세요.\n\n> ");
		String name = scanner.nextLine();
		list = memDao.selectByName(conn, name);

		while (list.isEmpty()) {
			System.out.println("<조회한 이름의 회원이 없습니다>");
			System.out.println("---------------------------------------------------------");
			System.out.print("검색할 회원의 이름을 입력하시거나 취소하려면 [0]을 입력해주세요.\n\n> ");
			name = scanner.nextLine();

			if (name.equals("0")) {
				break;
			}
			list = memDao.selectByName(conn, name);

		}
		if (!list.isEmpty()) {
			System.out.println();
			System.out.println("=========================================================");
			System.out.println("회원번호\t이름\t연락처\t\t마일리지");
			System.out.println("=========================================================");
			for (Members mem : list) {
				System.out.println(mem);
			}
			manageOne(list, payment);
		}
	}

	private void searchPhone(int payment) {
		System.out.println("검색할 회원의 연락처 뒤 4자리를 입력해주세요.");
		String lastPN = inputC.checkInt("\n> ");
		list = memDao.selectByPhone(conn, lastPN);

		while (list.isEmpty()) {
			System.out.println("<조회한 연락처의 회원이 없습니다>");
			System.out.println("---------------------------------------------------------");
			System.out.println("검색할 회원의 연락처 뒤 4자리를 입력하시거나 취소하려면 [0]을 입력해주세요.");
			lastPN = inputC.checkInt("\n> ");

			if (lastPN.equals("0")) {
				break;
			}
			list = memDao.selectByPhone(conn, lastPN);
		}
		if (!list.isEmpty()) {
			System.out.println();
			System.out.println("=========================================================");
			System.out.println("회원번호\t이름\t연락처\t\t마일리지");
			System.out.println("=========================================================");
			for (Members mem : list) {
				System.out.println(mem);
			}
			manageOne(list, payment);
		}
	}

	private void showAll(int payment) {
		list = memDao.selectAllMembers(conn);
		if (!list.isEmpty()) {
			System.out.println();
			System.out.println("=========================================================");
			System.out.println("회원번호\t이름\t연락처\t\t마일리지");
			System.out.println("=========================================================");
			for (Members mem : list) {
				System.out.println(mem);
			}
			manageOne(list, payment);

		} else {
			System.out.println("<등록된 회원이 없습니다.>");
			System.out.println("---------------------------------------------------------");
			System.out.println("[확인] 계속 진행하려면 엔터를 눌러주세요.\n");
			scanner.nextLine();
		}
	}

	private void manageOne(List<Members> list, int payment) {
		System.out.println("---------------------------------------------------------");
		System.out.println("[" + Menu.ADD_BONUS + "] 마일리지 적립");
		System.out.println("[" + Menu.UPDATE + "] 회원정보 변경");
		System.out.println("[" + Menu.DELETE + "] 회원정보 삭제");
		System.out.println("[" + Menu.EXIT + "] 뒤로 가기");
		int userChoice = inputC.checkUserChoice("\n> ", Menu.EXIT, Menu.DELETE);

		if (userChoice != 0) {
			System.out.println("---------------------------------------------------------");
			System.out.println("회원의 회원번호를 입력하거나 취소하려면 [0]을 입력해주세요.");

			int checkMid = 0;
			while (checkMid == 0) {
				int mid = inputC.checkUserChoice("\n> ", 0, list.get(list.size() - 1).getMid());

				checkMid = 0;
				if (mid != 0) {
					for (Members mem : list) {
						if (mem.getMid() == mid) {
							checkMid = 1;
							break;
						}
					}
					if (checkMid == 0) {
						System.out.println("(잘못 입력하셨습니다.)");
					} else {
						if (userChoice == Menu.ADD_BONUS) {
							addBonus(mid, payment);
						} else if (userChoice == Menu.UPDATE) {
							update(mid);
						} else if (userChoice == Menu.DELETE) {
							delete(mid);
						}
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

	private void addBonus(int mid, int payment) {
		try {
			if (payment == 0) {
				System.out.println("---------------------------------------------------------");
				System.out.println("적립할 금액을 입력해주세요.");
				payment = (inputC.checkUserChoice("\n> ", 0, 100000)) * 20;
			}

			memDao.addBonus(conn, mid, payment);

			conn.commit();
			System.out.println("<적립이 완료되었습니다.>");
			payment = 0;

		} catch (SQLException e) {
			System.out.println("<fail>");
		}
	}

	private void update(int mid) {
		try {
			String name = inputC.checkStr("변경할 회원의 이름을 입력해주세요.\n\n> ");
			String phone = inputC.checkPhoneNum("변경할 회원의 연락처를 입력해주세요.\n\n> ");

			int result = memDao.updateMember(conn, mid, name, phone);

			if (result == 1) {
				conn.commit();
				System.out.println("<회원정보 변경이 완료되었습니다.>");
			}

		} catch (SQLException e) {
			System.out.println("<fail>");
		}
	}

	private void delete(int mid) {
		try {
			int result = memDao.deleteMember(conn, mid);

			if (result == 1) {
				conn.commit();
				System.out.println("<회원정보가 삭제되었습니다.>");
			}

		} catch (SQLException e) {
			System.out.println("<fail>");
		}
	}
}
