package guestbook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import guestbook.service.GuestBookListService;

public class GuestBookListCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		String p = request.getParameter("p");
		int pageNum = 1;
		if(p != null) {
			try {
				pageNum = Integer.parseInt(p);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		
		//System.out.println(GuestBookListService.getInstance().getPage(1));
		request.setAttribute("listView", GuestBookListService.getInstance().getPage(pageNum));
		
		return "/WEB-INF/views/guestbook/list.jsp";
	}

}
