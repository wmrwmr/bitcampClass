package chapter06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScoreManager02 {
	// 배열을 가지고 있고,
	// 배열의 요소를 추가, 검색, 삭제 기능
	
	// 2021.10.20: 배열을 ArrayList로 변경
	
	public static final Scanner sc = new Scanner(System.in);
	
	
//	private Student[] score;
	
	private List<Student> score;


	public ScoreManager02(int size) {
//		score = new Student[size];
		score = new ArrayList<Student>(size);


	}

	public ScoreManager02() {
		this(10);
	}

	// 전체 데이터 출력: 배열의 입력된 모든 데이터를 출력(null 제외)
	public void showAllData() {
		System.out.println("학생 점수 리스트");
		System.out.println("----------------------------------------------");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println("----------------------------------------------");
//		for (int i = 0; i < numOfStudent; i++) {
//			System.out.println(score[i]);
//		}
		for(Student s : score) {
			System.out.println(s);
		}
		
		
		System.out.println("----------------------------------------------");

	}

	// 데이터 추가: 배열의 요소로 추가 -> Student 타입의 참조값
	// List에 요소 추가
	
	
	public void insertScore(Student s) {
		score.add(s);
//		score[numOfStudent++] = s;
////		score[numOfStudent] = s;
////		numOfStudent++;

	}

	// 데이터 검색: 이름 기준 검색(이름 중복은 없음) -> 배열의 요소들 중 이름(검색어)을 비교
	public void searchData() {
		System.out.println("검색하고자 하는 학생의 이름을 입력해주세요");
		String name = sc.nextLine();

		// -1 또는 배열 범위 안의 정수 0~N-1

		int index = searchIndex(name);

		if (index > -1) {
			System.out.println(score.get(index));
		} else {
			System.out.println("검색하신 이름의 데이터가 존재하지 않습니다.");
		}

//		for (int i = 0; i < numOfStudent; i++) {
//			// 검색어와 요소 객체의 name 문자열을 비교
//			if (score[i].getName().equals(name)) {
//				System.out.println(score[i]);
//			}
//		}
	}

	// 데이터 삭제: 이름 기준으로 삭제 -> 배열에 요소에 홍길동 정보를 지운다 -> 홍길동 객체를 참조하는 값이 없으면

	public void deleteScore() {
		System.out.println("삭제하고자 하는 학생의 이름을 입력해주세요");
		String name = sc.nextLine();
		
		int index = searchIndex(name);

		if (index > -1) {
			// 시프트: 참조값을 지운다! -> 정보 삭제
//			for (int i = index; i < numOfStudent - 1; i++) {
//				score[i] = score[i + 1];
//			}
//			numOfStudent--;
			score.remove(index);
			System.out.println("데이터가 삭제되었습니다.");
		} else {
			System.out.println("검색하신 이름의 데이터가 존재하지 않습니다.");
		}

//		for (int i = 0; i < numOfStudent; i++) {
//			if (score[i].getName().equals(name)) {
//				for (int j = i; j < numOfStudent - 1; j++) {
//					score[j] = score[j + 1];
//				}
//				numOfStudent--;
//				System.out.println("삭제되었습니다.");
//
//			}
//		}

	}

	// 이름으로 배열의 index를 찾아 index값을 반환하는 메소드
	private int searchIndex(String name) {
		int index = -1;

		for (int i = 0; i < score.size(); i++) {
			if (score.get(i).getName().equals(name)) {
				index = i;
				break;
			}
		}

		return index;
	}

	// 학생 정보를 저장하고 -> 배열에 저장하는 메소드
	public void insertStudent() {
		System.out.println("학생 성적 데이터를 입력합니다.");
		System.out.println("이름>> ");
		String name = sc.nextLine();
		System.out.println("국어 점수>>");
		int korean = Integer.parseInt(sc.nextLine());
		System.out.println("영어 점수>>");
		int english = Integer.parseInt(sc.nextLine());
		System.out.println("수학 점수>>");
		int math = Integer.parseInt(sc.nextLine());

		insertScore(new Student(name, korean, english, math));
		System.out.println("성적 데이터가 입력 되었습니다.");

	}
	
	public void printMenu() {
		
		
		System.out.println("시험점수 관리 프로그램");
		System.out.println("--------------------");
		System.out.println("1. 학생 점수 데이터 입력");
		System.out.println("2. 전체 데이터 출력");
		System.out.println("3. 학생 점수 검색");
		System.out.println("4. 학생 점수 삭제");
		System.out.println("5. 프로그램 종료");
		System.out.println("--------------------");
		System.out.println("메뉴 번호를 입력해주세요 >>>>>");
	}

}
