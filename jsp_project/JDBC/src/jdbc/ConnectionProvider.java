package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	
	// connection 객체를 제공하는 메소드: public static 
	public static Connection getConnection() throws SQLException {
		
		Connection conn = null;
		
		String url = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
				
		return DriverManager.getConnection(url, "bit", "bit");
		
	}
	
}
