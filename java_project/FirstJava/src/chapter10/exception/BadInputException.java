package chapter10.exception;



public class BadInputException extends Exception {

	public BadInputException() {
		super("유효하지 않은 아이디가 입력되었습니다.");
	}

}
