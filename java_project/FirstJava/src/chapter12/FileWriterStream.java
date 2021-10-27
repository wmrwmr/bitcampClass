package chapter12;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileWriterStream {

	public static void main(String[] args) throws IOException {
		
		Writer writer = new FileWriter("hyper.txt");
		
		writer.write('A');
		writer.write('b');
		writer.write("Z");
		
		writer.close();
		System.out.println("문자 쓰기 완료");

	}

}
