package project06;

public class PhoneNumberException extends Exception {

	public PhoneNumberException() {
		super("중복된 정보를 입력하셨거나, 형식이 올바르지 않습니다.\nooo-oooo-oooo 형식으로 입력해주세요");
	}

}
