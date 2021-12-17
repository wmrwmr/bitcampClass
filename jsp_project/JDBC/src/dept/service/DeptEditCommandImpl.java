package dept.service;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.dao.DeptDao;
import dept.domain.Dept;
import jdbc.ConnectionProvider;

public class DeptEditCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		String view = null;
		
		if(request.getMethod().equals("GET")) {
			
			// deptno 받기
			String deptno = request.getParameter("deptno");
			
			// DAO -> Dept 객체 -> request 저장
			Connection conn = null;
			Dept dept = null;
			
			try {
				conn = ConnectionProvider.getConnection();
				dept = DeptDao.getInstance().selectByDeptno(conn, deptno);
				System.out.println("edit : " + dept);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			request.setAttribute("dept", dept);
			view = "/WEB-INF/views/dept/editform.jsp";
			
		} else if(request.getMethod().equals("POST")) {
			
			
//			try {
//				request.setCharacterEncoding("utf-8");
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			}
			
			// 수정하고자하는 데이터를 받는다
			String dname = request.getParameter("dname");
			String loc = request.getParameter("loc");
			String deptno = request.getParameter("deptno");
			
			// Dao 수정 처리 
			Connection conn = null;
			int dcnt = 0;
			
			try {
				conn = ConnectionProvider.getConnection();
				Dept dept = new Dept(Integer.parseInt(deptno), dname, loc);
				
				dcnt = DeptDao.getInstance().editDept(conn, dept);
					
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
//			request.setAttribute("result", dcnt);
			request.setAttribute("result", dcnt>0? "수정되었습니다." : "잘못된 요청입니다. 다시 확인해주세요.");
			
			
			
			view = "/WEB-INF/views/dept/edit.jsp";
		}
		
		
		
		return view;
	}

}



