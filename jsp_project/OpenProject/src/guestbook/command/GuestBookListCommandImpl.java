package guestbook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import guestbook.service.GuestBookListService;

public class GuestBookListCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		//System.out.println(GuestBookListService.getInstance().getPage(1));
		request.setAttribute("listView", GuestBookListService.getInstance().getPage(1));
		
		return "/WEB-INF/views/guestbook/list.jsp";
	}

}
