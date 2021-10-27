package chapter12;

import java.io.File;

public class FileMove {

	public static void main(String[] args) {
		
		// 원본 파일의 경로를 객체로 생성
		File myFile = new File("d:\\myJava\\java.pdf");
		//System.out.println(myFile.exists());
		
		if(!myFile.exists()) {
			
			File file = new File("D:\\yourJava\\java-IO.pdf");
			//File file = new File("D:\\yourJava", "java-IO.pdf");
					
			if(file.exists()) {
				file.delete();
				System.out.println("파일을 삭제 했습니다.");
			}
			
			System.out.println("원본 파일이 존재하지 않습니다.");
			return;
		}
		
		// 새로운 폴더를 생성 : 폴더 존재 여부 확인 후 폴더 생성
		File newDir = new File("d:\\yourJava");
		if(!newDir.exists()) {
			newDir.mkdir();
			System.out.println("d:\\yourJava 폴더 생성");
		}
		
		// 이동을 원하는 경로 생성
		File newFile = new File(newDir, "java-IO.pfd");
		
		// 파일 이동
		myFile.renameTo(newFile);
		
		// 이동한 파일이 존재 하는지 확인
		if(newFile.exists()) {
			System.out.println("파일 이동 성공!");
		} else {
			System.out.println("파일 이동 실패!");
		}
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
