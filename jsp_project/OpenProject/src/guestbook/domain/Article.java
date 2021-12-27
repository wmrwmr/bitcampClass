package guestbook.domain;

public class Article {

	private int idx;
	private String subject;
	private String content;
	private String regdate;
	private String username;
	private String photo;

	public Article(int idx, String subject, String content, String regdate, String username, String photo) {
		this.idx = idx;
		this.subject = subject;
		this.content = content;
		this.regdate = regdate;
		this.username = username;
		this.photo = photo;
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

	@Override
	public String toString() {
		return "Article [idx=" + idx + ", subject=" + subject + ", content=" + content + ", regdate=" + regdate
				+ ", username=" + username + ", photo=" + photo + "]";
	}

}
