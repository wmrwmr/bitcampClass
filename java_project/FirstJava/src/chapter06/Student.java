package chapter06;
//1. 국어, 영어, 수학 점수 10개씩을 저장하는 배열을 정의하고 점수를 모두 출력하고, 평균 점수를 출력하는 프로그램을 작성해봅시다.(random)

//
//2. Student 클래스를 정의해봅시다.
//① 학생이름, 국어점수, 영어점수, 수학점수를 저장하는 변수를 정의 합니다.
//② 변수는 캡슐화를 합니다. getter/setter 메소드를 정의합니다.
//③ 총점과 평균을 구해 결과를 반환하는 메소드를 정의합니다.
//3. main()메소드에 아래 내용을 정의해봅시다.
//① Student 타입의 배열을 선언하고, 요소 10개를 저장할 수 있는 배열 인스턴스를 생성해 봅시다.
//② Student 타입의 인스턴스를 생성하고 배열에 저장하는 코드를 정의해봅시다.
//③ 배열에 저장된 Student 타입의 인스턴스의 메소드를 이용해서 모든 데이터를 출력해봅시다.

public class Student {
	public static void main(String[] args) {

		int[][] grade = new int[10][3];

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 3; j++) {
				grade[i][j] = (int) (Math.random() * 100)+1;
			}
		}
		System.out.println("국어\t영어\t수학\t");
		for (int i = 0; i < grade.length; i++) {
			for (int j = 0; j < grade[i].length; j++) {
				System.out.print(grade[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("평균");
	
				
		for (int i = 0; i<grade.length; i++) {
			
			
			int sum = grade[i][0] + grade[i][1] + grade[i][2];
			double average = (double) sum/3;	
			
			System.out.printf("%.2f\n", average);
		}
		
		

	}

}
