package dept.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dept.domain.Dept;
import jdbc.util.JdbcUtil;

public class DeptDao {

	// 가능만 있는 클래스 - 여러 개의 인스턴스 생성이 필요없다! -> 인스턴스 생성을 제한
	// 싱글톤 패턴:
	// 1. 생성자를 private 해주어서 인스턴스 생성을 막아준다
	// 2. 클래스 내부에서 인스턴스를 생성, 참조변수는 private, static
	// 3. 참조값을 제공하는 메소드가 필요하다 -> public static

	private DeptDao() {
	}

	private static DeptDao dao = new DeptDao();

	public static DeptDao getInstance() {
		return dao;
	}

	// 부서 리스트 출력을 위한 데이터들을 반환하는 메소드
	public List<Dept> selectAll(Connection conn) {

		// 응답 결과 객체
		List<Dept> list = null;
		Statement stmt = null;
		ResultSet rs = null;
		// 자바에서는 프로젝트명 안써도 됨
		// String sql = "select * from project.dept;";
		String sql = "select * from dept;";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			list = new ArrayList<Dept>();

			// 결과를 객체에 담는다
			while (rs.next()) {

//				// 컬럼 인덱스로 받거나, 컬럼 이름으로 받거나 선택
//				int deptno = rs.getInt("deptno"); 
//				String dname = rs.getString("dname");
//				String loc = rs.getString("loc");
//				
//				Dept dept = new Dept(deptno, dname, loc);
//				
//				list.add(dept);

				list.add(new Dept(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}

		return list;
	}

	public int insertDept(Connection conn, Dept dept) {

		int resultCnt = 0;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO dept (deptno, dname, loc) VALUES (?, ?, ?);";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dept.getDeptno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());

			resultCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}

		return resultCnt;
	}

	public Dept selectByDeptno(Connection conn, String deptno) {

		Dept dept = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from project.dept where deptno=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(deptno));

			rs = pstmt.executeQuery();

			if (rs.next()) {
				dept = new Dept(rs.getInt(1), rs.getString(2), rs.getString(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

		return dept;
	}

	public int editDept(Connection conn, Dept dept) {
		
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE dept SET dname=?, loc=? WHERE deptno=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dept.getDname());
			pstmt.setString(2, dept.getLoc());
			pstmt.setInt(3, dept.getDeptno());
			
			resultCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return resultCnt;
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
