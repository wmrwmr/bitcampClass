package chapter13;

public class ThreadTest2 {
	public static void main(String[] args) {

		// Runnable 타입의 객체를 생성하고 -> 해당 객체를 이용해서 Thread 객체를 생성
		AdderThread adderThread1 = new AdderThread(1, 50);
		AdderThread adderThread2 = new AdderThread(51, 100);

		// Thread 인스턴스 생성
		Thread t1 = new Thread(adderThread1);
		Thread t2 = new Thread(adderThread2);
		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("1~100까지의 합: " + (adderThread1.getNum() + adderThread2.getNum()));

	}
}
