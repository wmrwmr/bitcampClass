package chapter07;

//추상 클래스로 만들기: 추상 메소드 생성
public abstract class Friend2 {

	// 개인 정보 관리 프로그램
	// 정보를 저장하는 변수
	String name;
	String phoneNumber;
	String address;

	// 저장 데이터의 초기화: 생성자
	public Friend2(String name, String phoneNumber, String address) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	// 데이터 출력 메소드: 상속을 하면 오버라이딩해서 하이 클래스의 멤버도 출력
	public void showData() {
		System.out.println("이름: " + this.name);
		System.out.println("전화: " + this.phoneNumber);
		System.out.println("주소: " + this.address);

	}
	
	// 오버라이딩 목적으로 하는 메소드
//	public void showBasicInfo() {}
	// 추상 메소드: 처리 블록이 없다!, 미완성된 메소드, 상속을 통해 완성시켜야 하는 메소드
	public abstract void showBasicInfo();

}
