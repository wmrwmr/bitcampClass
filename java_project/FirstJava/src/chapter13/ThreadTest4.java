package chapter13;

import javax.swing.JOptionPane;

public class ThreadTest4 {
	
	static boolean inputCheck = false;
	
	public static void main(String[] args) {
		
		CountDownThread t = new CountDownThread();
		t.start();
		
		String input = JOptionPane.showInputDialog("아무 데이터나 입력하세요");
		
		System.out.println("입력하신 데이터는 " + input + "입니다.");
		
		inputCheck = true;
		
	}
}

