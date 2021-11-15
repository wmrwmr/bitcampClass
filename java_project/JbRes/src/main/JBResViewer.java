package main;

import java.util.Scanner;

import javax.swing.JOptionPane;
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

	public JBResViewer() {
		scanner = new Scanner(System.in);
		inputC = new BadInputController();
		resV = new ReservationViewer(scanner, inputC);
		fdV = new FoodViewer(scanner, inputC);
		ordV = new OrdersViewer(scanner, inputC, fdV);
		memV = new MembersViewer(inputC);

	}

	public void showMain() {
		System.out.println();
		System.out.println("\t\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t\t●     JAVA  &  DB  RESTAURANT     ●");
		System.out.println("\t\t■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

		while (true) {
			System.out.println();
			System.out.println();
			System.out.println("────────────────────────────[ 테이블 현황  ]────────────────────────────");

			ordV.tablePrinter();
			System.out.println("-------------------------------------------------------------------");
			System.out.print(Menu.PAYMENT + ". 결제하기   ");
			System.out.print(Menu.ADDORDER + ". 주문 추가하기   ");
			System.out.print(Menu.FOOD + ". 메뉴 관리   ");
			System.out.print(Menu.RESERVATION + ". 예약 관리   ");
			System.out.print(Menu.MEMBERSHIP + ". 멤버쉽 관리   ");
			System.out.print(Menu.EXIT + ". 종료");
			System.out.println();
			System.out.println("-------------------------------------------------------------------");
			int userChoice = inputC.checkInt("> ", Menu.EXIT, Menu.MEMBERSHIP);

			if (userChoice == Menu.PAYMENT) {
				System.out.println();
				System.out.println();
				System.out.print("────────────────────────────[ PAYMENT ]────────────────────────────");
				int total = ordV.payment();

				if (total != 0) {
					int yesNo = JOptionPane.showConfirmDialog(null, "마일리지를 적립 하시겠습니까?", "", JOptionPane.YES_NO_OPTION);
					if (yesNo == JOptionPane.YES_OPTION) {
						int exitCode = 1;
						memV.manageMembers(total, exitCode);
					}
				}

			} else if (userChoice == Menu.ADDORDER) {
				System.out.println();
				System.out.println();
				System.out.print("─────────────────────────────[ ORDER ]─────────────────────────────");
				ordV.orderManager();

			} else if (userChoice == Menu.FOOD) {
				System.out.println();
				System.out.println();
				System.out.print("─────────────────────────────[ MENU ]──────────────────────────────");
				fdV.manageFood();

			} else if (userChoice == Menu.RESERVATION) {
				System.out.println();
				System.out.println();
				System.out.print("──────────────────────────[ RESERVATION ]──────────────────────────");
				resV.manageReservation();

			} else if (userChoice == Menu.MEMBERSHIP) {
				System.out.println();
				System.out.println();
				System.out.print("──────────────────────────[ MEMBERSHIP ]───────────────────────────");
				int exitCode = 0;
				int payment = 0;
				memV.manageMembers(payment, exitCode);

			} else if (userChoice == Menu.EXIT) {
				System.out.println();
				System.out.println("-------------------------------------------------------------------");
				System.out.println("<프로그램을 종료합니다.>");
				System.out.println("===================================================================");
				scanner.close();
				break;
			}
		}
	}

}
