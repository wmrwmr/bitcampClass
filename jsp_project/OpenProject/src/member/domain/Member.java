package member.domain;

import java.sql.Timestamp;

/*
	작업자 : 유영진
	날짜 : 2021.12.21
	작업내용 : 사진 파일의 경로를 저장하는 변수 추가
*/
public class Member {

	private int idx;
	private String userid;
	private String pw;
	private String username;
	// private Timestamp regdate; // java.sql.TimeStamp -> java.util.Date
	private String regdate; // DB -> 2021.12.20. 12:21
	// 2021.12.21 photo 추가
	private String photo;

	public Member(int idx, String userid, String pw, String username, String regdate, String photo) {
		this.idx = idx;
		this.userid = userid;
		this.pw = pw;
		this.username = username;
		this.regdate = regdate;
		this.photo = photo;
	}

	public Member() {
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Member [idx=" + idx + ", userid=" + userid + ", pw=" + pw + ", username=" + username + ", regdate="
				+ regdate + ", photo=" + photo + "]";
	}
	
	public LoginInfo getLoginInfo() {
		return new LoginInfo(this.idx, this.userid, this.username, this.photo);
	}
	
	

}
