package mm.domain;

import java.util.Date;

import mm.exception.IdPasswordNotMatchingException;

public class Member {

	// 아이디, 이메일, 비밀번호, 이름, 가입일시
	private long id;
	private String email;
	private String password;
	private String name;
	private Date regDate;

	public Member(long id, String email, String password, String name, Date regDate) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.regDate = regDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	// 비밀번호 변경 메소드
	public void changePassword(String oldPw, String newPw) throws IdPasswordNotMatchingException {
		
		if(!this.password.equals(oldPw)) {
			throw new IdPasswordNotMatchingException("비빌번호 일치하지 않습니다.");
		}
		
		this.password = newPw;
		
	}

}
