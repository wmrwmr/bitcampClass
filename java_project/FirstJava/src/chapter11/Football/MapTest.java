package chapter11.Football;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//4.축구선수의 번호를 key로 하고 축구선수 인스턴스를 저장하는 
//Map<K,V> 인스턴스를 이용해서 프로그램을 만들어봅시다.

public class MapTest {
	public static void main(String[] args) {
		HashMap<Integer, FootballPlayer> map = new HashMap<>();

		// 데이터 저장: put(key, value)
		map.put(new Integer(1), new FootballPlayer("손흥민", 7, "토트넘", 32));

		// 데이터 참조: get(key)
		System.out.println(map.get(1));

		// 데이터의 삭제: remove(key)
		map.remove(1);
		System.out.println("key 1을 삭제-------------------");
		System.out.println(map.get(1));

		map.put(5, new FootballPlayer("박지성", 7, "맨유", 32));

		// 데이터 일괄 처리
//	Set<Integer> set = map.keySet();
//	Iterator<Integer> itr = set.iterator();

		Iterator<Integer> itr = map.keySet().iterator();

		while (itr.hasNext()) {
			System.out.println(map.get(itr.next()));
		}

		System.out.println("------------------------------------");

		for (Map.Entry<Integer, FootballPlayer> e : map.entrySet()) {
			System.out.println("(" + e.getKey() + ", " + e.getValue() + ")");
		}

	}
}
