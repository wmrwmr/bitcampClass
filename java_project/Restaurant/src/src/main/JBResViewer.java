package main;

import java.util.Scanner;

import controller.BadInputController;
import controller.Menu;
import food.FoodViewer;
import members.MembersViewer;
import orders.OrdersViewer;
import reservation.ReservationViewer;

public class JBResViewer {
	private Scanner scanner;
	private BadInputController inputC;
	private MembersViewer memV;
	private ReservationViewer resV;
	private OrdersViewer ordV;
	private FoodViewer fdV;

	private final int TABLEMAX = 5;

	public JBResViewer() {
		scanner = new Scanner(System.in);
		inputC = new BadInputController();
		memV = new MembersViewer(scanner, inputC);
		resV = new ReservationViewer(scanner, inputC);
		ordV = new OrdersViewer(scanner);
		fdV = new FoodViewer(scanner, inputC);

	}

	public void showMain() {
		System.out.println("		      ~~~~~~~~~~~");
		System.out.println("		      << 자비레스 >>");
		System.out.println("		      ~~~~~~~~~~~");
		System.out.println();

		while (true) {
			System.out.println("=========================================================");
			System.out.println("			테이블 현황");
			System.out.println("=========================================================");

			// -------------------------------------------
			// 테이블 현황 보기 메소드
			ordV.tablePrinter();
			// -------------------------------------------

			System.out.println();
			System.out.println("[" + Menu.PAYMENT + "] 결제하기");
			System.out.println("[" + Menu.ADDORDER + "] 주문 추가하기");
			System.out.println("[" + Menu.RESERVATION + "] 예약 관리");
			System.out.println("[" + Menu.MEMBERSHIP + "] 멤버쉽 관리");
			System.out.println("[" + Menu.FOOD + "] 메뉴 관리");
			System.out.println("[" + Menu.EXIT + "] 종료");
			int userChoice = inputC.checkUserChoice("\n> ", Menu.EXIT, Menu.FOOD);

			if (userChoice == Menu.PAYMENT) {
				System.out.println("---------------------------------------------------------");

				ordV.payment();

				// 적립 하시겠습닉까? 네/아니오
//				memV.manageMembers(payment);

			} else if (userChoice == Menu.RESERVATION) {
				resV.manageReservation();

			} else if (userChoice == Menu.ADDORDER) {
				// OrdersViewer

			} else if (userChoice == Menu.MEMBERSHIP) {
				memV.manageMembers(0);

			} else if (userChoice == Menu.FOOD) {
				fdV.manageFood();
				// FoodViewer

			} else if (userChoice == Menu.EXIT) {
				System.out.println("---------------------------------------------------------");
				System.out.println("<프로그램을 종료합니다.>");
				System.out.println("=========================================================");
				scanner.close();
				break;
			}
		}
	}

}
