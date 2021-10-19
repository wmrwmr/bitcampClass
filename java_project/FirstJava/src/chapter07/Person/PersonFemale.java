package chapter07.Person;

public class PersonFemale extends Person{
	
	String age;
	String address;
	public PersonFemale(String name, String juminNumber, String age, String address) {
		super(name, juminNumber);
		this.age = age;
		this.address = address;
	}
	
	public PersonFemale() {
		
	}
	
	@Override
	public void hello(String name, String age) {
		super.hello(name, age);
	}
	
	public void helloFemale(String address) {
		System.out.println("저는 여자이고, 저의 주소는 " + address + "입니다.");
	}
	
	
	
	
}
