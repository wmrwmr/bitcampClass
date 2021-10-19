package project02;

public class Contact {

	private String name;
	private String phoneNumber;
	private String email;
	private String address;
	private String birthDay;
	private String group;

	public Contact() {

	}

	public Contact(String name, String phoneNumber, String email, String address, String birthDay, String group) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.birthDay = birthDay;
		this.group = group;
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
	public String toString() {
		return "전화: " + phoneNumber + "\n" + "메일: " + email + "\n" + "주소: " + address + "\n" + "생일: " + birthDay
				+ "\n" + "그룹: " + group + "\n";
	}

}
