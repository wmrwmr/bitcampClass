package members;

import java.sql.Connection;
import java.sql.SQLException;
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

	public void manageMembers() {
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
				searchName();

			} else if (userChoice == Menu.SEARCH_PHONE) {
				searchPhone();

			} else if (userChoice == Menu.SHOW_ALL) {
				showAll();

			} else if (userChoice == Menu.EXIT) {
				// 뒤로가기
			}
		} catch (SQLException e) {
			System.out.println("<fail>");
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

	private void searchName() {
		System.out.print("검색할 회원의 이름을 입력해주세요.\n\n> ");
		String name = scanner.nextLine();
		list = memDao.selectByName(conn, name);

		while (list.isEmpty()) {
			System.out.println("<조회한 이름의 회원이 없습니다>");
			System.out.println("---------------------------------------------------------");
			System.out.print("검색할 회원의 이름을 입력하시거나 취소하려면 0을 입력해주세요.\n\n> ");
			name = scanner.nextLine();
			list = memDao.selectByName(conn, name);

			if (name.equals("0")) {
				System.out.println();
				break;
			}
		}
		if (!list.isEmpty()) {
			System.out.println("=========================================================");
			System.out.println("회원번호\t이름\t연락처\t\t방문횟수\t회원등급");
			System.out.println("=========================================================");
			for (Members mem : list) {
				System.out.println(mem);

				// mid선택

				// 1. 방문횟수 등록
				// System.out.println("[" + Menu.M_UPDATE + "] 2. 회원정보 수정");
				// System.out.println("[" + Menu.M_DELETE + "] 3. 회원정보 삭제");
			}
			System.out.println("---------------------------------------------------------");
			System.out.println("[확인] 계속 진행하려면 엔터를 눌러주세요.\n");
			scanner.nextLine();
		}
	}

	private void searchPhone() {
		String lastPN = inputC.checkInt("검색할 회원의 연락처 뒤 4자리를 입력해주세요.\n\n> ");
		list = memDao.selectByPhone(conn, lastPN);

		while (list.isEmpty()) {
			System.out.println("<조회한 연락처의 회원이 없습니다>");
			lastPN = inputC.checkInt("검색할 회원의 연락처 뒤 4자리를 입력하시거나 취소하려면 0을 입력해주세요.\n\n> ");

			if (lastPN.equals("0")) {
				System.out.println();
				break;
			}
			list = memDao.selectByPhone(conn, lastPN);
		}
		if (!list.isEmpty()) {
			System.out.println("=========================================================");
			System.out.println("회원번호\t이름\t연락처\t\t방문횟수\t회원등급");
			System.out.println("=========================================================");
			for (Members mem : list) {
				System.out.println(mem);

				// mid선택

				// 1. 방문횟수 등록
				// System.out.println("[" + Menu.M_UPDATE + "] 2. 회원정보 수정");
				// System.out.println("[" + Menu.M_DELETE + "] 3. 회원정보 삭제");
			}
			System.out.println("---------------------------------------------------------");
			System.out.println("[확인] 계속 진행하려면 엔터를 눌러주세요.\n");
			scanner.nextLine();
		}
	}

	private void showAll() {
		list = memDao.selectAllMembers(conn);
		if (!list.isEmpty()) {
			System.out.println("=========================================================");
			System.out.println("회원번호\t이름\t연락처\t\t방문횟수\t회원등급");
			System.out.println("=========================================================");
			for (Members mem : list) {
				System.out.println(mem);

				// mid선택

				// 1. 방문횟수 등록
				// System.out.println("[" + Menu.M_UPDATE + "] 2. 회원정보 수정");
				// System.out.println("[" + Menu.M_DELETE + "] 3. 회원정보 삭제");
			}
			System.out.println("---------------------------------------------------------");
			System.out.println("[확인] 계속 진행하려면 엔터를 눌러주세요.\n");
			scanner.nextLine();
		} else {
			System.out.println("<등록된 회원이 없습니다.>");
			System.out.println("---------------------------------------------------------");
			System.out.println("[확인] 계속 진행하려면 엔터를 눌러주세요.\n");
			scanner.nextLine();
		}
	}

	// 회원등록 여부 물어보기 -> 방문횟수++

}
