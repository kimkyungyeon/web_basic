<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>    
<jsp:useBean id="std" class="web_basic.jsp_07.Student" scope = "page"/>
<jsp:setProperty name ="std" property="*"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JavaBean Test</title>
</head>
<body>
<h1>자바빈 속성 값 출력</h1>
<b>학번 : </b> <%=std.getStdNo() %><br>
<b>이름 : </b> <%=std.getStdName() %><br>
<b>국어 : </b> <%=std.getKor() %><br>
<b>영어 : </b> <%=std.getEng() %><br>
<b>수학 : </b> <%=std.getMath() %><br>
<b>총점 : </b> <%=std.getTotal() %><br>
<b>평균 : </b> <%=std.getAvg() %><br>

<hr>

<b>학번 : </b> <jsp:getProperty property="stdNo" name="std"/>
<b>이름 : </b> <jsp:getProperty property="stdName" name="std"/>
<b>국어 : </b> <jsp:getProperty property="kor" name="std"/>
<b>영어 : </b> <jsp:getProperty property="eng" name="std"/>
<b>수학 : </b> <jsp:getProperty property="math" name="std"/>
<b>총점 : </b> <jsp:getProperty property="total" name="std"/>
<b>평균 : </b> <jsp:getProperty property="avg" name="std"/>

</body>
</html>