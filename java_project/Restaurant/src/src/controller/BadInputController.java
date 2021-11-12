package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BadInputController {
	Scanner scanner = new Scanner(System.in);

	private void checkBadInput(boolean checkStr) throws BadInputException {
		if (checkStr) {
			BadInputException e = new BadInputException();
			throw e;
		}
	}

	public int checkUserChoice(String message, int min, int max) {
		int userChoiceI;

		while (true) {
			try {
				System.out.print(message);
				String userChoiceS = scanner.nextLine().trim();
				if (!(userChoiceS.matches("^[0-9]+$")) || Integer.parseInt(userChoiceS) < min
						|| Integer.parseInt(userChoiceS) > max) {
					checkBadInput(true);
				}
				userChoiceI = Integer.parseInt(userChoiceS);
				break;

			} catch (BadInputException e) {
				System.out.println(e.getMessage());
			}
		}
		return userChoiceI;
	}

	public String checkStr(String message) {
		String str;
		while (true) {
			try {
				System.out.println("---------------------------------------------------------");
				System.out.print(message);
				str = scanner.nextLine().trim();
				checkBadInput(!(str.matches("^[가-힣a-zA-Z]+$")));
				break;
			} catch (BadInputException e) {
				System.out.println(e.getMessage());
			}
		}
		return str;
	}

	public String checkInt(String message) {
		String str;
		while (true) {
			try {
				System.out.print(message);
				str = scanner.nextLine().trim();
				checkBadInput(!(str.matches("^[0-9]+$")));
				break;
			} catch (BadInputException e) {
				System.out.println(e.getMessage());
			}
		}
		return str;
	}

	public String checkPhoneNum(String message) {
		String phoneNum;
		int noticeCode = 0;
		while (true) {
			try {
				System.out.println("---------------------------------------------------------");
				// 전화번호를 입력해주세요. (예: 010-9999-8888)\n>
				System.out.print(message);
				phoneNum = scanner.nextLine().trim();
				checkBadInput(!(phoneNum.matches("^\\d{2,3}-\\d{3,4}-\\d{4}$")));
				break;
			} catch (BadInputException e) {
				System.out.println(e.getMessage());
			}
		}
		return phoneNum;
	}

	// ---------------------------------------------------------------------------------------

	public String validInputEntranceTime(String message) {

		String s;

		String date = "";

		while (true) {

			try {
				System.out.println("---------------------------------------------------------");
				System.out.println(message);
				System.out.print(">>  ");
				s = scanner.nextLine().trim();
				checkBadInput(!(s.matches("^\\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01]) (0[1-9]|1[0-9]|2[0-4])")));

				SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH");
				Date formatD = sdf.parse(s);
				date = sdf.format(formatD);
				break;
			} catch (BadInputException e) {
				System.out.println(e.getMessage());
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
		return date;
	}

}
