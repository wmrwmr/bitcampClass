package project02;

import java.util.Scanner;
import project02.Contact;
//프로젝트-1 에서 정의한 Contact 클래스를 기반으로 아래 요구사항을 추가해서 프로그램을 작성 합니다.
//


public class SmartPhone {
	
	Scanner scanner = new Scanner(System.in);
	//1. SmartPhone 클래스를 정의합니다. 이 클래스는 연락처 정보를 관리하는 클래스입니다.
	//① Contact 클래스의 인스턴스 10개를 저장 할 수 있는 배열을 정의합시다.
	Contact [] c = new Contact[10];
	
	//② 배열에 인스턴스를 저장하고, 수정하고, 삭제, 저장된 데이터의 리스트를 출력하는 메소드를 정의합니다.
	public void save() {
	Contact c = new Contact();
	
	private String name;
	private String phoneNumber;
	private String email;
	private String address;
	private String birthDay;
	private String group;
	
	
	System.out.println("이름을 입력해주세요");
	c.setName(scanner.nextLine());
	
	System.out.println("전화번호를 입력해주세요");
	c.setPhoneNumber(scanner.nextLine());
	
	System.out.println("이메일을 입력해주세요");
	c.setEmail(scanner.nextLine());
	
	System.out.println("주소를 입력해주세요");
	c.setAddress(scanner.nextLine());
	//@@@@@@
	System.out.println("이름을 입력해주세요");
	c.setName(scanner.nextLine());
	
	System.out.println("이름을 입력해주세요");
	c.setName(scanner.nextLine());
	
	
	
	}
	
	//2. main()메소드를 아래의 요구조건을 정의해봅니다.
	//① SmartPhone 클래스의 인스턴스를 생성합니다.
	//② 사용자로부터 입력을 받아 Contact 인스턴스를 생성해서 SmartPhone 클래스의 인스턴스가 가지고 있는 배열에 추가합니다.
	//③ 10번 반복해서 배열에 추가합니다.
	//④ 배열의 모든 요소를 출력합니다.
	//⑤ 배열의 모든 요소를 검색합니다.
	//⑥ 배열의 요소를 삭제해 봅시다.
	//⑦ 배열의 요소를 수정해 봅시다.
	
	
	
	

}
