package mm.dao;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import mm.domain.Member;

@Component("guestDao")
@Qualifier("gd")
public class GuestDao implements Dao {

	@Override
	public void insert(Member member) {
		System.out.println("GuestDao insert()");

	}

	@Override
	public void update(Member member) {
		System.out.println("GuestDao 객체의 메소드 실행");

	}

	@Override
	public Member selectByEmail(String email) {
		System.out.println("GuestDao selectByEmail()");
		return null;
	}

	@Override
	public Collection<Member> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
