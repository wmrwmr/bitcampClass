package chapter11.Football;

import java.util.Iterator;
import java.util.TreeSet;

//3.TreeSet<E>을 이용해서 팀 이름순으로 정렬하고, 
//같은 팀의 선수들은 이름 순으로 정렬하고, 같은 이름의 선수는 번호 순으로 저장하는 프로그램을 만들어 봅시다.
//
public class TreeSetTest {

	public static void main(String[] args) {

		TreeSet<FootballPlayer> set = new TreeSet<FootballPlayer>();

		set.add(new FootballPlayer("KAYNE", 9, "TOT", 34));
		set.add(new FootballPlayer("SON", 7, "TOT", 32));
		set.add(new FootballPlayer("KAYNE", 11, "TOT", 33));
		
		set.add(new FootballPlayer("Mbappe", 6, "PSG", 35));
		set.add(new FootballPlayer("NEYMAR", 9, "PSG", 32));
		set.add(new FootballPlayer("Mbappe", 10, "PSG", 28));

		Iterator<FootballPlayer> itr = set.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
