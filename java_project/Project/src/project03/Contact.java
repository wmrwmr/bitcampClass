package project03;
//프로젝트-2 에서 정의한 Contact 클래스를 상속의 구조로 만들어 봅니다.

//
//1. Contact 클래스는 기본정보를 저장하고 기본 정보를 출력하는 메소드를 정의합니다.
//- 생성자를 통해 기본 정보들을 초기화 합니다.
//

public class Contact {

	private String name;
	private String phoneNumber;
	private String email;
	private String address;
	private String birthDay;
	private String group;

	public Contact(String name, String phoneNumber, String email, String address, String birthDay, String group) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.birthDay = birthDay;
		this.group = group;
	}

	public Contact() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public void showData() {
		System.out.println("이름: " + this.name);
		System.out.println("전화: " + this.phoneNumber);
		System.out.println("메일: " + this.email);
		System.out.println("주소: " + this.address);
		System.out.println("생일: " + this.birthDay);
		System.out.println("그룹: " + this.group);

	}

	@Override
	public String toString() {
		return "전화번호: " + phoneNumber + "\n" + "이메일: " + email + "\n" + "주소: " + address + "\n" + "생일: " + birthDay
				+ "\n" + "그룹: " + group + "\n";
	}

}
