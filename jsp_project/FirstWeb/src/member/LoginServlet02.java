package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({"/LoginServlet02", "/loginServlet02"})
public class LoginServlet02 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uid = request.getParameter("userid");
		String pw = request.getParameter("pw");
		String rePw = request.getParameter("rePw");
		String userName = request.getParameter("userName");
		
		System.out.println("userid: " + uid);
		System.out.println("pw: " + pw);
		System.out.println("rePw: " + rePw);
		System.out.println("userName: " + userName);
		
		
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<head><title>파라미터 데이터 받기</title></head>");
		out.println("	<body>");
		out.println("		<h1>");
		out.println("			userid: " + uid + "<br>");
		out.println("			pw: " + pw + "<br>");
		out.println("			rePw: " + rePw + "<br>");
		out.println("			userName: " + userName);
		out.println("		</h1>");
		out.println("	</body>");
		out.println("</html>");
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("로그인 완료!!!");
		doGet(request, response);
	}

}
