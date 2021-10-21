package project06;

import java.util.Scanner;

public class SmartPhoneMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SmartPhoneManager manager = new SmartPhoneManager();

		while (true) {

			try {
				manager.printMenu();
				int select = Integer.parseInt(readMenu());

				switch (select) {
				case 1:
					System.out.println("1. 회사 2. 거래처");

					select = Integer.parseInt(SmartPhoneManager.sc.nextLine());
					if (select == 1) {
						manager.addContact(1);
					} else if (select == 2) {
						manager.addContact(2);
					} else {
						break;
					}

					break;
				case 2:
					System.out.println("연락처 정보를 검색합니다.");

					manager.searchData();
					break;

				case 3:

					System.out.println("회사 연락처 수정은 1, 거래처 연락처 수정은 2를 입력해주세요");
					int userChoice = Integer.parseInt(sc.nextLine());
					if (userChoice == 1) {

						manager.updateCompanyContact();
					} else if (userChoice == 2) {
						manager.updateCustomerContact();
					} else {
						System.out.println("잘못 입력 하셨습니다");
						break;
					}
					break;

				case 4:
					System.out.println("연락처 정보를 삭제합니다.");

					manager.deleteContact();
					break;
				case 5:
					System.out.println("전체 데이터를 출력합니다.");

					manager.showAllData();
					break;

				case 6:
					System.out.println("프로그램을 종료 합니다.");
					return;

				}
			} catch (NumberFormatException n) {
				System.out.println("잘못 입력하셨습니다.");

			} catch (MenuException m) {
				System.out.println(m.getMessage());

			}

		}

	}

	public static String readMenu() throws MenuException {
		Scanner sc = new Scanner(System.in);
		String select = sc.nextLine();
		if (!(select.matches("^[1-6]"))) {
			MenuException excpt = new MenuException();
			throw excpt;
		}
		return select;
	}

}
