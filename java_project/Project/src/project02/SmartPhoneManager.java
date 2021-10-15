package project02;

import java.util.Scanner;

public class SmartPhoneManager {
	public static final Scanner sc = new Scanner(System.in);

	private Contact[] c;
	private int numOfContact;

	public SmartPhoneManager(int size) {
		c = new Contact[size];
		numOfContact = 0;

	}

	public SmartPhoneManager() {
		this(10);
	}

	public void showAllData() {
		System.out.println("----------------------------------------------");
		System.out.println("연락처 리스트");
		for (int i = 0; i < numOfContact; i++) {
			System.out.println("----------------------------------------------");
			System.out.println(c[i].getName());
			System.out.println("----------------------------------------------");
			System.out.println(c[i]);
		}

	}

	public void insertContact(Contact s) {
		c[numOfContact++] = s;

	}

	public void searchData() {
		System.out.println("검색하고자 하는 연락처의 이름을 입력해주세요");
		String name = sc.nextLine();

		int index = searchIndex(name);

		if (index > -1) {
			System.out.println(c[index]);
		} else {
			System.out.println("검색하신 이름의 데이터가 존재하지 않습니다.");
		}

	}

	public void deleteContact() {
		System.out.println("삭제하고자 하는 연락처의 이름을 입력해주세요");
		String name = sc.nextLine();

		int index = searchIndex(name);

		if (index > -1) {

			for (int i = index; i < numOfContact - 1; i++) {
				c[i] = c[i + 1];
			}
			numOfContact--;
			System.out.println("데이터가 삭제되었습니다.");
		} else {
			System.out.println("검색하신 이름의 데이터가 존재하지 않습니다.");
		}

	}

	private int searchIndex(String name) {
		int index = -1;

		for (int i = 0; i < numOfContact; i++) {
			if (c[i].getName().equals(name)) {
				index = i;
				break;
			}
		}

		return index;
	}

	public void insertContact() {
		System.out.println("연락처 데이터를 입력합니다.");
		System.out.println("이름>> ");
		String name = sc.nextLine();
		System.out.println("전화번호>>");
		String phoneNumber = sc.nextLine();
		System.out.println("이메일>>");
		String email = sc.nextLine();
		System.out.println("주소>>");
		String address = sc.nextLine();
		System.out.println("생일>>");
		String birthDay = sc.nextLine();
		System.out.println("그룹>>");
		String group = sc.nextLine();

		insertContact(new Contact(name, phoneNumber, email, address, birthDay, group));
		System.out.println("연락처 데이터가 입력 되었습니다.");

	}

	public void updateContact() {

		System.out.println("수정하고자 하는 연락처의 이름을 입력해주세요");
		String name = sc.nextLine();

		int index = searchIndex(name);

		if (index > -1) {
			System.out.println(name + "의 연락처 데이터를 수정합니다.");
			System.out.println("새로운 전화번호>>");
			c[index].setPhoneNumber(sc.nextLine());
			System.out.println("새로운 이메일>>");
			c[index].setEmail(sc.nextLine());
			System.out.println("새로운 주소>>");
			c[index].setAddress(sc.nextLine());
			System.out.println("새로운 생일>>");
			c[index].setBirthDay(sc.nextLine());
			System.out.println("새로운 그룹>>");
			c[index].setGroup(sc.nextLine());

			System.out.println("연락처 데이터가 수정 되었습니다.");
		} else {
			System.out.println("검색하신 이름의 데이터가 존재하지 않습니다.");
		}

	}

	public void printMenu() {

		System.out.println("--------------------");
		System.out.println("연락처 관리 프로그램");
		System.out.println("--------------------");
		System.out.println("1. 연락처 입력");
		System.out.println("2. 전체 연락처 출력");
		System.out.println("3. 이름으로 연락처 검색");
		System.out.println("4. 연락처 삭제");
		System.out.println("5. 연락처 수정");
		System.out.println("6. 프로그램 종료");
		System.out.println("--------------------");
		System.out.println("메뉴 번호를 입력해주세요 >>>>>");
	}

}
