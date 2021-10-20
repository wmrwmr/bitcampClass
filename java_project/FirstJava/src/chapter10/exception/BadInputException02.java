package chapter10.exception;

public class BadInputException02 extends Exception {
	public BadInputException02() {
		super("유효하지 않은 태어난 년도가 입력되었습니다.");
	}
}
