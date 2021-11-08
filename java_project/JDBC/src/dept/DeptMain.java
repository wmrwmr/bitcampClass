package dept;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeptMain {

	public static void main(String[] args) {

		DeptDao deptDao = new DeptDao();
		Connection conn;

		List<Dept> list = null;

		try {
			conn = ConnectionProvider.getConnection();

			// 부서 리스트를 확인
			list = deptDao.selectAllList(conn);

			System.out.println("부서리스트");
			System.out.println("-------------------");
			for (Dept dept : list) {
				System.out.println(dept);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
