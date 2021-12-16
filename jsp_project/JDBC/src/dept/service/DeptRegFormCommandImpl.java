package dept.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeptRegFormCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		// 부서 정보를 입력하는 폼 화면
		
		System.out.println(request.getMethod());
		
		return "/WEB-INF/views/dept/regform.jsp";
	}

}
