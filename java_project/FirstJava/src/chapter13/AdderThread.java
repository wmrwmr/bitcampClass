package chapter13;

public class AdderThread extends Sum implements Runnable {

	int start;
	int end;

	public AdderThread(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		for (int i = this.start; i <= this.end; i++) {
			addNum(i);
		}
	}

}
