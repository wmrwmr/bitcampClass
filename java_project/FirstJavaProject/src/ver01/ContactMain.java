package ver01;

public class ContactMain {

	public static void main(String[] args) {
		
		// 인스턴스 생성 => new 클래스이름 -> 클래스() 생성자 호출
		Contact contact1 = new Contact("손흥민", "010-0000-0000", "son@gmail.com", "London", "2000-10-22", "친구");
		Contact contact2 = new Contact("이강인", "010-9999-9999");
		
		// getter 메소드를 이용해서 출력
		System.out.println("이름 : " + contact1.getName());
		System.out.println("이름 : " + contact2.getName());
		
		System.out.println("-------------------------");
		
		// 저장된 전체 데이터 출력
		contact1.printContact();
		System.out.println("-------------------------");
		contact2.printContact();
		
		System.out.println("-------------------------");
		
		// 데이터 변경 : setter 메소드를 이용
		contact2.setEmail("lee@naver.com");
		contact2.setAddress("서울");
		contact2.setBirthday("2000-10-22");
		contact2.setGroup("친구");
		System.out.println("데이터 변경 (추가)");
		contact2.printContact();
		

	}

}
