package question143;

//문제 2. 다음 형태로 주민번호를 담고 있는 String 인스턴스를 하나 생성
//String str = “990929-1010123”
//이 문자열을 이용하여 중간에 삽입된 – 를 뺀 String 인스턴스를 생성.


public class JuminNumber {
	

		String str = "990929-1010123";
		
		StringBuilder sb = new StringBuilder(str);
		
		StringBuilder sb1 = sb.delete(6, 7);
		
		
	

}
