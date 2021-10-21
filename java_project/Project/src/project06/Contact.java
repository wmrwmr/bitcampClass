package project06;
//프로젝트-3 에서 구현한 상속 구조를 기초로 Contact 클래스를 추상클래스로 만들어봅시다.
//
//1. ShowData인터페이스에 추상 메소드 void showData() 정의되어 있는 구조
//
//2. Contact클래스가 ShowData인터페이스를 상속하면서 추상 메소드를 보유하는 관계로 생성
//
//3. Contact클래스는 추상 메소드를 가지고 있어 추상클래스가 되는 형태로 정의
//
//4. SmartPhone클래스에 있는 배열의 타입이 추상클래스로 되어도 문제가 없는 것을 확인

abstract public class Contact implements ShowData{

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

	

	@Override
	public void showData() {}

	@Override
	public String toString() {
		return "전화: " + phoneNumber + "\n" + "메일: " + email + "\n" + "주소: " + address + "\n" + "생일: " + birthDay
				+ "\n" + "그룹: " + group + "\n";
	}

}
