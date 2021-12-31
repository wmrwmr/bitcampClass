package mm.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import mm.domain.Member;

public class MemberDao implements Dao {
	// ID
	private static int nextId = 0; // 인스턴스를 생성하면 어차피 0으로 초기화가 되지만 의미있는 숫자라면 0의로 명시하는것이 좋다.
	// 회원 정보를 저장
	private Map<String, Member> map = new HashMap<>();

	@Override
	public void insert(Member member) {
		member.setId(nextId++);
		map.put(member.getEmail(), member);
	}

	@Override
	public void update(Member member) {
		map.put(member.getEmail(), member);
	}

	@Override
	public Member selectByEmail(String email) {
		return map.get(email);
	}

	@Override
	public Collection<Member> selectAll() {
		return map.values();
	}

}