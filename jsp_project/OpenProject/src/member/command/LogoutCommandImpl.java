package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;

public class LogoutCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		request.getSession().invalidate();
		
		return "/WEB-INF/views/member/logout.jsp";
	}

}
