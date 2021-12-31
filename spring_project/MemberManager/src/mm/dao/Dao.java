package mm.dao;

import java.util.Collection;

import mm.domain.Member;

public interface Dao {

	// 회원 정보 저장
	void insert(Member member);
	
	// 회원 데이터 수정
	void update(Member member);
	
	// 회원 데이터 email 검색 -> Member 객체로 반환
	Member selectByEmail(String email);
	
	// 전체 데이터 반환
	Collection<Member> selectAll();
}









