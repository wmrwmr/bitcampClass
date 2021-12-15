package jdbc;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class DriverLoader extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		
		String driver = config.getInitParameter("driver");
		
		// DB 드라이버 로드
		try {
			Class.forName(driver);
			System.out.println("mysql 드라이버 로드 성공!!!");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패!!!");
			e.printStackTrace();
		}
	}

}