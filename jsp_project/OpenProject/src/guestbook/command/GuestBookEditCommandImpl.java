package guestbook.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import command.Command;
import guestbook.service.GuestBookGetMessage;
import guestbook.service.GuestBookWriteService;

public class GuestBookEditCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {

		String view = null;

		if (request.getMethod().equals("GET")) {
			
			try {
				request.setAttribute("message", GuestBookGetMessage.getInstance().getMessage(request));
				request.setAttribute("message1", new Gson().toJsonTree(GuestBookGetMessage.getInstance().getMessage(request)));
			} catch (SQLException e) {
				e.printStackTrace();
			}

			view = "/WEB-INF/views/guestbook/editform.jsp";

		} else if (request.getMethod().equals("POST")) {

			request.setAttribute("result", GuestBookWriteService.getInstance().writeArticle(request, response));

			view = "/WEB-INF/views/guestbook/edit.jsp";
		}

		return view;
	}

}
