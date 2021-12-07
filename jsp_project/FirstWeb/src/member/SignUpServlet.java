package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({"/SignUpServlet", "/signUpServlet"})
public class SignUpServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				// post 방식으로 데이터를 받을 때 한글 인코딩 처리!!! 필수!!!
				request.setCharacterEncoding("utf-8");
				
				// 데이터 받기
				String uid = request.getParameter("userid");
				String pw = request.getParameter("pw");
				String uname = request.getParameter("username");
				String comment = request.getParameter("comment");
				String gender = request.getParameter("gender");
				
				String[] interests = request.getParameterValues("interest");
				
				String byear = request.getParameter("byear");
				
				// 응답 하는 데이터의 타입 
				//response.setContentType("application/doc; charset=utf-8");
				response.setContentType("text/html; charset=utf-8");
				
				
				PrintWriter out = response.getWriter();
				out.println("<html>");
				out.println("	<head>");
				out.println("		<meta charset=\"utf-8\">");
				out.println("		<title>데이터 확인</title>");
				out.println("	</head>");
				out.println("	<body>");
				out.println("		<h1>");
				out.println("			uid : " + uid +  "<br>");
				out.println("			pw : " + pw +  "<br>");
				out.println("			username : " + uname +  "<br>");
				out.println("			comment : " + comment +  "<br>");
				out.println("			gender : " + gender +  "<br>");
				
				if(interests != null) {
					for(int i=0; i<interests.length; i++) {
						out.println("			interest : " + interests[i] +  "<br>");
					}
				} else {
					out.println("			interest : 선택된 관심사가 없습니다.<br>");
				}
				
				out.println("			byear : " + byear +  "<br>");
				
				
				out.println("		</h1>");
				out.println("	</body>");
				out.println("</html>");
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("로그인 완료!!!");
		doGet(request, response);
	}

}
