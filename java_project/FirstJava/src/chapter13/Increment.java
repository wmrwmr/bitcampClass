package chapter13;

public class Increment {

	int num;

	public synchronized void increment() {
		num++;

	}

	public int getNum() {
		return num;
	}
	
}
