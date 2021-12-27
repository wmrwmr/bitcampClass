package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import member.service.MemberEditService;

public class MemberEditCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {

		String view = null;

		if (request.getMethod().equals("GET")) {

			String index = request.getParameter("idx");

			//System.out.println(MemberEditService.getInstance().getMember(Integer.parseInt(index)));
			request.setAttribute("member", MemberEditService.getInstance().getMember(Integer.parseInt(index)));

			view = "/WEB-INF/views/member/manager/editform.jsp";

		} else if (request.getMethod().equals("POST")) {

			request.setAttribute("result", MemberEditService.getInstance().editMember(request, response));
			
			view = "/WEB-INF/views/member/manager/edit.jsp";
		}

		return view;
	}

}
