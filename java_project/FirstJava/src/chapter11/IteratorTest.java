package chapter11;

import java.util.Iterator;
import java.util.LinkedList;

public class IteratorTest {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.add("First");
		list.add("Second");
		list.add("Third");
		list.add("Forth");

		Iterator<String> itr = list.iterator();
		while (itr.hasNext()) {
			String str = itr.next();
			System.out.println(str);
			if (str.compareTo("Third") == 0) {
				itr.remove();
			}
		}

		System.out.println("Thied 제거 후 리스트");

		itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());

		}

	}
}
