package ver05;

public abstract class Contact implements ShowData {

//	저장 정보
//	이름, 전화번호, 이메일, 주소, 생일, 그룹
	// 캡슐화 : 외부(다른 이스턴스)에서 변수를 직접 참조하지 못하도록하는것
	private String name; // 이름
	private String phoneNumber; // 전화번호 : 000-0000-0000
	private String email; // 이메일
	private String address; // 주소
	private String birthday; // 생일 : 20211022
	private String group; // 그룹

	// 생성자 : 변수들을 초기화 할 때 사용
	public Contact(String name, String phoneNumber, String email, String address, String birthday, String group) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.birthday = birthday;
		this.group = group;
	}

	public Contact(String name, String phoneNumber) {
//		this.name = name;
//		this.phoneNumber = phoneNumber;
		this(name, phoneNumber, null, null, null, null);
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

//	 기능 : 위 데이터를 출력하는 기능
	public void printContact() {
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
		System.out.println("이메일 : " + email);
		System.out.println("주소 : " + address);
		System.out.println("생일 : " + birthday);
		System.out.println("그룹 : " + group);
	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + ", address=" + address
				+ ", birthday=" + birthday + ", group=" + group + "]";
	}


}
