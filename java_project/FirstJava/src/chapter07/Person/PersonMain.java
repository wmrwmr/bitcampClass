package chapter07.Person;

//3. main()메소드를 정의해봅시다.
//① Person 클래스를 상속받은 Male클래스와 Female클래스를 이용해서 인스턴스를 생성해 봅시다.
//② 생성된 인스턴스들을 이용해서 메소드를 호출해봅시다.

public class PersonMain {

	
	public static void main(String[] args) {
		PersonMale p1 = new PersonMale();
		PersonFemale p2 = new PersonFemale();
		
		p1.hello("홍길동", "22");
		p2.hello("김춘향", "23");
		
		p1.helloMale("010-0000-0000");
		p2.helloFemale("서울시");
	}
	
}
