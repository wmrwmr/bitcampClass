package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import member.service.MemberListService;

public class MemberListCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		// http://localhost:8080/op/member/manager/list.do?p=2
		String pageNumber = request.getParameter("p");
		int pageNum = 1;
		
		if(pageNumber != null && pageNumber.length()>0) {
			try {
				pageNum = Integer.parseInt(pageNumber);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		
		request.setAttribute("listView", MemberListService.getInstance().getPage(pageNum));
		
		//System.out.println(MemberListService.getInstance().getPage(2));
		
		
		return "/WEB-INF/views/member/manager/list.jsp";
	}

}
