package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	
	static public Connection getConnection() throws SQLException {
		
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String pw = "tiger";

		return DriverManager.getConnection(jdbcUrl, user, pw);
	}

}
