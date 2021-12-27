package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import member.service.CheckIdService;

public class CheckIdCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		// Y | N
		request.setAttribute("result", 
				CheckIdService.getInstance().getMemberCount(request) == 1 ? "N" : "Y");
		
		return "/WEB-INF/views/member/checkid.jsp"; // Y 또는 N 문자 하나를 응답
	}

}
