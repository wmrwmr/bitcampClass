package chapter07.Person;
//2. Person 클래스를 상속해서 확장하는 새로운 클래스 Male 클래스와 Female 클래스를 정의 해봅시다.
//① 각 클래스는 상속 받은 멤버 외에 추가적인 변수와 메소드를 추가해서 새로운 클래스를 정의해봅시다.
//② 각 클래스는 상속 받은 멤버 외에 추가적인 변수와 메소드를 추가해서 새로운 클래스를 정의해봅시다.
//③ Person 클래스에서 정의된 인사하는 메소드를 오버라이딩 해봅시다.
//④ Person 클래스에 생성자를 정의해서 인스턴스 변수들을 초기화 해봅시다.

public class PersonMale extends Person{
	
	String age;
	String phoneNumber;



	public PersonMale(String name, String juminNumber, String age, String phoneNumber) {
		super(name, juminNumber);
		this.age = age;
		this.phoneNumber = phoneNumber;
	}
	
	public PersonMale() {
		
	}



	@Override
	public void hello(String name, String age) {
		super.hello(name, age);
	}
	
	public void helloMale(String phoneNumber) {
		System.out.println("저는 남자이고, 저의 전화번호는 " + phoneNumber + "입니다.");
	}
	
	
	
	

}
