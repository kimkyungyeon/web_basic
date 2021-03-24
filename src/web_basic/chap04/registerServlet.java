package web_basic.chap04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/chap04/registerServlet")
public class registerServlet extends HttpServlet {
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
		
		String subject = request.getParameter("subject");
		String[] gubuns = request.getParameterValues("gubun");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.printf("id = %s, password = %s", id, passwd);
		out.println("<h2>수강분야</h2>");
		String t = null;
		if(subject.equals("eng")) {
			t="영어";
		} else if(subject.equals("ch")) {
			t="중국어";
		} else {
			t="일본어";
		}
		out.println("subject = "+ t + "<br>");
		out.println("수강분야  <br>");
		for(String gubun : gubuns) {
			if(gubun.equals("grm")) {
			out.printf("분야 = 문법");
			}
			if(gubun.equals("wr")) {
				out.printf("분야 = 작문");
			}
			if(gubun.equals("rd")) {
				out.printf("분야 = 독해");
			}
		}
		out.println("</html>");
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("withlabel_result.jsp");
//		dispatcher.forward(request, response);
		
	}

}
