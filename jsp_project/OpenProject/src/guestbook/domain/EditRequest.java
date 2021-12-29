package guestbook.domain;

public class EditRequest {

	private int guestbookIdx;
	private int memberIdx;
	private String subject;
	private String content;

	public EditRequest() {
	}

	public EditRequest(int guestbookIdx, int memberIdx, String subject, String content) {
		this.guestbookIdx = guestbookIdx;
		this.memberIdx = memberIdx;
		this.subject = subject;
		this.content = content;
	}

	public int getGuestbookIdx() {
		return guestbookIdx;
	}

	public void setGuestbookIdx(int guestbookIdx) {
		this.guestbookIdx = guestbookIdx;
	}

	public int getMemberIdx() {
		return memberIdx;
	}

	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "EditRequest [guestbookIdx=" + guestbookIdx + ", memberIdx=" + memberIdx + ", subject=" + subject
				+ ", content=" + content + "]";
	}

}
