package chapter10;

import java.util.Scanner;

public class ExceptionTest01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("피제수를 입력해주세요.");
		int num1 = sc.nextInt();
		System.out.println("제수를 입력해주세요");
		int num2 = sc.nextInt();

		if (num2 == 0) {
			System.out.println("0으로 나눌 수 없습니다.");
			// return;

		} else {
			System.out.println("num1/num2");
		}

	}
}
