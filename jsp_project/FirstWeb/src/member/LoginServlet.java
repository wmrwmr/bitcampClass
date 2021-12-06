package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 어노테이션: 자바 문법 아니고, 주석 아니다. 추가적인 처리를 해주는 약속
// http://localhost:8080/FirstWeb/Login
// http://localhost:8080/FirstWeb/login -> web.xml에 등록하지 않아도 처리가 가능하게 됨
@WebServlet({ "/Login", "/login" })

public class LoginServlet extends HttpServlet {

	// jsp는 아닌데 setvlet은 컴파일 필수!!!
	
	

	// 사용자가 Get 방식으로 요청할 때 처리하는 메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Post 방식으로 한글을 받을 때 필수!!!
		request.setCharacterEncoding("utf-8");

		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// request: 사용자의 요청 정보를 모두 가지고 있는 객체

		// request: 사용자의 요청 데이터 처리
		// response: 사용자에게 응답할 데이터 처리

		// 사용자가 입력한 userid, pw를 받아서 응답 메시지에 포함해서 처리
		String uid = request.getParameter("userid");
		String pw = request.getParameter("pw");
		System.out.println("userid: " + uid);
		System.out.println("pw: " + pw);
		

		response.setContentType("text/xml; charset=utf-8");
		
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<head><title>파라미터 데이터 받기</title></head>");
		out.println("	<body>");
		out.println("		<h1>");
		out.println("			userid: " + uid + "<br>");
		out.println("			pw: " + pw);
		out.println("		</h1>");
		out.println("	</body>");
		out.println("</html>");
		
	}

	// 사용자가 Post 방식으로 요청할 때 처리되는 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Post 방식으로 요청 처리!!!");
		doGet(request, response);
	}

}
