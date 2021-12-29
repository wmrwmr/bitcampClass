package guestbook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import guestbook.service.GuestBookViewService;
import guestbook.service.ReplyListService;

public class GuestBookViewCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		//System.out.println(GuestBookViewService.getInstance().getPageView(request, response));
		request.setAttribute("pageView", GuestBookViewService.getInstance().getPageView(request, response));
		
		request.setAttribute("replyList", ReplyListService.getInstance().getList(request));
		
		return "/WEB-INF/views/guestbook/view.jsp";
	}

}
