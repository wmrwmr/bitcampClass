package chapter06;
//2.Student 클래스를 정의해봅시다.

//
//①학생이름, 국어점수, 영어점수, 수학점수를 저장하는 변수를 정의 합니다.
//
//②변수는 캡슐화를 합니다. getter/setter 메소드를 정의합니다.
//
//③총점과 평균을 구해 결과를 반환하는 메소드를 정의합니다.
//
//​
//

public class Student {

	private String name;
	private int korean;
	private int english;
	private int math;

	public Student(String name, int korean, int english, int math) {
		super();
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}

	public Student() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKorean() {
		return korean;
	}

	public void setKorean(int korean) {
		this.korean = korean;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int sum() {

		return this.korean + this.english + this.math;
	}

	public float average() {

		return sum() / 3.0f;
	}

	@Override
	public String toString() {
		return name + "\t" + korean + "\t" + english + "\t" + math + "\t" + sum() + "\t" + average() + "\t";
	}

	public static void main(String[] args) {

		// 3.main()메소드에 아래 내용을 정의해봅시다.
		//
		// ①Student 타입의 배열을 선언하고, 요소 10개를 저장할 수 있는 배열 인스턴스를 생성해 봅시다.
		//
		Student[] score = new Student[10];// null null null null

		int numOfStudent = 0; // 입력된 학생의 수 , 배열에 입력할 때 index로 사용

		// ②Student 타입의 인스턴스를 생성하고 배열에 저장하는 코드를 정의해봅시다.
		//

		Student s1 = new Student("홍길동", 100, 100, 100);
		// score[0] = s1;

		score[numOfStudent] = s1;
		numOfStudent++; // 추가된 학생의 수를 +1 증가

		Student s2 = new Student("이강인", 90, 80, 70);
		score[numOfStudent] = s2;
		numOfStudent++;
		
		// ③배열에 저장된 Student 타입의 인스턴스의 메소드를 이용해서 모든 데이터를 출력해봅시다.
		for (int i = 0; i < numOfStudent; i++) {
//			System.out.println(score[i].getKorean() + "\t" + score[i].getEnglish() + "\t" + score[i].getMath() + "\t"
//					+ score[i].sum() + "\t" + score[i].average() + "\t");

			System.out.println(score[i].toString());
		}

//		score[5].average(); //오류!!!

		// 데이터 입력 -> 배열에 저장
		// 데이터 검색 -> 배열의 요소(객체)에서 검색
		// 데이터 삭제 -> 배열의 요소를 삭제

	}

}
