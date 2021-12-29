package guestbook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import guestbook.service.GuestBookWriteService;

public class GuestBookWriteAjaxCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		if(request.getMethod().equals("POST")) {
			request.setAttribute("result", GuestBookWriteService.getInstance().writeArticle(request, response));
		}
		
		return "/WEB-INF/views/guestbook/result.jsp";
	}

}
