package guestbook.service;

public class GuestBookDeleteService {

	private GuestBookDeleteService() {}
	private static GuestBookDeleteService service = new GuestBookDeleteService();
	public static GuestBookDeleteService getInstance() {
		return service;
	}
	
}
