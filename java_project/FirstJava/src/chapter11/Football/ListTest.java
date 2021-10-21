package chapter11.Football;

import java.util.ArrayList;
import java.util.Iterator;

//1.축구선수 인스턴스를 저장할 수 있는 List<E> 컬렉션 인스턴스를 생성해서 
//인스턴스를 저장하고 출력하는 프로그램을 만들어 봅시다.
// String name, int number, String team, int age

public class ListTest {
	public static void main(String[] args) {
		ArrayList<FootballPlayer> list = new ArrayList<>();

		list.add(new FootballPlayer("손흥민", 7, "토트넘", 32));
		list.add(new FootballPlayer("조현우", 8, "울산 현대", 33));

		Iterator<FootballPlayer> itr = list.iterator();

		while (itr.hasNext()) {
			FootballPlayer i = itr.next();
			System.out.println(i);
		}

	}
}
