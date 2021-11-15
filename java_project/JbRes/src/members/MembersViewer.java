package members;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import controller.BadInputController;
import controller.Menu;
import jdbc.ConnectionProvider;

public class MembersViewer {
	private BadInputController inputC;
	MembersDao memDao = MembersDao.getInstance();
	List<Members> list = null;
	Connection conn = null;
	static private int payment = 0;

	public MembersViewer(BadInputController inputC) {
		this.inputC = inputC;
	}

	public void manageMembers(int total, int exitCode) {
		while (true) {
			payment = total;
			try {
				conn = ConnectionProvider.getConnection();
				conn.setAutoCommit(false);

				System.out.println();
				System.out.println("-------------------------------------------------------------------");
				System.out.print(Menu.INSERT + ". 새 회원 등록    ");
				System.out.print(Menu.SEARCH_NAME + ". 이름으로 조회    ");
				System.out.print(Menu.SEARCH_PHONE + ". 연락처 뒷자리로 조회    ");
				System.out.print(Menu.SHOW_ALL + ". 전체 회원 보기    ");
				System.out.print(Menu.EXIT + ". 뒤로 가기");
				System.out.println();
				System.out.println("-------------------------------------------------------------------");
				int userChoice = inputC.checkInt("> ", Menu.EXIT, Menu.SHOW_ALL);

				if (userChoice == Menu.INSERT) {
					insert(conn);

				} else if (userChoice == Menu.SEARCH_NAME) {
					searchByName(exitCode);

				} else if (userChoice == Menu.SEARCH_PHONE) {
					searchByPhone(exitCode);

				} else if (userChoice == Menu.SHOW_ALL) {
					showAll(exitCode);
				} else {
					break;
				}
				if (exitCode == 1 && payment == 0) {
					break;
				}
			} catch (SQLException e) {
				System.out.println("<fail>");
			}
		}
	}

	private void insert(Connection conn) {
		try {
			String name = inputC.checkStrDial("새 회원의 이름을 입력해주세요.");
			if (name != null) {
				String phone = inputC.checkPhoneNumDial("새 회원의 연락처를 입력해주세요.\n(예: 010-2233-4455)");
				if (phone != null) {
					int yesNo = JOptionPane.showConfirmDialog(null, "이름: " + name + "\n연락처: " + phone + "\n등록 하시겠습니까?",
							"", JOptionPane.YES_NO_OPTION);

					if (yesNo == JOptionPane.YES_OPTION) {
						Members mem = new Members(name, phone);
						int result = memDao.insertMember(conn, mem);

						if (result == 1) {
							conn.commit();
							JOptionPane.showMessageDialog(null, "등록이 완료되었습니다.");
						}
					} else {
						JOptionPane.showMessageDialog(null, "등록이 취소되었습니다.");
					}
				}
			}
		} catch (SQLException e) {
			System.out.println("<fail>");
		}
	}

	private void searchByName(int exitCode) {
		String name = inputC.checkStrDial("조회할 회원의 이름을 입력해주세요.");
		if (name != null) {
			list = memDao.selectByName(conn, name);

			while (list.isEmpty()) {
				name = inputC.checkStrDial("(조회한 이름의 회원이 없습니다.)\n조회할 회원의 이름을 입력해주세요.");
				list = memDao.selectByName(conn, name);
				if (name == null) {
					break;
				}
			}
			while (!list.isEmpty()) {
				list = memDao.selectByName(conn, name);
				System.out.println();
				System.out.println();
				System.out.println("              < 이름 조회 결과  >");
				printList();
				int exit = manageOne(exitCode);
				if (exit == 0) {
					break;
				}
				if (exitCode == 1 && payment == 0) {
					break;
				}
			}
		}
	}

	private void searchByPhone(int exitCode) {
		String lastPN = inputC.checkIntDial("조회할 회원의 연락처 뒷자리를 입력해주세요.");
		if (lastPN != null) {
			list = memDao.selectByPhone(conn, lastPN);

			while (list.isEmpty()) {
				lastPN = inputC.checkIntDial("(조회한 연락처의 회원이 없습니다.)\n조회할 회원의 연락처 뒷자리를 입력해주세요.");
				list = memDao.selectByPhone(conn, lastPN);
				if (lastPN == null) {
					break;
				}
			}
			while (!list.isEmpty()) {
				list = memDao.selectByPhone(conn, lastPN);
				System.out.println();
				System.out.println();
				System.out.println("             < 연락처 조회 결과  >");
				printList();
				int exit = manageOne(exitCode);
				if (exit == 0) {
					break;
				}
				if (exitCode == 1 && payment == 0) {
					break;
				}
			}
		}
	}

	private void showAll(int exitCode) {
		list = memDao.selectAllMembers(conn);
		while (!list.isEmpty()) {
			if (list.isEmpty()) {
				JOptionPane.showMessageDialog(null, "등록된 회원이 없습니다.");
			} else {
				list = memDao.selectAllMembers(conn);
				System.out.println();
				System.out.println();
				System.out.println("             < 전체 고객 리스트  >");
				printList();
				int exit = manageOne(exitCode);
				if (exit == 0) {
					break;
				}
			}
			if (exitCode == 1 && payment == 0) {
				break;
			}
		}
	}

