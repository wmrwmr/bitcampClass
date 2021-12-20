package member.domain;

public class RegRequest {

	private String userid;
	private String pw;
	private String username;

	public RegRequest() {

	}

	public RegRequest(String userid, String pw, String username) {
		super();
		this.userid = userid;
		this.pw = pw;
		this.username = username;
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

	@Override
	public String toString() {
		return "RegRequest [userid=" + userid + ", pw=" + pw + ", username=" + username + "]";
	}
	
}









