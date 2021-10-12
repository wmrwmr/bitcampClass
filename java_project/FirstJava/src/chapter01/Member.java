package chapter01;

public class Member {
	
	// 2. Member 클래스를 생성하고, 
	//	  main()메소드를 만들고 자기 자신의 이름을 출력하는 메소드를 만들어 출력해 봅시다. 
	
	public static void main(String[] args) {
		// static: 바이트 코드가 가상머신에서 실행하는 시점에 메소드 코드가 메모리에 로드된다.
		System.out.println("김현우");
		System.out.println("메소드 호출");
		sayName();
	}
	
	// 이름을 출력하는 메소드
	// 반환타입 메소드 이름(매개변수,...)
	
	static void sayName() {
		System.out.println("김현우");
		
	}
}
