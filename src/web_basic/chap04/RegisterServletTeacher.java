package web_basic.chap04;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/chap04/registerServletTeacher")
public class RegisterServletTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");	
		
		String id = request.getParameter("id");
		String pwd1 = request.getParameter("pwd1");
		String pwd2 = request.getParameter("pwd2");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String homepage = request.getParameter("homepage");
		
		String member = request.getParameter("member");
		String stuffs = request.getParameter("stuffs");
		int satis = Integer.parseInt(request.getParameter("satis"));
		
		String subject = request.getParameter("subject");
		String[] mailing = request.getParameterValues("mailing");
				
		PrintWriter out = response.getWriter();
		out.printf("<html>????????????<br>");
		out.printf("id %s<br>password %s<br>", id, (pwd1.equals(pwd2)?"??????":"?????????"));
		out.printf("name %s<br>", name);
		out.printf("email %s<br>", email);
		out.printf("phone %s<br>", phone);
		out.printf("homepage %s<br>", homepage);
		
		out.printf("member %s ???<br>", member);
		out.printf("stuffs %s ???<br>", stuffs);
		out.printf("satis %s <br>", satis==1?"???":(satis==2?"???":"???"));
		
		String t = null;
		if (subject.equals("eng")) {
			t = "??????";
		}else if (subject.equals("ch")) {
			t = "??????";
		}else {
			t = "??????";
		}
		out.printf("subject %s<br>", t);
		
		if (mailing == null) {
			out.println("????????? ??????????????? ??????");
		} else {
			for(String gubun : mailing) {
				if (gubun.equals("news")) {
					out.printf("?????????  = %s<br>", "?????? ??????");
				}
				if (gubun.equals("dialog")) {
					out.printf("?????????  = %s<br>", "5??? ??????");
				}
				if (gubun.equals("pops")) {
					out.printf("?????????  = %s<br>", "?????? ??????");
				}
			}
		}
		
		String start = request.getParameter("start-date");
		String end = request.getParameter("end-date");
		System.out.println(start + " : " + end);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		try {
			Date startDate = sdf.parse(start);
			Date endDate = sdf.parse(end);
			
			out.printf("start %tF<br>", startDate);
			out.printf("end %tF<br>", endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm");
		
		String startTime1 = request.getParameter("start-time1");
		String endTime1 = request.getParameter("end-time1");
		
		try {
			Date sTime1 = sdf2.parse(startTime1);
			Date eTime1 = sdf2.parse(endTime1);
			
			out.printf("start Time : %tT<br>", sTime1);
			out.printf("end Time : %tT<br>", eTime1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String startTime2 = request.getParameter("start-time2"); 
		String endTime2 = request.getParameter("end-time2");
		System.out.printf("%s - %s%n", startTime2, endTime2);
		
		LocalDateTime startDate = LocalDateTime.parse(startTime2, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		LocalDateTime endDate = LocalDateTime.parse(endTime2, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		out.printf("start Date-Time : %s<br>", startDate.format(formatter));
		out.printf("end Date-Time : %s<br>", endDate.format(formatter));
		out.printf("</html>");
		
		//localDateTime -> Date??????
		Date sd = Date.from(startDate.atZone(ZoneId.systemDefault()).toInstant());
		Date ed = Date.from(endDate.atZone(ZoneId.systemDefault()).toInstant());
		System.out.printf("%1$tF %1$tT - %2$tF %2$tT%n", sd, ed);
	}
}
