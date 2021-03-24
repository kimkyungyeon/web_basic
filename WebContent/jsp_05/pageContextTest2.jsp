<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pageContext Test</title>
</head>
<body>
<%
pageContext.include("pageContextTest3.jsp");
%>
<h2>pageContext의 forward 메소드로 포워딩된 페이지입니다.</h2>

pageContext.getOut() 메서드를 사용한 데이터 출력<br>
<%
	pageContext.getOut().println("안녕하세요");
%>

<hr>
<%
	HttpServletRequest httpRequest = (HttpServletRequest)pageContext.getRequest();
%>
	request와 pagecontext.getRequest() 동일 여부 :
<%= request == httpRequest %>
</body>
</html>