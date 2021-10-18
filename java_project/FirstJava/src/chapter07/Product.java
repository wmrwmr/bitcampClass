package chapter07;

// 상속을 목적으로 만드는 기본(상위, 조상) 클래스
// 상위 개념의 객체 표현: 변수, 메소드
// Computer, Audio, Tv, ...

public class Product { // extends Object

		int price; // 제품의 가격
		int bonusPoint; // 제품을 구매하면 제공하는 보너스 점수
		
		Product(int price) {
			this.price = price;
			this.bonusPoint = price/10;
		}
}
