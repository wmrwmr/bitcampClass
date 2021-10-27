package chapter13;

public class ThreadTest1 {
	public static void main(String[] args) {
		
		// 스레드 인스턴스 생성
		ShowThread t1 = new ShowThread("멋진 스레드");
		ShowThread t2 = new ShowThread("		예쁜 스레드");
		
		// 스레드 실행: run() 직접 호출한 경우 스레드 환경(새로운 작업)이 생성되지 않는다!!!
		t1.start();
		t2.start();
		
		for(int i = 0; i<100; i++) {
			System.out.println("-------------------메인 스레드");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
