package chapter10.exception;
//1. 콘솔에서 사용자 아이디를 입력 받아 정상적인 영문자와 숫자로만 이루어진 값을 입력했는지 확인하는 프로그램을 만들어봅시다. 

import java.util.InputMismatchException;

//① 사용자 예외 클래스를 정의해서 예외를 발생 시켜 봅시다.
//② 예외 클래스 이름은 BadIdInputException이라고 정의합시다.

//2. Scanner 클래스로 태어난 년도를 입력 받을 때 int 타입으로 받도록 합시다. 
//이때 nextInt() 메소드를 사용하게 되는데 이때 발생하는 예외처리를 하도록 합시다. 
import java.util.Scanner;


//public class BadInputExceptionTest {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//
//		System.out.println("아이디를 입력해주세요");
//
//		try {
//
////			String id = readId();
//			System.out.println("아이디: " + id);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//
//		System.out.println("태어난 년도를 입력해주세요");
//
//		try {
//
//			int birthYear = readBirthYear();
//			System.out.println("태어난 년도: " + birthYear);
//		} catch (InputMismatchException e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//
//	}
//
////	public static String readId() throws BadInputException {
////		Scanner sc = new Scanner(System.in);
////		String id = sc.nextLine();
////		if (!('a' <= c && c <= 'z' || 'A' <= c && c <= 'Z' || '0' <= c && c <= '9')) {
////			BadInputException excpt = new BadInputException();
////			throw excpt;
////		}
////		return id;
////	}
//
//	public static int readBirthYear() throws BadInputException02 {
//		Scanner sc = new Scanner(System.in);
//		int birthYear = sc.nextInt();
//		if (birthYear < 0) {
//			BadInputException02 excpt = new BadInputException02();
//			throw excpt;
//		}
//		return birthYear;
//	}
//
//}
