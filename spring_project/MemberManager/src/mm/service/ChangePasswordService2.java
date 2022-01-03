package mm.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import mm.dao.Dao;
import mm.domain.Member;
import mm.exception.IdPasswordNotMatchingException;
import mm.exception.NotFoundMemberException;

@Component("changeService")
public class ChangePasswordService2 {

	//@Autowired
	//@Qualifier("guestDao")
	@Resource
	private Dao dao;

	public ChangePasswordService2() {}
	
	
	public void changePassword(String email, String oldPw, String newPw) throws NotFoundMemberException, IdPasswordNotMatchingException {
		
		// 회원이 존재 하는지 여부 -> 예외 발생!
		Member member = dao.selectByEmail(email);
		
		if(member == null) {
			throw new NotFoundMemberException("등록된 회원정보 없습니다.");
		}
		
		member.changePassword(oldPw, newPw);
		
		dao.update(member);
		
		System.out.println("비밀번호가 변경되었습니다.");
		
	}
	
	
	
	
}
