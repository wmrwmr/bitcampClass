package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	public static Connection getConnection() throws SQLException {
		// 2. 연결 : Connection
		// String jdbcUrl = "jdbc:oracle:thin:@[주소]:[포트]:[데이터 베이스]";
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "SCOTT";
		String pw = "tiger";
		
		return DriverManager.getConnection(jdbcUrl, user, pw);
	}


}
