package mm.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import mm.domain.Member;

@Component("dao")   // memberDao
@Qualifier("md")
public class MemberDao implements Dao {
	
	// ID 
	private static int nextId = 0;
	
	// 회원 정보를 저장 
	private Map<String, Member> map = new HashMap<String, Member>();

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
