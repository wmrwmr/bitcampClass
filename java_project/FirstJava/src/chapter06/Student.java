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

	public int sum(Student s) {

		int sum = s.getKorean() + s.getEnglish() + s.getMath();
		return sum;
	}

	public double average(Student s) {

		int sum = s.getKorean() + s.getEnglish() + s.getMath();
		double average = (double) sum / 3;
		return average;
	}

	public static void main(String[] args) {

		// 3.main()메소드에 아래 내용을 정의해봅시다.
		//
		// ①Student 타입의 배열을 선언하고, 요소 10개를 저장할 수 있는 배열 인스턴스를 생성해 봅시다.
		//
		Student[] s = new Student[10];
		// ②Student 타입의 인스턴스를 생성하고 배열에 저장하는 코드를 정의해봅시다.
		//

		Student s1 = new Student();
		s1.setName("홍길동");
		s1.setKorean(80);
		s1.setEnglish(70);
		s1.setMath(90);
		s[1] = s1;

		// ③배열에 저장된 Student 타입의 인스턴스의 메소드를 이용해서 모든 데이터를 출력해봅시다.
		System.out.println("이름: " + s[1].name);
		System.out.println("국어 점수: " + s[1].korean);
		System.out.println("영어 점수: " + s[1].english);
		System.out.println("수학 점수: " + s[1].math);

		System.out.println("총점: " + s[1].sum(s[1]));
		System.out.println("평균: " + s[1].average(s[1]));

	}

}
