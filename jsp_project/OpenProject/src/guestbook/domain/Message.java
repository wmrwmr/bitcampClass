package guestbook.domain;

public class Message {

	private int idx;
	private String subject;
	private String content;
	private String regdate;
	private int memberIdx;

	public Message(int idx, String subject, String content, String regdate, int memberIdx) {
		this.idx = idx;
		this.subject = subject;
		this.content = content;
		this.regdate = regdate;
		this.memberIdx = memberIdx;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
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

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getMemberIdx() {
		return memberIdx;
	}

	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}

	@Override
	public String toString() {
		return "Message [idx=" + idx + ", subject=" + subject + ", content=" + content + ", regdate=" + regdate
				+ ", memberIdx=" + memberIdx + "]";
	}

}
