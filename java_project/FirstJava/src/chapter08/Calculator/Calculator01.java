package chapter08.Calculator;

//아래 코드는 계산기 클래스를 정의할 때 가이드 역할을 하도록 정의해놓은 인터페이스입니다. 

//1. Calulator 인터페이스를 상속하는 추상 클래스를 정의해봅시다.
//
//2. Calulator 인터페이스를 상속하는 인스턴스를 생성할 수 있는 클래스를 정의해봅시다.
//
//3. 다형성의 특징으로 상위 타입인 인터페이스 타입의 참조변수에 // 인터페이스를 구현한 클래스 타입의 인스턴스를 참조하는 코드를 작성해 봅시
//다. 
public class Calculator01 implements Calculator {

	int n1;
	int n2;
	
	public Calculator01(int n1, int n2) {
		this.n1 = n1;
		this.n2 = n2;
	}
	
	public Calculator01() {
		
	}
	

	@Override
	public long add(long n1, long n2) {

		return n1 + n2;
	}

	@Override
	public long substract(long n1, long n2) {

		return n1 - n2;
	}

	@Override
	public long multiply(long n1, long n2) {

		return n1*n2;
	}

	@Override
	public double divide(double n1, double n2) {

		return n1/n2;
	}
	
	


	public static void main(String[] args) {
		Calculator c1 = new Calculator01();
		
		System.out.println(c1.add(10, 5));
		System.out.println(c1.substract(10, 5));
		System.out.println(c1.multiply(10, 5));
		System.out.println(c1.divide(10, 5));
		
	}
	

}
