package ver02;

public class SmartPhoneMain2 {

	public static void main(String[] args) {
		
		// ①SmartPhone 클래스의 인스턴스를 생성합니다.
		SmartPhone phone = new SmartPhone(10);
		
		
		while(true) {
			
			System.out.println("### 전화번호관리 프로그램 ###");
			System.out.println("1. 전화번호 등록");
			System.out.println("2. 전화번호 검색 (이름으로 검색)");
			System.out.println("3. 전화번호 삭제 (이름으로 검색)");
			System.out.println("4. 전화번호 수정 (이름으로 검색)");
			System.out.println("5. 전화번호 전체 출력");
			System.out.println("6. 프로그램 종료");
			System.out.println("메뉴 선택하세요 >>>>>>>>>>>>>>> ");
			
			int select = Integer.parseInt(SmartPhone.sc.nextLine());
			
			switch(select) {
			case 1:
				phone.insertContact();
				break;
			case 2:
				phone.searchPrint();
				break;
			case 3:
				phone.deleteContact();
				break;
			case 4:
				phone.editContact();
				break;
			case 5:
				phone.printAllData();
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				//return;
				System.exit(0);
			}
		}
		
	}

}
