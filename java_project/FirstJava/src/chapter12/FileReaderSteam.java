package chapter12;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

public class FileReaderSteam {

	public static void main(String[] args) throws IOException  {
		
		Reader in = new FileReader("hyper.txt");
		
		int readCnt = 0;
		char[] cbuf = new char[10];
		
		readCnt = in.read(cbuf, 0, cbuf.length);
		
		for(int i=0; i<readCnt; i++) {
			System.out.println(cbuf[i]);
		}
		
		in.close();
		
		
	}

	
	
	
	
	
	
}
