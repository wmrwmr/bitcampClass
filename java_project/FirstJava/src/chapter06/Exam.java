package chapter06;

import java.util.Scanner;

//문제 1. 
//int형 1차원 배열을 매개변수로 전달 받아서 배열에 저장된 최대값,
//그리고 최소값을 구해서 반환하는 메소드를 다음의 형태로 각각 정의.
// public static int miniValue(int[] arr) { . . . . } // 최소값 반환
// public static int maxValue(int[] arr) { . . . . } // 최대값 반환
// 
//위의 두 매소드는 인자로 전달되는 배열의 길이에 상관없이 동작하도록 정의.
//두 매소드 실행을 확인인하기 위한 main 메소드 정의.
//int형 배열에 채워질 정수는 프로그램 사용자로부터 입력 받고, 배열의 길이는
//임의로 결정

public class Exam {

	public static int miniValue(int[] arr) {

		int miniVal = arr[0];

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] < miniVal) {// 300 100 50 500 400
				miniVal = arr[i];
			}
		}
		return miniVal;
	}

	public static int maxValue(int[] arr) {

		int maxVal = arr[0];

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > maxVal) {
				maxVal = arr[i];
			}

		}
		return maxVal;

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

//		int index = (int) (Math.random() * 10) + 1;
//
//		int[] arr1 = new int[index];
//
//		System.out.println(index + "개의 숫자를 입력해주세요");
//		for (int i = 0; i < index; i++) {
//			arr1[i] = scanner.nextInt();
//		}
//
//		System.out.println("======= 배열 =======");
//		for (int i = 0; i < index; i++) {
//			System.out.println(arr1[i]);
//		}
//
//		System.out.println("======= 최소값 =======");
//		System.out.println(Exam.miniValue(arr1));
//
//		System.out.println("======= 최대값 =======");
//		System.out.println(Exam.maxValue(arr1));

		// 2차원 배열의 선언
		int[][] arr3 = { 
				{ 1, 2, 3 }, 
				{ 4, 5, 6, 7 }, 
				{ 8, 9, 10, 11, 12, 13 } 
				};

		System.out.println("2차원 배열 출력");
		addOneDArr(arr3, 10);

	}

	public static void addOneDArr(int[][] arr, int add) {
		
		
		int [][] arr1 = {
				{1,2,3},
				{4,5,6},
				{7,8,9},
				{10,11,12}
		};
		
		// 출력
		for(int i = 0; i<arr1.length; i++) {
			for (int j = 0; j<arr1[i].length; j++) {
				System.out.print(arr1[i][j] + "\t");
			}
			System.out.println();
		}
		
		
		// 임시 배열 선언
		int[] temp = arr1[arr1.length-1];
		
		for (int i = arr1.length-1; i>0; i--) {
			
			arr1[i] = arr1[i-1];
		}
		
		arr1[0] = temp;
		
		System.out.println();
		
		for(int i = 0; i<arr1.length; i++) {
			for (int j = 0; j<arr1[i].length; j++) {
				System.out.print(arr1[i][j] + "\t");
			}
			System.out.println();
		}
		
		

//		// 2차원 배열의 출력
//		// 행
//		for (int i = 0; i < arr.length; i++) {
//
//			// 열
//			for (int j = 0; j < arr[i].length; j++) {
//				System.out.print(arr[i][j] + "\t");
//			}
//			System.out.println();
//		}
//		
//		
//		// 매개 변수로 전달받은 숫자를 각 요소에 더해준다.
//		for (int i = 0; i < arr.length; i++) {
//
//			for (int j = 0; j < arr[i].length; j++) {
//				arr[i][j] += add;
//			}
//			System.out.println();
//		}
//		
//		System.out.println("각 요소에 숫자를 더하기 ===================");
//		
//		for (int i = 0; i < arr.length; i++) {
//
//			for (int j = 0; j < arr[i].length; j++) {
//				System.out.print(arr[i][j] + "\t");
//			}
//			System.out.println();
//		}
		

	}
	
//	문제 3.
//	다음의 형태로 표현된 2차원 배열이 존재한다고 가정해 보자.
//	1 2 3
//	4 5 6
//	7 8 9
//	이러한 형태를 갖는 int형 2차원 배열이 인자로 전달되면, 다음의 형태로 배열
//	의 구조를 변경시키는 메서드를 정의해 보자.
//	7 8 9
//	1 2 3
//	4 5 6
//	즉 총 N행으로 이뤄진 2차원 배열이 존재한다면, 메서드 호출 시, 1행은 2행
//	으로 이동이 이뤄져야한다. 이번에도 마찬가지로 배열의 가로, 세로길이에 상
//	관 없이 동작을 하도록 메서드가 정의되어야 하며, 정의된 메서드의 확인을
//	위한 main메서드도 함께 정의하자.
	
	
	
	



}
