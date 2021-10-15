package chapter06;

public class ScoreMain02 {
	public static void main(String[] args) {
		ScoreManager manager = new ScoreManager();

		// 사용자가 Student 데이터를 입력해야 한다.
		// 사용자가 데이터입력/검색/출력/삭제/프로그램 종료 선택한다!

		while (true) {
			manager.printMenu();
			int select = Integer.parseInt(ScoreManager.sc.nextLine());
			
			switch (select) {
			case 1: // 점수 입력기능
				System.out.println("점수 데이터를 입력합니다.");
				manager.insertStudent();
				;
				break;
			case 2:
				System.out.println("전체 데이터를 출력합니다.");

				manager.showAllData();
				break;
			case 3:
				System.out.println("학생 정보를 검색합니다.");

				manager.searchData();
				break;
			case 4:
				System.out.println("학생 정보를 삭제합니다.");

				manager.deleteScore();
				break;
			case 5:
				System.out.println("프로그램을 종료 합니다.");
				return;

			}
		}

	}


}
