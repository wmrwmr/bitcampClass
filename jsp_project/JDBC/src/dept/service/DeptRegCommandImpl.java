package dept.service;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.dao.DeptDao;
import dept.domain.Dept;
import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;

public class DeptRegCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {

		String view = null;

		if (request.getMethod().equals("GET")) {

			// 전송 방식 확인
			System.out.println(request.getMethod());

			view = "/WEB-INF/views/dept/regform.jsp";

		} else if (request.getMethod().equals("POST")) {

			// 전송 방식 확인
			System.out.println(request.getMethod());

			// post 방식에서 한글 처리
			try {
				request.setCharacterEncoding("utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			String deptno = request.getParameter("deptno");
			String dname = request.getParameter("dname");
			String loc = request.getParameter("loc");

			// Dept 객체를 생성
			Dept dept = new Dept(Integer.parseInt(deptno), dname, loc);

			// Dao insert 메소드로 입력처리
			Connection conn = null;
			int regCnt = 0;

			try {
				conn = ConnectionProvider.getConnection();

				// 결과 반환
				regCnt = DeptDao.getInstance().insertDept(conn, dept);

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(conn);
			}

			// request 속성에 저장
			request.setAttribute("result", regCnt);
			request.setAttribute("dept", dept);

			view = "/WEB-INF/views/dept/reg.jsp";
		}

		return view;

	}

}
