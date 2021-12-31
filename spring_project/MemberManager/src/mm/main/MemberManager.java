package mm.main;

import java.util.Scanner;
import mm.assembler.Assembler;
import mm.domain.RegRequest;
import mm.exception.DuplicateMemberException;
import mm.exception.IdPasswordNotMatchingException;
import mm.exception.NotFoundMemberException;
import mm.service.ChangePasswordService;
import mm.service.MemberRegService;

public class MemberManager {

	// 조립기 (컨테이너)
	static Assembler assembler = new Assembler();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			printMenu();
			String command = sc.nextLine();

			// exit
			if (command.equalsIgnoreCase("exit")) {
				System.out.println("프로그램 종료");
				sc.close();
				return;
			}

			if (command.startsWith("new")) {
				String[] values = command.split(" ");
				processNewMember(values);
			}

			if (command.startsWith("change")) {
				processChangePassword(command.split(" "));
			}
		}
	}

	private static void processNewMember(String[] values) {
		MemberRegService regService = assembler.getRegService();
		RegRequest request = new RegRequest(values[1], values[3], values[4], values[2]);

		// 비밀번호와 비밀번호 확인 비교
		if (!request.isPwRePwEquals()) {
			System.out.println("비밀번호와 비밀번호확인이 서로 일치 하지 않습니다.");
			return;
		}

		try {
			regService.regMember(request);
		} catch (DuplicateMemberException e) {
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}
	}

	private static void processChangePassword(String[] values) {
		ChangePasswordService changePassword = assembler.getPasswordService();

		try {
			changePassword.changePassword(values[1], values[2], values[3]);
		} catch (NotFoundMemberException e) {
			System.out.println(e.getMessage());
			// e.printStackTrace();
		} catch (IdPasswordNotMatchingException e) {
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}

	}

	static void printMenu() {
		System.out.println();
		System.out.println("명령어 사용법");
		System.out.println("--------------------------------");
		System.out.println("신규 입력");
		System.out.println("new 이메일 이름 비밀번호 비밀번호확인");
		System.out.println("new son@gmail.com 손흥민 123 123"); // 공백을 이용해 split
		System.out.println("비밀번호 수정");
		System.out.println("change 이메일 현재비밀번호 새비밀번호");
		System.out.println("change son@gmail.com 123 000");
		System.out.println("--------------------------------");
	}

}