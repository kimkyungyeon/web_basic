package web_basic.chap04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registerServlet2
 */
@WebServlet("/chap04/registerServlet2")
public class registerServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}


	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String passwd2 = request.getParameter("passwd2");
		
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String tel = request.getParameter("tel");
		String blog = request.getParameter("blog");
		
		PrintWriter out = response.getWriter();
		out.println("<html> 가입정보 <br>");
		out.printf("id %s<br> password %s<br>", id, (passwd.equals(passwd2)));
		out.printf("name %s <br>", name);
		out.printf("mail %s <br>", mail);
		out.printf("tel %s <br>", tel);
		out.printf("blog %s <br>", blog);
	}
}
