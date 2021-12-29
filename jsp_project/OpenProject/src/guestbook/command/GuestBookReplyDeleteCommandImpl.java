package guestbook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import guestbook.service.ReplyDeleteService;

public class GuestBookReplyDeleteCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		if(request.getMethod().equals("POST")) {
			
			request.setAttribute("result", 
					ReplyDeleteService.getInstance().deleteReply(request));
			
		}
		
		// /WEB-INF/views/guestbook/reply/delete.jsp
		// 새롭게 만들 delete.jsp 파일의 역할이 write.jsp와 동일
		return "/WEB-INF/views/guestbook/reply/write.jsp";
	}

}
