package project01;

import java.util.Scanner;

public class Contact {

	private String name;
	private String phoneNumber;
	private String email;
	private String address;
	private String birthYear;
	private String group;

	public Contact() {

	}

	public Contact(String name, String phoneNumber, String email, String address, String birthYear, String group) {

		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.birthYear = birthYear;
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

	public String getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Contact c1 = new Contact();

		System.out.println("이름: " + c1.getName());
		System.out.println("전화번호: " + c1.getPhoneNumber());
		System.out.println("이메일: " + c1.getEmail());
		System.out.println("주소: " + c1.getAddress());
		System.out.println("생일: " + c1.getBirthYear());
		System.out.println("그룹: " + c1.getGroup());

		System.out.println();
		System.out.println("이름을 입력해주세요");
		System.out.println("> ");
		c1.setName(scanner.nextLine());

		System.out.println("전화번호를 입력해주세요");
		System.out.println("> ");
		c1.setPhoneNumber(scanner.nextLine());

		System.out.println("이메일을 입력해주세요");
		System.out.println("> ");
		c1.setEmail(scanner.nextLine());

		System.out.println("주소를 입력해주세요");
		System.out.println("> ");
		c1.setAddress(scanner.nextLine());

		System.out.println("생일을 입력해주세요");
		System.out.println("> ");
		c1.setBirthYear(scanner.nextLine());

		System.out.println("그룹을 입력해주세요");
		System.out.println("> ");
		c1.setGroup(scanner.nextLine());

		System.out.println("이름: " + c1.getName());
		System.out.println("전화번호: " + c1.getPhoneNumber());
		System.out.println("이메일: " + c1.getEmail());
		System.out.println("주소: " + c1.getAddress());
		System.out.println("생일: " + c1.getBirthYear());
		System.out.println("그룹: " + c1.getGroup());

		scanner.close();
	}

}
