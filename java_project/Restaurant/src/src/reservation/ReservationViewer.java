package reservation;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import controller.BadInputController;
import controller.Menu;
import jdbc.ConnectionProvider;

public class ReservationViewer {
	private Scanner scanner;
	private BadInputController inputC;
	ReservationDAO rDao = ReservationDAO.getInstance();
	ReservationDTO rDto = new ReservationDTO();
	List<ReservationDTO> list = null;
	Connection conn = null;

	public ReservationViewer(Scanner scanner, BadInputController inputC) {
		this.scanner = scanner;
		this.inputC = inputC;
	}

	public void manageReservation() {
		try {
			conn = ConnectionProvider.getConnection();
			System.out.println("---------------------------------------------------------");

			// 전체 예약 리스트 출력 메소드
			showAll();
			System.out.println("[" + Menu.INSERT + "] 새 예약 등록");
			System.out.println("[" + Menu.UPDATE + "] 예약 수정");
			System.out.println("[" + Menu.DELETE + "] 예약 삭제");
			System.out.println("[" + Menu.EXIT + "] 뒤로 가기");
			int userChoice = inputC.checkUserChoice("\n> ", Menu.EXIT, Menu.DELETE);

			if (userChoice == Menu.INSERT) {
				// 예약 등록 메소드
				add();
			} else if (userChoice == Menu.UPDATE) {
				// 예약 수정 메소드
				update();
			} else if (userChoice == Menu.DELETE) {
				// 예약 삭제 메소드
				delete();
			} else if (userChoice == Menu.EXIT) {
				// 뒤로가기
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 예약 등록
	public void add() {
		showAll();
		System.out.println();
		System.out.println();
		System.out.println("예약 등록 시스템 입니다.");
		System.out.println("식당 예약을 하시겠습니까? Y/N ");
		String yesNo = scanner.nextLine();
		if (yesNo.equalsIgnoreCase("y")) {
			String name = inputC.checkStr("예약자 성함을 입력해주세요.");

			String phoneNumber = inputC.checkPhoneNum("연락처를 입력해주세요. (예: 010-0000-0000)");

			int count = Integer.parseInt(inputC.checkInt("예약 총 인원 수를 입력해주세요."));

			String date = inputC.validInputEntranceTime("예약하고자 하는 날짜와 시간을 입력해주세요. (예: 21-04-30 22)");

			int tid = inputC.checkUserChoice("원하시는 테이블 번호를 입력헤주세요. (1번 ~ 5번)", 1, 5);

			while (avail(date, tid)) {
				System.out.println(date + "시에 " + tid + "번 테이블은 예약 불가합니다.");
				System.out.println("날짜 및 테이블 번호를 다시 입력해주세요.");
				System.out.println();
				date = inputC.validInputEntranceTime("예약하고자 하는 날짜와 시간을 입력해주세요. (예: 21-04-30 22)");

				tid = inputC.checkUserChoice("원하시는 테이블 번호를 입력헤주세요. (1번 ~ 5번)", 1, 5);
			}

			rDto = new ReservationDTO(date, name, phoneNumber, count, tid);

			int insert = rDao.insert(conn, rDto);
			if (insert > 0) {
				System.out.println("예약되었습니다.");
				list = rDao.show(conn);

			} else {
				System.out.println("예약이 되지 않았습니다.");
			}
		} else {
			System.out.println("선택창으로 돌아갑니다.");
		}
	}

	// 인덱스 검색
	private int searchIndex(int rId) {
		int index = -1;
		list = rDao.show(conn);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getRid() == rId) {
				index = i;
				break;
			}
		}
		return index;
	}

	// 예약 정보 수정
	void update() {
		showAll();
		while (true) {
			int choice = inputC.checkUserChoice("1. 예약 수정 \t 2. 뒤로가기", 1, 2);

			if (choice == 1) {
				int rId = Integer.parseInt(inputC.checkInt("수정하고자 하는 예약 번호를 입력해주세요."));
				int index = searchIndex(rId);
				if (index > -1) {
					System.out.println("예약정보를 수정합니다...");
					System.out.println("--------------------------------------------------");
					show();
					String rName = inputC.checkStr("예약자 성함을 입력해주세요.");

					String rPhoneNumber = inputC.checkPhoneNum("연락처를 입력해주세요. (예 : 010-0000-0000)");

					int count = Integer.parseInt(inputC.checkInt("예약 인원 수를 입력해주세요."));

					String rDate = inputC.validInputEntranceTime("예약하고자 하는 날짜와 시간을 입력해주세요. (예: 21-04-30 22)");

					int tid = inputC.checkUserChoice("원하시는 테이블 번호를 입력헤주세요. (1번 ~ 5번)", 1, 5);

					while (avail(rDate, tid)) {
						System.out.println(rDate + "시에 " + tid + "번 테이블은 예약 불가합니다.");
						System.out.println("날짜 또는 테이블 번호를 변경해주세요.");
						System.out.println();
						rDate = inputC.validInputEntranceTime("예약하고자 하는 날짜와 시간을 입력해주세요. (예: 21-04-30 22)");

						tid = inputC.checkUserChoice("원하시는 테이블 번호를 입력헤주세요. (1번 ~ 5번)", 1, 5);
					}

					list.set(index, new ReservationDTO(rDate, rName, rPhoneNumber, count, tid));
					int update = rDao.update(conn, list.get(index));
					list = rDao.show(conn);
					if (update > 0) {
						System.out.println("예약 정보가 수정되었습니다.");

					} else {
						System.out.println("예약정보 수정이 되지않았습니다.");
					}
				} else {
					System.out.println("존재하지 않는 예약정보입니다.");
				}
			} else {
				break;
			}
		}
	}

	// 예약 정보 삭제
	void delete() {
		showAll();
		while (true) {
			int choice = inputC.checkUserChoice("1. 예약 취소 \t 2. 뒤로가기", 1, 2);
			if (choice == 1) {

				int rId = Integer.parseInt(inputC.checkInt("취소할 예약 번호를 입력해주세요."));

				int index = searchIndex(rId);
				if (index > -1) {
					int del = rDao.delete(conn, list.get(index).getRid());

					list = rDao.show(conn);
					System.out.println("예약이 취소되었습니다.");
					break;
				} else {
					System.out.println("존재하지 않는 정보입니다.");
				}
			} else {
				System.out.println("선택창으로 돌아갑니다.");
			}
		}
	}

	void showNumber() {
		System.out.println("예약 갯수: " + list.size());
	}

	// 개별 출력
	void show() {
		showAll();
		while (true) {
			int rId = Integer.parseInt(inputC.checkInt("조회할 예약 번호를 입력하세요."));
			int index = searchIndex(rId);
			if (index > -1) {

				System.out.println();
				System.out.println("조회한 예약 정보");
				System.out.println("--------------------------------------------------");
				System.out.println(list.get(index));
				break;

			} else {
				System.out.println("존재하지 않는 정보입니다.");
			}
		}

	}

	// 전체 출력
	void showAll() {
		list = rDao.show(conn);
		System.out.println("예약자 정보입니다.");
		System.out.println("예약 번호" + "\t" + "성함" + "\t" + "전화번호" + "\t" + "\t" + "예약 인원" + "\t" + "예약 날짜" + "\t" + "\t"
				+ "예약 테이블");
		System.out.println("---------------------------------------------------------------------");
		if (list.size() == 0) {
			System.out.println("아직 등록된 예약이 없습니다.");
			System.out.println("--------------------------------------------------");
		} else {
			for (ReservationDTO r : list) {
				System.out.println(r);
			}
		}
	}

	boolean avail(String date, int tid) {
		list = rDao.show(conn);

		String rDate = "";

		boolean b = false;
		for (int i = 0; i < list.size(); i++) {
			rDate = list.get(i).getRdate();

			if (rDate.equals(date) && list.get(i).getTid() == tid) {
				b = true;
			}
		}
		return b;
	}

}
