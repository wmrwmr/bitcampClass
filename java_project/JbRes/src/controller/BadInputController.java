package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class BadInputController {
	Scanner scanner = new Scanner(System.in);

	private void checkBadInput(boolean checkStr) throws BadInputException {
		if (checkStr) {
			BadInputException e = new BadInputException();
			throw e;
		}
	}

	public int checkInt(String message, int min, int max) {
		int num;
		while (true) {
			try {
				System.out.print(message);
				String numS = scanner.nextLine().trim();
				if (!(numS.matches("^[0-9]+$")) || numS.length() > 10 || Integer.parseInt(numS) < min
						|| Integer.parseInt(numS) > max) {
					checkBadInput(true);
				}
				num = Integer.parseInt(numS);
				break;

			} catch (BadInputException e) {
				System.out.println(e.getMessage());
			}
		}
		return num;
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

	public int checkIntDial(String message, int min, int max) {
		int num = 0;
		String str = JOptionPane.showInputDialog(message);
		while (true) {
			try {
				if (str == null) {
					break;
				}
				str = str.trim();
				if (!(str.matches("^[0-9]+$")) || str.length() > 10 || Integer.parseInt(str) < min
						|| Integer.parseInt(str) > max) {
					checkBadInput(true);
				}
				num = Integer.parseInt(str);
				break;

			} catch (BadInputException e) {
				str = JOptionPane.showInputDialog(e.getMessage() + message);
			}
		}
		return num;
	}

	public String checkIntDial(String message) {
		String str = JOptionPane.showInputDialog(message);
		while (true) {
			try {
				if (str == null) {
					break;
				}
				str = str.trim();
				checkBadInput(!(str.matches("^[0-9]+$")));
				break;
			} catch (BadInputException e) {
				str = JOptionPane.showInputDialog(e.getMessage() + message);
			}
		}
		return str;
	}

	public String checkStr(String message) {
		String str;
		while (true) {
			try {
				System.out.print(message);
				str = scanner.nextLine().trim();
				checkBadInput(!(str.matches("^[가-힣a-zA-Z\\s?]+$")));
				break;
			} catch (BadInputException e) {
				System.out.println(e.getMessage());
			}
		}
		return str;
	}

	public String checkStrDial(String message) {
		String str = JOptionPane.showInputDialog(message);
		while (true) {
			try {
				if (str == null) {
					break;
				}
				str = str.trim();
				checkBadInput(!(str.matches("^[가-힣a-zA-Z\\s?]+$")));
				break;
			} catch (BadInputException e) {
				str = JOptionPane.showInputDialog(e.getMessage() + message);
			}
		}
		return str;
	}

	public String checkPhoneNum(String message) {
		String phoneNum;
		while (true) {
			try {
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

	public String checkPhoneNumDial(String message) {
		String phoneNum = JOptionPane.showInputDialog(message);
		while (true) {
			try {
				if (phoneNum == null) {
					break;
				}
				// 전화번호를 입력해주세요. (예: 010-9999-8888)\n>
				phoneNum = phoneNum.trim();
				checkBadInput(!(phoneNum.matches("^\\d{2,3}-\\d{3,4}-\\d{4}$")));
				break;
			} catch (BadInputException e) {
				phoneNum = JOptionPane.showInputDialog(e.getMessage() + message);
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
				System.out.print(message);
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
