package chapter06;
//1. 국어, 영어, 수학 점수 10개씩을 저장하는 배열을 정의하고 점수를 모두 출력하고, 
//평균 점수를 출력하는 프로그램을 작성해봅시다.(random)



public class Grade {
	public static void main(String[] args) {

		int[][] grade = new int[10][3];

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 3; j++) {
				grade[i][j] = (int) (Math.random() * 101);
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
