package chapter13;

public class ThreadTest6 {
	public static void main(String[] args) {
		IHaveTwoNum inst = new IHaveTwoNum();

		AccessThread at1 = new AccessThread(inst);
		AccessThread at2 = new AccessThread(inst);

		at1.start();
		at2.start();
		
		try {
			at1.join();
			at2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		inst.showAllNumber();
		
		
		
		
	}
}
