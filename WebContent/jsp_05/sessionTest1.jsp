<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
session.setMaxInactiveInterval(10);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session Test1</title>
</head>
<body>
<h2>세션 테스트</h2>
isNew():<%=session.isNew()%> <br>
생성시간:<%=session.getCreationTime() %> <br>
최종접속시간:<%=session.getLastAccessedTime() %> <br>
세션ID:<%=session.getId() %> <br>
</body>
</html>