package chapter11;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeMap;

public class TreeMapTest {
	public static void main(String[] args) {
		TreeMap<Integer, String> map = new TreeMap<Integer, String>();

		// 저장
		map.put(1, "AAA");
		map.put(5, "EEE");
		map.put(3, "CCC");
		map.put(2, "BBB");
		map.put(4, "DDD");

		NavigableSet<Integer> navi = map.navigableKeySet();

		System.out.println("key 값의 오름차순 출력");
		Iterator<Integer> itr = navi.iterator();
		while (itr.hasNext()) {
			System.out.println(map.get(itr.next()));
		}

		itr = navi.descendingIterator(); /// 역순으로 만들어줌
		
		System.out.println("key 값의 내림차순 출력");
		while (itr.hasNext()) {
			System.out.println(map.get(itr.next()));
		}

	}
}
