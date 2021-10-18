package chapter07;

public class Buyer {

	int money;
	int bonusPoint;

	// 제품 구매와 함께 카트(구매내역)를 정의
	// buy 메소드를 통해서 전달받는 Product 타입의 인스턴스를 저장하는 배열을 정의
	Product[] cart;
	int cnt;

	public Buyer() {

		money = 1000;
		bonusPoint = 0;
		cart = new Product[10];
		cnt = 0;

	}

	// 제품 구매

//	public void buy(Computer com) {}
//	public void buy(Tv tv) {}
//	public void buy(Audio audio) {}
//	//....

	// 다형성을 이용해서 메소드를 하나만 정의
	public void buy(Product p) {
//		Product p1 = new Computer(100);
//		Product p2 = new Tv(20);
//		Product p3 = new Audio(40);

		if (money < p.price) {
			System.out.println("보유한 돈이 부족해서 제품을 구매할 수 없습니다.");
			return;
		}

		money -= p.price;
		bonusPoint += p.bonusPoint;
//		System.out.println(p + "을/를 구입하셨습니다.");

		// cart에 제품 추가
		cart[cnt++] = p;

	}

	public void summary() {
		// 총 구매 액
		int sum = 0;
		// 구매 내역(제품의 리스트)
		String itemList = "";

		// 배열을 이용하면 -> 반복문
		for (int i = 0; i < cnt; i++) {
			// 합을 구하기
//			sum = sum + cart[i].price;
			sum += cart[i].price;
			itemList += cart[i] + ", ";
		}

		System.out.println("구매하신 제품은 " + itemList + "입니다.");
		System.out.println("구매한 제품들의 총 구매액은 " + sum + "원 입니다.");
		
		
		
	}

}
