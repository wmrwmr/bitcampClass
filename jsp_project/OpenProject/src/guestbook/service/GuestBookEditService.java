package guestbook.service;

public class GuestBookEditService {

	private GuestBookEditService() {}
	private static GuestBookEditService service = new GuestBookEditService();
	public static GuestBookEditService getInstance() {
		return service;
	}
}
