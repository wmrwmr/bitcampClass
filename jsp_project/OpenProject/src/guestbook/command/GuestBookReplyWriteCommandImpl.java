package guestbook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import guestbook.service.GuestBookReplyWriteService;

public class GuestBookReplyWriteCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		if(request.getMethod().equals("POST")) {
			
			request.setAttribute("result", 
					GuestBookReplyWriteService.getInstance().writeRepy(request, response));			
		}
		
		return "/WEB-INF/views/guestbook/reply/write.jsp";
	}

}
