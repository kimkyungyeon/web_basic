package web_basic.chap04;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/chap04/orderResultServlet")
public class OrderResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}


	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String name = request.getParameter("name");
		String tel1 = request.getParameter("tel1");
		String addr = request.getParameter("addr");
		String tel2 = request.getParameter("tel2");
		String comment = request.getParameter("comment");
		String check = request.getParameter("check");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<title>주문결과 </title>");
		
		out.println(name+"<br>");
		out.println(tel1+"<br>");
		out.println(addr+"<br>");
		out.println(tel2+"<br>");
		out.println(comment+"<br>");
		out.println(check+"<br>");
	}

}
