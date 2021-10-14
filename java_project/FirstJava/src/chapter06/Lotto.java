package chapter06;

public class Lotto {

	public static void main(String[] args) {
		// 1~45까지의 숫자를 저장할 수 있는 배열을 생성
		int[] ball = new int[45];

		// 각 배열의 요소에 1~45까지의 숫자를 저장
		for (int i = 0; i < ball.length; i++) {
			ball[i] = i + 1;
		}

		// 배열의 모든 요소 출력
		for (int i = 0; i < ball.length; i++) {
			System.out.println(ball[i]);
		}

		System.out.println("숫자 섞기 ========================");

		// 임시변수: 0번지의 값을 저장
		int temp = 0;

		// 랜덤한 index(정수) -> 1~44

		for (int i = 0; i < 10000; i++) {

			int index = (int) (Math.random() * 44) + 1; // 1.0 <= r < 45.0 => 44.9999999999

			temp = ball[0];
			ball[0] = ball[index];
			ball[index] = temp;

		}

		// 배열의 모든 요소 출력
		for (int i = 0; i < 6; i++) {
			System.out.println(ball[i]);
		}

	}
}
