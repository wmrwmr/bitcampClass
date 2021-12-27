package guestbook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import guestbook.service.GuestBookViewService;

public class GuestBookDeleteCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		// System.out.println(GuestBookViewService.getInstance().getPageView(request,
		// response));
		request.setAttribute("pageView", GuestBookViewService.getInstance().getPageView(request, response));

		return "/WEB-INF/views/guestbook/delete.jsp";
	}

}
