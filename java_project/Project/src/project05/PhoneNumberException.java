package project05;

public class PhoneNumberException extends Exception {

	public PhoneNumberException() {
		super("중복된 전화번호를 입력 하셨습니다.");
	}

}
