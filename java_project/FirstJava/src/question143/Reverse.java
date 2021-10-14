package question143;
//문제 1. 다음 형태로 String 인스턴스를 생성.

//String str = “ABCDEFGHIJKLMN”;
//그리고 이 문자열을 역순으로 다시 출력하는 프로그램을 작성.

public class Reverse {

	public static void main(String[] args) {

		String str = "ABCDEFGHIJKLMN";

		StringBuilder sb = new StringBuilder(str);

		StringBuilder sb1 = sb.reverse();

		System.out.println(sb1);
	}

}
