package guestbook.domain;

public class PageView {

	private int idx;
	private String subject;
	private String content;
	private String regdate;
	private String username;
	private String photo;
	private int memberidx;
	private String userid;

	public PageView(int idx, String subject, String content, String regdate, String username, String photo,
			int memberidx, String userid) {
		this.idx = idx;
		this.subject = subject;
		this.content = content;
		this.regdate = regdate;
		this.username = username;
		this.photo = photo;
		this.memberidx = memberidx;
		this.userid = userid;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getMemberidx() {
		return memberidx;
	}

	public void setMemberidx(int memberidx) {
		this.memberidx = memberidx;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "PageView [idx=" + idx + ", subject=" + subject + ", content=" + content + ", regdate=" + regdate
				+ ", username=" + username + ", photo=" + photo + ", memberidx=" + memberidx + ", userid=" + userid
				+ "]";
	}

}
