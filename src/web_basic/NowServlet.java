package web_basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NowServlet
 */
@WebServlet("/NowServlet")
public class NowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; chartset= utf-8");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Date now = new Date();
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>" + 
				"<title>서블릿 생성 현재 시간</title>" + 
				"</head>"+
				"<body>");
		
		writer.println(now);
		
		writer.println("</body> </html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
