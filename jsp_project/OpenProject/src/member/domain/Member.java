package member.domain;

import java.sql.Timestamp;

public class Member {

	private int idx;
	private String userid;
	private String pw;
	private String username;
	// private Timestamp regdate; // java.sql.TimeStamp -> java.util.Date
	private String regdate; // DB -> 2021.12.20. 12:21

	public Member(int idx, String userid, String pw, String username, String regdate) {
		this.idx = idx;
		this.userid = userid;
		this.pw = pw;
		this.username = username;
		this.regdate = regdate;
	}

	public Member() {
	}

	public final int getIdx() {
		return idx;
	}

	public final void setIdx(int idx) {
		this.idx = idx;
	}

	public final String getUserid() {
		return userid;
	}

	public final void setUserid(String userid) {
		this.userid = userid;
	}

	public final String getPw() {
		return pw;
	}

	public final void setPw(String pw) {
		this.pw = pw;
	}

	public final String getUsername() {
		return username;
	}

	public final void setUsername(String username) {
		this.username = username;
	}

	public final String getRegdate() {
		return regdate;
	}

	public final void setRegdate(String regdate) {
		this.regdate = regdate;
	}

}
