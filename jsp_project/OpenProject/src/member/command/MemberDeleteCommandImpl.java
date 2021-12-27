package member.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import member.exception.MemberNotFoundException;
import member.service.MemberDeleteService;

public class MemberDeleteCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		String msg = "삭제되었습니다.";
		
		try {
			MemberDeleteService.getInstance().deleteMember(request, response);
		} catch (SQLException e) {
			msg = "처리되는 과정에 문제가발생했습니다. 다시 시도해주세요";
			e.printStackTrace();
		} catch (MemberNotFoundException e) {
			msg = "잘못된 요청입니다. 다시확인해주세요.";
			e.printStackTrace();
		}
		
		// view 에 전달할 데이터는 : 사용자에게 보여줄 메지시
		request.setAttribute("msg", msg);
		
		return "/WEB-INF/views/member/manager/delete.jsp";
	}

}
