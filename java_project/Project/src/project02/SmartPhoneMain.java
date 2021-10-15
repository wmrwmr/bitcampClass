package project02;

public class SmartPhoneMain {
	public static void main(String[] args) {
		SmartPhoneManager manager = new SmartPhoneManager();

		while (true) {
			manager.printMenu();
			int select = Integer.parseInt(SmartPhoneManager.sc.nextLine());

			switch (select) {
			case 1:
				manager.insertContact();
				;
				break;
			case 2:
				System.out.println("전체 데이터를 출력합니다.");

				manager.showAllData();
				break;
			case 3:
				System.out.println("연락처 정보를 검색합니다.");

				manager.searchData();
				break;
			case 4:
				System.out.println("연락처 정보를 삭제합니다.");

				manager.deleteContact();
				break;

			case 5:
				System.out.println("연락처 정보를 수정합니다.");

				manager.updateContact();
				break;
			case 6:
				System.out.println("프로그램을 종료 합니다.");
				return;

			}
		}

	}

}
