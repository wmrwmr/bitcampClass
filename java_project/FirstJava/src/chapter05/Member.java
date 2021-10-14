package chapter05;

//1. Member 클래스에는 아래 요구사항에 맞는 변수와 메소드를 정의하고, main()메소드 에 해당 메소드를 호출해서 결과를 확인해보세요.
//단 인스턴스의 생성은 생성자를 이용해서 초기화하는 코드를 작성해 봅시다.
//① 아래의 데이터를 저장 이름, 전화번호, 전공, 학년, email, 생일, 주소
//② 위에서 정의한 정보를 출력하는 메소드 정의
//③ 모든 정보를 저장하도록 하는 생성자와 생일과 주소는 저장하지 않을 수 있는 생성자를 정의
//④ main() 메소드에서 두 가지 생성자를 이용해서 인스턴스 생성하고 출력 메소드를 통해 저장된 데이터 출력

public class Member {
	
	String name;
	int phoneNumber;
	String subject;
	String grade;
	String email;
	int birthYear;
	String adress;
	
	public Member(String name, int phoneNumber, String subject, String grade, String email, int birthYear, String adress) {
		
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.subject = subject;
		this.grade = grade;
		this.email = email;
		this.birthYear = birthYear;
		this.adress = adress;
	}
	
	
	
	public Member(String name, int phoneNumber, String subject, String grade, String email) {

		this.name = name;
		this.phoneNumber = phoneNumber;
		this.subject = subject;
		this.grade = grade;
		this.email = email;
	}



	public Member() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	void printAll(Member m) {
		
		System.out.println(m.name);
		System.out.println(m.phoneNumber);
		System.out.println(m.subject);
		System.out.println(m.grade);
		System.out.println(m.email);
		System.out.println(m.birthYear);
		System.out.println(m.adress);

	}
	
	public static void main(String[] args) {
		Member m1 = new Member("김현우", 01011111111, "컴퓨터", "3학년", "gusdn@gmail.com", 1000, "서울시");
		Member m2 = new Member("김현우", 01011111111, "컴퓨터", "3학년", "gusdn@gmail.com");
		m1.printAll(m1);
		System.out.println("----------------------------");
		m2.printAll(m2);
	}
	
}
