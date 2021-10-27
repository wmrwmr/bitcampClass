package chapter12;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StringWriter {

	public static void main(String[] args) throws IOException {
		
		BufferedWriter out = new BufferedWriter(new FileWriter("String.txt",true));
		
		out.newLine();
		out.write("안녕하세요!!!!");
		out.newLine();
		out.write("반갑습니다");
		out.newLine();
		out.write("date=2021-10-26");
		out.newLine();
		
		out.close();		
		
	}

}
