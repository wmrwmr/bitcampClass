package controller;

public interface Menu {
	int EXIT = 0;

	int PAYMENT = 1;
	int ADDORDER = 2;
	int FOOD = 3;
	int RESERVATION = 4;
	int MEMBERSHIP = 5;

	int INSERT = 1;
	int UPDATE = 2;
	int DELETE = 3;

	int SEARCH_NAME = 2;
	int SEARCH_PHONE = 3;
	int SHOW_ALL = 4;

	int M_UPDATE = 1;
	int M_DELETE = 2;

	int F_SHOW_ALL = 1;
	int F_INSERT = 2;
	int F_EXIT = 3;

	int F_UPDATE = 1;
	int F_DELETE = 2;

	int O_INSERT = 1;
	int O_DELETE = 2;
	int O_EXIT = 2;
	int ADD_BONUS = 1;

	int R_SEARCH = 5;
}
