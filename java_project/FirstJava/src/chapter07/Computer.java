package chapter07;

public class Computer extends Product {

	Computer(int price) {
		super(price);
	}
	
	@Override
	public String toString() {
		// toString(): Object 클래스가 가지는 메소드
		// 오버라이딩
		return "Computer";
	}
}
