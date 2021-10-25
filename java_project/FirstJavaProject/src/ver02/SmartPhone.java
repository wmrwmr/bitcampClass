package ver02;

import java.util.Scanner;

public class SmartPhone {

	// ① Contact 클래스의 인스턴스 10개를 저장 할 수 있는 배열을 정의합시다.
	// ② 배열에 인스턴스를 저장하고, 수정하고, 삭제, 저장된 데이터의 리스트를 출력하는 메소드를 정의합니다.
	
	private Contact[] contacts;	// Contact 타입의 인스턴스를 저장하는 배열 선언
	private int cnt;	// 저장된 Contact 타입의 인스턴스 개수, 배열의 index로 사용
	
	public static Scanner sc = new Scanner(System.in); 
	
	public SmartPhone(int size) {
		contacts = new Contact[size];	// 배열 생성
		cnt = 0;
	}
	
	// 배열에 요소를 추가하는 메소드 : 참조값을 전달 받아 배열에 추가 하는 기능
	public void addContact(Contact contact) {
		contacts[cnt++]=contact;
	}
	
	// 사용자로 부터 데이터를 받아 Contact 객체를 생성하고 배열에 참조값을 저장 메소드 호출
	public void insertContact() {
		System.out.println("연락처 등록을 시작합니다.....");
		System.out.println("이름 >>");
		String name = sc.nextLine();
		
		System.out.println("전화번호 >>");
		String phoneNumber = sc.nextLine();
		
		System.out.println("이메일 >>");
		String email = sc.nextLine();
		
		System.out.println("주소 >>");
		String address = sc.nextLine();
		
		System.out.println("생일 >>");
		String birthday = sc.nextLine();
		
		System.out.println("그룹 >>");
		String group = sc.nextLine();
		
		//Contact c = new Contact(name, phoneNumber, email, address, birthday, group);
		//addContact(c);
		
		addContact(new Contact(name, phoneNumber, email, address, birthday, group));
	}
	
	// 전체 데이터 출력 : 배열은 반복문
	public void printAllData() {
		
		System.out.println("리스트를 출력합니다.("+cnt+"명)");
		System.out.println("============================");
		
		for(int i=0; i<cnt ; i++) {
			contacts[i].printContact();
			System.out.println("------------------");
		}
		
	}
	
	// 이름(문자열)을 전달 받아서 배열의 각 요소의 이름과 비교 같은 요소가 있으면 해당 index 반환
	private int searchIndex(String name) {
		
		int index = -1;
		
		// 배열의 요소를 반복해서 참조하고 이름과 비교 -> 찾으면 반복 종료 index 
		for(int i=0; i<cnt; i++) {
			if(contacts[i].getName().equals(name)) {
				index = i;
				break;
			}
		}
		
		return index;
	}
	
	// 이름으로 검색(index 찾기) -> 해당 데이터 출력
	public void searchPrint() {
		
		System.out.println("검색을 시작합니다.....");
		System.out.println("찾고자 하는 이름을 입력하세요. >>");
		String name = sc.nextLine();
		
		int index = searchIndex(name);
		
		if(index<0) {
			System.out.println("찾으시는 이름 " + name + "의 정보가 존재하지 않습니다.");			
		} else {
			System.out.println("검색 결과 입니다.");
			System.out.println("----------------------");
			contacts[index].printContact();
			System.out.println("----------------------");
		}
	}
	
	// 이름으로 검색 -> 해당 데이터 삭제
	public void deleteContact() {
	
		System.out.println("데이터 삭제를 시작합니다.....");
		System.out.println("삭제하고자하는 데이터의 이름을 입력하세요. >>");
		String name = sc.nextLine();
		
		int index = searchIndex(name);
		
		if(index<0) {
			System.out.println("삭제하고자 하는 이름 " + name + "의 데이터가 존재하지 않습니다.");
		} else {
			// 삭제 처리 : index 위치의 참조값을 index+1 위치의 값으로 치환, 시프트
			for(int i=index; i<cnt-1; i++) {
				contacts[index] = contacts[index+1];
				cnt--;
			}
			System.out.println(name + " 의 데이터가 삭제되었습니다.");
		}
	}
	
	// 이름으로 검색 -> 데이터 수정 : 수정할 데이터를 받아서 처리
	public void editContact() {
		
		System.out.println("데이터 수정을 시작합니다.....");
		System.out.println("변경을 원하는 정보의 이름을 입력하세요. >>");
		String name = sc.nextLine();
		
		int index = searchIndex(name);
		
		if(index<0) {
			System.out.println("찾으시는 이름 " + name + " 의 정보가 존재하지 않습니다.");
		} else {
			System.out.println("데이터 수정을 위해 각가의 데이터를 입력하세요.....");
			
			System.out.println("이름 >>");
			String ename = sc.nextLine();
			
			System.out.println("전화번호 >>");
			String phoneNumber = sc.nextLine();
			
			System.out.println("이메일 >>");
			String email = sc.nextLine();
			
			System.out.println("주소 >>");
			String address = sc.nextLine();
			
			System.out.println("생일 >>");
			String birthday = sc.nextLine();
			
			System.out.println("그룹 >>");
			String group = sc.nextLine();
			
			// Contact c  
			contacts[index].setName(ename);
			contacts[index].setPhoneNumber(phoneNumber);
			contacts[index].setEmail(email);
			contacts[index].setAddress(address);
			contacts[index].setBirthday(birthday);
			contacts[index].setGroup(group);
			
			System.out.println(name + " 의 정보가 수정되었습니다.");
			
		}
		
	}
	
	
	
}







