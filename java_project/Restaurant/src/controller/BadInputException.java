package controller;


public class BadInputException extends Exception {

	public BadInputException() {
		super("(잘못 입력하셨습니다.)");
	}
}
