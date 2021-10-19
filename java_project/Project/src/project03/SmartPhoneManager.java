package project03;

import java.util.Scanner;

import project03.Contact;

//3. SmartPhone 클래스의 배열을 다형성의 특징을 이용해서 상위 타입의 배열을 생성해서 하위 클래스의 인스턴스를 저장하는 형태로 프로그
//램은 작성해봅시다.
public class SmartPhoneManager {
	static Scanner sc = new Scanner(System.in);
	private Contact[] contact;
	private int numOfContact;

	SmartPhoneManager(int size) {
		contact = new Contact[size];
		numOfContact = 0;

	}

	SmartPhoneManager() {
		this(10);
	}

	void addContactInfo(Contact c) {

		contact[numOfContact++] = c;
	}

	public void addContact(int select) {

		Scanner sc = new Scanner(System.in);

		System.out.println("연락처 데이터를 입력합니다.");
		System.out.println("이름>> ");
		String name = sc.nextLine();
		System.out.println("전화>>");
		String phoneNumber = sc.nextLine();
		System.out.println("메일>>");
		String email = sc.nextLine();
		System.out.println("주소>>");
		String address = sc.nextLine();
		System.out.println("생일>>");
		String birthDay = sc.nextLine();

		if (select == 1) {
			String group = "회사";
			System.out.println("회사>>");
			String companyName = sc.nextLine();
			System.out.println("부서>>");
			String department = sc.nextLine();
			System.out.println("직급>>");
			String position = sc.nextLine();

			addContactInfo(new CompanyContact(name, phoneNumber, email, address, birthDay, group, companyName,
					department, position));
		} else {
			String group = "거래처";
			System.out.println("회사>>");
			String customerName = sc.nextLine();
			System.out.println("품목>>");
			String item = sc.nextLine();
			System.out.println("직급>>");
			String customerPosition = sc.nextLine();

			addContactInfo(new CustomerContact(name, phoneNumber, email, address, birthDay, group, customerName, item,
					customerPosition));
		}

	}

	public void showAllData() {
		System.out.println("연락처 정보를 모두 출력합니다.");
		System.out.println("=====================");

		for (int i = 0; i < numOfContact; i++) {
			contact[i].showData();
			System.out.println("--------------------");

		}
	}

	public void printMenu() {

		System.out.println("--------------------");
		System.out.println("연락처 관리 프로그램");
		System.out.println("--------------------");
		System.out.println("1. 회사 연락처 입력");
		System.out.println("2. 거래처 연락처 입력");
		System.out.println("3. 전체 연락처 출력");
		System.out.println("4. 이름으로 연락처 검색");
		System.out.println("5. 연락처 삭제");
		System.out.println("6. 연락처 수정");
		System.out.println("7. 프로그램 종료");
		System.out.println("--------------------");
		System.out.println("메뉴 번호를 입력해주세요 >>>>>");
	}

	public void searchData() {
		System.out.println("검색하고자 하는 연락처의 이름을 입력해주세요");
		String name = sc.nextLine();

		int index = searchIndex(name);

		if (index > -1) {
			System.out.println(contact[index]);
		} else {
			System.out.println("검색하신 이름의 데이터가 존재하지 않습니다.");
		}

	}

	private int searchIndex(String name) {
		int index = -1;

		for (int i = 0; i < numOfContact; i++) {
			if (contact[i].getName().equals(name)) {
				index = i;
				break;
			}
		}

		return index;
	}

	public void updateCompanyContact() {

		System.out.println("수정하고자 하는 연락처의 이름을 입력해주세요");
		String name = sc.nextLine();

		int index = searchIndex(name);

		if (index > -1) {
			System.out.println(name + "의 연락처 데이터를 수정합니다.");
			System.out.println("새로운 전화번호>>");
			contact[index].setPhoneNumber(sc.nextLine());
			System.out.println("새로운 이메일>>");
			contact[index].setEmail(sc.nextLine());
			System.out.println("새로운 주소>>");
			contact[index].setAddress(sc.nextLine());
			System.out.println("새로운 생일>>");
			contact[index].setBirthDay(sc.nextLine());
			System.out.println("새로운 그룹>>");
			contact[index].setGroup(sc.nextLine());
			System.out.println("새로운 회사>>");
			((CompanyContact) contact[index]).setCompanyName(sc.nextLine());
			System.out.println("새로운 부서>>");
			((CompanyContact) contact[index]).setDepartment(sc.nextLine());
			System.out.println("새로운 직급>>");
			((CompanyContact) contact[index]).setPosition(sc.nextLine());

			System.out.println("회사 연락처 데이터가 수정 되었습니다.");
		} else {
			System.out.println("검색하신 이름의 데이터가 존재하지 않습니다.");
		}

	}

	public void updateCustomerContact() {

		System.out.println("수정하고자 하는 연락처의 이름을 입력해주세요");
		String name = sc.nextLine();

		int index = searchIndex(name);

		if (index > -1) {
			System.out.println(name + "의 연락처 데이터를 수정합니다.");
			System.out.println("새로운 전화번호>>");
			contact[index].setPhoneNumber(sc.nextLine());
			System.out.println("새로운 이메일>>");
			contact[index].setEmail(sc.nextLine());
			System.out.println("새로운 주소>>");
			contact[index].setAddress(sc.nextLine());
			System.out.println("새로운 생일>>");
			contact[index].setBirthDay(sc.nextLine());
			System.out.println("새로운 그룹>>");
			contact[index].setGroup(sc.nextLine());
			System.out.println("새로운 회사>>");
			((CustomerContact) contact[index]).setCustomerName(sc.nextLine());
			System.out.println("새로운 품목>>");
			((CustomerContact) contact[index]).setItem(sc.nextLine());
			System.out.println("새로운 직급>>");
			((CustomerContact) contact[index]).setCustomerPosition(sc.nextLine());

			System.out.println("거래처 연락처 데이터가 수정 되었습니다.");
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
				contact[i] = contact[i + 1];
			}
			numOfContact--;
			System.out.println("데이터가 삭제되었습니다.");
		} else {
			System.out.println("검색하신 이름의 데이터가 존재하지 않습니다.");
		}

	}

}