	private void printList() {
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("회원번호\t이름\t연락처\t\t마일리지");
		System.out.println("────────────────────────────────────────");
		for (Members mem : list) {
			System.out.println("  " + mem);
		}
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println();
	}

	private int manageOne(int exitCode) {
		int exit = 1;
		if (list.isEmpty()) {
			JOptionPane.showMessageDialog(null, "표시할 회원이 없습니다.");
		} else {
			System.out.println();
			System.out.println("-------------------------------------------------------------------");
			System.out.print(Menu.ADD_BONUS + ". 마일리지 적립    ");
			System.out.print(Menu.UPDATE + ". 회원정보 변경    ");
			System.out.print(Menu.DELETE + ". 회원정보 삭제    ");
			System.out.print(Menu.EXIT + ". 뒤로 가기");
			System.out.println();
			System.out.println("-------------------------------------------------------------------");
			int userChoice = inputC.checkInt("> ", Menu.EXIT, Menu.DELETE);

			if (userChoice != 0) {
				if (list.size() == 1) {
					int mid = list.get(0).getMid();

					if (userChoice == Menu.ADD_BONUS) {
						addBonus(mid, exitCode);
					} else if (userChoice == Menu.UPDATE) {
						update(mid);
					} else if (userChoice == Menu.DELETE) {
						delete(mid);
					}
				} else {
					checkMid(userChoice, exitCode);
				}
			} else {
				exit = 0;
			}
		}
		return exit;
	}

	private void checkMid(int userChoice, int exitCode) {
		System.out.println();
		System.out.println("-------------------------------------------------------------------");
		System.out.println("회원의 회원번호를 입력하거나 취소하려면 [0]을 입력해주세요.");
		System.out.println("-------------------------------------------------------------------");

		int checkMid = 0;
		while (checkMid == 0) {
			int mid = Integer.parseInt(inputC.checkInt("> "));

			if (mid != 0) {
				for (Members mem : list) {
					if (mem.getMid() == mid) {
						checkMid = 1;
						break;
					}
				}
				if (checkMid == 0) {
					System.out.println("(잘못 입력하셨습니다.)\n");
				} else {
					if (userChoice == Menu.ADD_BONUS) {
						addBonus(mid, exitCode);
					} else if (userChoice == Menu.UPDATE) {
						update(mid);
					} else if (userChoice == Menu.DELETE) {
						delete(mid);
					}
				}
			} else {
				break;
			}
		}
	}

	private void addBonus(int mid, int exitCode) {
		try {
			if (exitCode == 0) {
				payment = inputC.checkIntDial("적립할 금액을 입력해주세요.", 1, 100000) * 20;

				if (payment != 0) {
					memDao.addBonus(conn, mid, payment);
					conn.commit();
					JOptionPane.showMessageDialog(null, "적립이 완료되었습니다.");
					payment = 0;

				}
			} else {
				memDao.addBonus(conn, mid, payment);
				conn.commit();
				JOptionPane.showMessageDialog(null, "적립이 완료되었습니다.");
				payment = 0;
			}
		} catch (SQLException e) {
			System.out.println("<fail>");
		}
	}

	private void update(int mid) {
		try {
			String name = inputC.checkStrDial("회원의 새 이름을 입력해주세요.");
			if (name != null) {
				String phone = inputC.checkPhoneNumDial("회원의 새 연락처를 입력해주세요.\n(예: 010-2233-4455)");
				if (phone != null) {
					int yesNo = JOptionPane.showConfirmDialog(null,
							"이름: " + name + "\n연락처: " + phone + "\n정말 변경 하시겠습니까?", "", JOptionPane.YES_NO_OPTION);

					if (yesNo == JOptionPane.YES_OPTION) {
						int result = memDao.updateMember(conn, mid, name, phone);

						if (result == 1) {
							conn.commit();
							JOptionPane.showMessageDialog(null, "회원정보 변경이 완료되었습니다.");
						}
					} else {
						JOptionPane.showMessageDialog(null, "변경이 취소되었습니다.");
					}
				}
			}
		} catch (SQLException e) {
			System.out.println("<fail>");
		}
	}

	private void delete(int mid) {
		try {
			int yesNo = JOptionPane.showConfirmDialog(null, "정말 삭제 하시겠습니까?", "", JOptionPane.YES_NO_OPTION);

			if (yesNo == JOptionPane.YES_OPTION) {
				int result = memDao.deleteMember(conn, mid);

				if (result == 1) {
					conn.commit();
					JOptionPane.showMessageDialog(null, "회원정보가 삭제되었습니다.");
				}
			}
		} catch (SQLException e) {
			System.out.println("<fail>");
		}
	}
}
