package chapter07;

import java.util.Scanner;

public class FriendInfoMain {

	public static void main(String[] args) {
		
		FriendInfoHandler handler = new FriendInfoHandler();
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("##### 메뉴 선택 #####");
			System.out.println(Menu.INSERT_HIGH + ". 고교 친구 정보 저장");
			System.out.println(Menu.INSERT_UNIV + ". 대학 친구 정보 저장");
			System.out.println(Menu.SHOW_ALL + ". 전체 정보 출력");
			System.out.println(Menu.SHOW_BASIC + ". 기본 정보 출력");
			System.out.println(Menu.EXIT + ". 프로그램 종료");
			System.out.println("메뉴 선택>>");
			
			
			
			int select = Integer.parseInt(sc.nextLine());
			
			switch(select) {
			case Menu.INSERT_HIGH: case Menu.INSERT_UNIV: 
				handler.addFriend(select);
				break;
			case Menu.SHOW_ALL: 
				handler.showAllData();
				break;
			case Menu.SHOW_BASIC: 
				handler.ShowAllSimpleData();
				break;
			case Menu.EXIT: 
				System.out.println("프로그램을 종료합니다.");
				System.exit(0); // return;
			}
			
		}

	}

}
