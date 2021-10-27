package chapter13;

import javax.swing.JOptionPane;

public class ThreadTest3 {
	
	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("아무 데이터나 입력하세요");
		System.out.println("입력하신 데이터는 " + input + "입니다.");
		
		for(int i = 10 ; i>0; i--) {
			System.out.println(i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

