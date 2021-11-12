package reservation;

import java.util.Scanner;
import controller.BadInputController;
import controller.Menu;

public class ReservationViewer {
	private Scanner scanner;
	private BadInputController inputC;

	public ReservationViewer(Scanner scanner, BadInputController inputC) {
		this.scanner = scanner;
		this.inputC = inputC;
	}

	public void manageReservation() {
		System.out.println("---------------------------------------------------------");
		
		// 전체 예약 리스트 출력 메소드
		
		System.out.println("[" + Menu.INSERT + "] 새 예약 등록");
		System.out.println("[" + Menu.UPDATE + "] 예약 수정");
		System.out.println("[" + Menu.DELETE + "] 예약 삭제");
		System.out.println("[" + Menu.EXIT + "] 뒤로 가기");
		int userChoice = inputC.checkUserChoice("\n> ", Menu.EXIT, Menu.DELETE);

		if (userChoice == Menu.INSERT) {
			// 예약 등록 메소드
		} else if (userChoice == Menu.UPDATE) {
			// 예약 수정 메소드
		} else if (userChoice == Menu.DELETE) {
			// 예약 삭제 메소드
		} else if (userChoice == Menu.EXIT) {
			// 뒤로가기
		}
	}

}
