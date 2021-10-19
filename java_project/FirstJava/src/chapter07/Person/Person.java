package chapter07.Person;
//1.Person 이라는 클래스를 정의해봅시다.

//
//①이름을 저장하는 변수, 주민등록번호를 저장하는 변수를 정의해봅시다.
//
//②인사하는 메소드를 정의해봅시다. - “안녕하세요. 저는 OOO입니다. 00살 입니다.”라는 문자열이 출력하도록 정의합시다.
//
//​
//

public class Person {
	String name;
	String juminNumber;
	
	

	public Person(String name, String juminNumber) {

		this.name = name;
		this.juminNumber = juminNumber;
	}
	
	public Person() {
		
	}



	public void hello(String name, String age) {
		System.out.println("안녕하세요. 저는 " + name + "입니다. " + age + "살 입니다.");

	}

}
