package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcPreparedStatementDMLTest {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		// Dept 저장을 위한 List<Dept>
		List<Dept> list = new ArrayList <Dept>();

		try {
			// 1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. 연결 : Connection
			//String jdbcUrl = "jdbc:oracle:thin:@[주소]:[포트]:[데이터 베이스]";
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "SCOTT";
			String pw = "tiger";
			
			conn = DriverManager.getConnection(jdbcUrl, user, pw);
			
			System.out.println("데이터베이스 연결 성공!");
			
			// 3. 작업 : CRUD -> PreparedStatement객체 생성, 먼저 sql 등록 후 사용
			
			// Sql : insert
			String sql = "insert into dept values (?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 60);
			pstmt.setString(2, "DEV");
			pstmt.setString(3, "BUSAN");


			// DML 실행
			int resultCnt = pstmt.executeUpdate();
			
			if(resultCnt > 0) {
				System.out.println("입력되었습니다");
				
			} else {
				System.out.println("입력 실패!");
			}
			
			// 4. 종료 : close()
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스를 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("데이터베이스에 연결할 수 없습니다. 연결 실패!");
			e.printStackTrace();
		} finally {
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	

	}

}
