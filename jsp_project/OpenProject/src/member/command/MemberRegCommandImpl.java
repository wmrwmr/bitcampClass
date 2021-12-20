package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberRegCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		String view = null;
		
		// 회원 가입을 위한 form ( GET ) -> 가입 처리 ( POST )
		if(request.getMethod().equals("GET")) {
			
			view = "/WEB-INF/views/member/regform.jsp";
			
		} else if(request.getMethod().equals("POST")) {
			
		
			// request 속성 처리
			
			view = "/WEB-INF/views/member/reg.jsp";
			
		}
		
		// request 속성 처리
		
		return view;
	}

}
