package chapter12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteArrayFileCopy {

	public static void main(String[] args) {

		try {
			// 프로그램에서 파일 복사
			// 프로그램이 파일 원본을 읽고 -> 새로운 파일을 생성(쓰기)
			// 원본 파일의 데이터를 읽기 위한 스트림 클래스 생성 : InputStream, FileInputStream
			InputStream in = new FileInputStream("eclipse.zip");
			OutputStream out = new FileOutputStream("copy2.zip");

			int copyByte = 0; // 복사한 바이트 사이즈 계산

			//int bData = -1; // 스트림으로부터 읽어온 byte 단위의 데이터
			byte[] buf = new byte[1024];
			
			int readLen = -1; // 배열을 통해서 읽어오는 바이트 데이터의 개수

			while (true) {
				// 파일 읽기
				readLen = in.read(buf);
				
				if(readLen == -1) {
					break;
				} 

				// 파일 쓰기
				out.write(buf, 0, readLen);
				
				copyByte += readLen;
			}
			
			in.close();
			out.close();
			
			System.out.println("복사된 byte size : " + copyByte);
			
			
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
