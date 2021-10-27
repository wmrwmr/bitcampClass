package chapter13;

public class ThreadTest5 {
	public static void main(String[] args) {

		Increment increment = new Increment();

		IncThread thread1 = new IncThread(increment);
		IncThread thread2 = new IncThread(increment);
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(increment.getNum());
	}
}
