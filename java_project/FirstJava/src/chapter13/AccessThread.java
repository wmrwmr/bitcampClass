package chapter13;

public class AccessThread extends Thread {

	IHaveTwoNum twoNum;

	public AccessThread(IHaveTwoNum twoNum) {
		this.twoNum = twoNum;
	}

	@Override
	public void run() {

		twoNum.addOneNum1(); // num1
		twoNum.addTwoNum1(); // num1

		twoNum.addOneNum2(); // num2
		twoNum.addOneNum2(); // num2
		
	}

}
