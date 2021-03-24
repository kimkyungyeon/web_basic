package web_basic.chap04;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/chap04/registerServletTotal")
public class registerServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			process(request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			process(request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String passwd2 = request.getParameter("passwd2");
		
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String tel = request.getParameter("tel");
		String blog = request.getParameter("blog");
		
		int regNum = Integer.parseInt(request.getParameter("regNum"));
		int stuffNum = Integer.parseInt(request.getParameter("stuffNum"));
		
		String hopeGrade = request.getParameter("hopeGrade");
		if(hopeGrade.equals("1")) {
			hopeGrade = "하";
		} else if(hopeGrade.equals("2")) {
			hopeGrade = "중";
		} else {
			hopeGrade = "상";
		}
		
		String subject = request.getParameter("subject");
		String[] mailings = request.getParameterValues("mailing");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		Date sDate = fm.parse(startDate);
		Date eDate = fm.parse(endDate);
		
		PrintWriter out = response.getWriter();
		out.println("<html> 가입정보<br>");
		out.printf("id %s<br> password %s<br>", id, (passwd.equals(passwd2)));
		out.printf("name %s <br>", name);
		out.printf("mail %s <br>", mail);
		out.printf("tel %s <br>", tel);
		out.printf("blog %s <br>", blog);
		out.printf("참여인원수 %d<br>", regNum);
		out.printf("지원물품수 %d<br>", stuffNum);
		out.printf("희망단계 %s<br>", hopeGrade);
		String t = null;
		if(subject.equals("speaking")) {
			t ="회화";
		} else if (subject.equals("grammar")) {
			t ="문법";
		} else {
			t="작문";
		}
		out.printf("신청과목 %s <br>", t);
		out.printf("메일링 <br>");
		out.printf("주제명 : ");
		for(String s : mailings) {
			if(s.contentEquals("news")) {
				out.printf(" %s", s);
			}
			if(s.contentEquals("dialog")) {
				out.printf(" %s", s);
			}
			if(s.contentEquals("pops")) {
				out.printf(" %s", s);
			}
		}
		out.printf("<br>");
		out.println("시작날짜 :" + fm.format(sDate));
		out.println("종료날짜 :" + eDate);
		
		
		
		
	}
	
	
}
