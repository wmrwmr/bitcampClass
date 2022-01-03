package mm.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import mm.dao.Dao;
import mm.dao.MemberDao;
import mm.domain.Member;
import mm.domain.RegRequest;
import mm.exception.DuplicateMemberException;

@Component("regService")
public class MemberRegService2 {

	//@Autowired
	//@Qualifier("guestDao")
	@Resource
	private Dao dao;	// Dao 타입의 bean을 자동 주입
	
	public MemberRegService2() {}
	
	
	public void regMember(RegRequest request) throws DuplicateMemberException {
		
		// 이메일 중복 체크
		Member member = dao.selectByEmail(request.getEmail());
		
		if(member != null) {
			throw new DuplicateMemberException("이미 존재하는 이메일!");
		}
		
		dao.insert(request.toMember());
		System.out.println("[msg : 등록되었습니다.]");
	}
	
	
}
