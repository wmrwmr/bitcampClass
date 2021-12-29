package guestbook.domain;

public class ReplyRequest {

	private int memberIdx;
	private int guestbookIdx;
	private String message;

	public ReplyRequest() {}
	
	public ReplyRequest(int memberIdx, int guestbookIdx, String message) {
		this.memberIdx = memberIdx;
		this.guestbookIdx = guestbookIdx;
		this.message = message;
	}

	public int getMemberIdx() {
		return memberIdx;
	}

	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}

	public int getGuestbookIdx() {
		return guestbookIdx;
	}

	public void setGuestbookIdx(int guestbookIdx) {
		this.guestbookIdx = guestbookIdx;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ReplyRequest [memberIdx=" + memberIdx + ", guestbookIdx=" + guestbookIdx + ", message=" + message + "]";
	}

}
