package project06;

public class NameException extends Exception {
	public NameException() {
		super("영문 및 한글만 입력해 주세요(공백 포함 금지)");
	}
}
