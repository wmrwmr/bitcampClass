package chapter11;

//import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
//import java.util.List;

public class LinkedListTest {
	public static void main(String[] args) {
//		ArrayList<Integer> list = null;
		LinkedList<Integer> list = new LinkedList<Integer>();
		
//		list = new ArrayList<Integer>(); 생략가능
//		list = new ArrayList<>();
		
//		List<Integer> list2 = new ArrayList<Integer>();

		// 데이터(인스턴스) 저장: add(E e)
		list.add(new Integer(1));
		list.add(10); // = new Interger(10) Auto Boxing
		list.add(13);
		list.add(5);
		list.add(1);

		// 리스트 요소의 개수
		int size = list.size();
		System.out.println("요소의 개수: " + size);

		// for 이용 일괄 참조
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("-------------------------");
		
		// for each
		for (Integer i : list) {
			System.out.println(i);
		}
		
		System.out.println("-------------------------");
		
		// 정렬자를 이용한 전체 출력
		Iterator<Integer> itr = list.iterator();
		
		while(itr.hasNext()) {
			Integer i = itr.next();
			System.out.println(i);
		}
		
		// 요소 삭제
		list.remove(2);
		System.out.println("-------------------------");
		System.out.println("2번지 요소 삭제");
		System.out.println("-------------------------");
		
		for (Integer i : list) {
			System.out.println(i);
		}
		
		
		

	}
}
