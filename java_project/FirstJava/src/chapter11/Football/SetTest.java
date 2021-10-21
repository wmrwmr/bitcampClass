package chapter11.Football;

import java.util.HashSet;
import java.util.Iterator;

//2.축구선수의 인스턴스가 팀과 이름 그리고 나이가 같으면 
//같은 선수라 판단하고 입력이 되지 않도록 Set<E> 컬렉션을 이용해서 축구선수 인스턴스를 저장하고 출력하는 프로그램을 만들어 봅시다.
//
public class SetTest {
	public static void main(String[] args) {

		HashSet<FootballPlayer> set = new HashSet<FootballPlayer>();

		set.add(new FootballPlayer("손흥민", 7, "토트넘", 32));
		set.add(new FootballPlayer("케인", 8, "토트넘", 33));
		set.add(new FootballPlayer("손흥민", 7, "토트넘", 32));

		Iterator<FootballPlayer> itr = set.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

	}
}
