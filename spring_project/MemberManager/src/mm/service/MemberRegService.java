package mm.service;

import mm.dao.Dao;
import mm.dao.MemberDao;
import mm.domain.Member;
import mm.domain.RegRequest;
import mm.exception.DuplicateMemberException;

public class MemberRegService {

	//MemberDao dao = new MemberDao(); // 의존상태
	
	private Dao dao;	
	// Dao 타입의 객체를 주입 받는 방법 : 생성자, setter 메소드
	
	public MemberRegService() {}
	
	public MemberRegService(Dao dao) {
		this.dao = dao;
	}
	
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
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
