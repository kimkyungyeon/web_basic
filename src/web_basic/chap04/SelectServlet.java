package web_basic.chap04;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/chap04/select")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String stdNo = request.getParameter("stdNo");
		String stdName = request.getParameter("stdName");
		String major = request.getParameter("major");
		String level = request.getParameter("level");
		String interest = request.getParameter("interest");
		String intro = request.getParameter("intro");
		String subs = intro.replace("\r\n", "<br>");
		
		out.println("<html>");
		out.println("<Title> 신청정보</title>");
		out.println("<body>");
		out.println("<h1> 신청정보 </h1>");
//		out.println("<html> <title>신청정보</title><body><h1>신청정보</h1>");
		out.printf("학번 : %s<br>",stdNo);
		out.printf("<b>이름</b> %s <br>", stdName);
		out.printf("학과 : %s<br>",major);
		out.printf("단계 : %s<br>", level);
		out.printf("관심분야 : %s<br>", interest);
		out.printf("하고싶은말 : %s<br><br>", intro);
		out.printf("하고싶은말 : %s<br>", subs);
	}

}
