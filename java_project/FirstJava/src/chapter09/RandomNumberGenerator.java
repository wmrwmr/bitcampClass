package chapter09;

import java.util.Random;

public class RandomNumberGenerator {
	public static void main(String[] args) {

//		(int) (Math.random()*10)+1 -> 1~10

		Random r1 = new Random();

		for (int i = 0; i < 10; i++) {
			// 1~10
			int num1 = r1.nextInt(10) + 1; // 0~9 -> 1~10(bound)
//			System.out.println(num1);
		}
		
		Random r2 = new Random(1);

		for (int i = 0; i < 10; i++) {
			
			long num = System.currentTimeMillis();
			long num2 = System.nanoTime();
			r2.setSeed(num2);
			// 1~10
			int num1 = r2.nextInt(10) + 1; // 0~9 -> 1~10(bound)
			System.out.println(num1);
		}
		
		
	}
}
