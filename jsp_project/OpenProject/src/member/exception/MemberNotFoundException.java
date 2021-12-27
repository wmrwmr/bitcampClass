package member.exception;

public class MemberNotFoundException extends Exception {

	public MemberNotFoundException(String message) {
		super(message + " 는 존재 하지않는 회원");
	}

}
