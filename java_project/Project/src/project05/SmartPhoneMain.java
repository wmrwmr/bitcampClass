package project05;

//2. 입력 또는 수정할 때 공백 문자열을 입력 받으면 다시 입력 받도록 흐름을 만들어봅시다.
//
//3. 입력할 때 전화번호가 같은 데이터가 입력되면 입력이 되지 않도록 흐름을 만들어봅시다.

import java.util.Scanner;


public class SmartPhoneMain extends VacuumException {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SmartPhoneManager manager = new SmartPhoneManager();

		while (true) {
			manager.printMenu();
			int select = Integer.parseInt(SmartPhoneManager.sc.nextLine());

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

		}

	}

}
