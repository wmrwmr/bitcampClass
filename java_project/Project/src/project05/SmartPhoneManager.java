package project05;

import java.util.Scanner;

import project05.Contact;

public class SmartPhoneManager {
	public static Scanner sc = new Scanner(System.in);
	private Contact[] contact;
	private int numOfContact;

	SmartPhoneManager(int size) {
		contact = new Contact[size];
		numOfContact = 0;

	}

	public SmartPhoneManager() {
		this(10);
	}

	void addContactInfo(Contact c) {

		contact[numOfContact++] = c;
	}

	public void addContact(int select) {

		try {

			Scanner sc = new Scanner(System.in);

			System.out.println("연락처 데이터를 입력합니다.");
			System.out.println("이름>> ");
			String name = readSelect();
			System.out.println("전화>>");
			String phoneNumber = readPhoneNumber();
			System.out.println("메일>>");
			String email = readSelect();
			System.out.println("주소>>");
			String address = readSelect();
			System.out.println("생일>>");
			String birthDay = readSelect();

			if (select == 1) {
				String group = "회사";
				System.out.println("회사>>");
				String companyName = readSelect();
				System.out.println("부서>>");
				String department = readSelect();
				System.out.println("직급>>");
				String position = readSelect();

				addContactInfo(new CompanyContact(name, phoneNumber, email, address, birthDay, group, companyName,
						department, position));
				System.out.println("회사 연락처가 저장되었습니다.");
			} else {
				String group = "거래처";
				System.out.println("회사>>");
				String customerName = readSelect();
				System.out.println("품목>>");
				String item = readSelect();
				System.out.println("직급>>");
				String customerPosition = readSelect();

				addContactInfo(new CustomerContact(name, phoneNumber, email, address, birthDay, group, customerName,
						item, customerPosition));
				System.out.println("거래처 연락처가 저장되었습니다.");

			}

		} catch (VacuumException v) {
			System.out.println(v.getMessage());
			addContact(select);
		} catch (PhoneNumberException p) {
			System.out.println(p.getMessage());
			addContact(select);
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

		System.out.println("==========================");
		System.out.println("연락처 관리 프로그램");
		System.out.println("1. 연락처 입력");
		System.out.println("2. 연락처 검색");
		System.out.println("3. 연락처 수정");
		System.out.println("4. 연락처 삭제");
		System.out.println("5. 연락처 전체 리스트 보기");
		System.out.println("6. 종료");
		System.out.println("==========================");
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

	private int searchIndex2(String phoneNumber) {
		int index = -1;

		for (int i = 0; i < numOfContact; i++) {
			if (contact[i].getPhoneNumber().equals(phoneNumber)) {
				index = i;
				break;
			}
		}

		return index;
	}

	public void updateCompanyContact() {

		try {

			System.out.println("수정하고자 하는 연락처의 이름을 입력해주세요");
			String name = sc.nextLine();

			int index = searchIndex(name);

			if (index > -1) {
				System.out.println(name + "의 연락처 데이터를 수정합니다.");
				System.out.println("새로운 전화번호>>");
				contact[index].setPhoneNumber(readSelect());
				System.out.println("새로운 이메일>>");
				contact[index].setEmail(readSelect());
				System.out.println("새로운 주소>>");
				contact[index].setAddress(readSelect());
				System.out.println("새로운 생일>>");
				contact[index].setBirthDay(readSelect());
				System.out.println("새로운 그룹>>");
				contact[index].setGroup(readSelect());
				System.out.println("새로운 회사>>");
				((CompanyContact) contact[index]).setCompanyName(readSelect());
				System.out.println("새로운 부서>>");
				((CompanyContact) contact[index]).setDepartment(readSelect());
				System.out.println("새로운 직급>>");
				((CompanyContact) contact[index]).setPosition(readSelect());

				System.out.println("회사 연락처 데이터가 수정 되었습니다.");
			} else {
				System.out.println("검색하신 이름의 데이터가 존재하지 않습니다.");
			}

		} catch (VacuumException v) {
			System.out.println(v.getMessage());
			updateCompanyContact();
		}

	}

	public void updateCustomerContact() {

		try {

			System.out.println("수정하고자 하는 연락처의 이름을 입력해주세요");
			String name = sc.nextLine();

			int index = searchIndex(name);

			if (index > -1) {
				System.out.println(name + "의 연락처 데이터를 수정합니다.");
				System.out.println("새로운 전화번호>>");
				contact[index].setPhoneNumber(readSelect());
				System.out.println("새로운 이메일>>");
				contact[index].setEmail(readSelect());
				System.out.println("새로운 주소>>");
				contact[index].setAddress(readSelect());
				System.out.println("새로운 생일>>");
				contact[index].setBirthDay(readSelect());
				System.out.println("새로운 그룹>>");
				contact[index].setGroup(readSelect());
				System.out.println("새로운 회사>>");
				((CustomerContact) contact[index]).setCustomerName(readSelect());
				System.out.println("새로운 품목>>");
				((CustomerContact) contact[index]).setItem(readSelect());
				System.out.println("새로운 직급>>");
				((CustomerContact) contact[index]).setCustomerPosition(readSelect());

				System.out.println("거래처 연락처 데이터가 수정 되었습니다.");
			} else {
				System.out.println("검색하신 이름의 데이터가 존재하지 않습니다.");
			}
		} catch (VacuumException v) {
			System.out.println(v.getMessage());
			updateCustomerContact();
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

	public static String readSelect() throws VacuumException {
		Scanner sc = new Scanner(System.in);
		String select = sc.nextLine();
		if (!(select.matches("^\\S*$"))) {
			VacuumException excpt = new VacuumException();
			throw excpt;
		}
		return select;
	}

	public String readPhoneNumber() throws PhoneNumberException {

		String select = sc.nextLine();

		int index = searchIndex2(select);

		if (index > -1) {
			PhoneNumberException excpt = new PhoneNumberException();
			throw excpt;
		}
		return select;
	}

}
