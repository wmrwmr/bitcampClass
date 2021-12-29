package guestbook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import guestbook.service.GuestBookEditService;
import member.domain.LoginInfo;

public class GuestBookEditCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		String view = null;
		
		if(request.getMethod().equals("GET")) {
			
			String idx = request.getParameter("idx");
			int memberIdx = ((LoginInfo) request.getSession().getAttribute("loginInfo")).getIdx();
			
			request.setAttribute("message", 
					GuestBookEditService.getInstance().getMessage(
							Integer.parseInt(idx), memberIdx));
			
			view = "/WEB-INF/views/guestbook/editForm.jsp";
			
		} else if(request.getMethod().equals("POST")) {
			
			
			
			view = "/WEB-INF/views/guestbook/edit.jsp";
			
		}
		
		return view;
	}

}
