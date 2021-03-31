<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage = "true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NULL 에러 발생</title>
</head>
<body>
	<strong>NULL 에러 발생</strong> 
	발생한 예외 종류 :
	<%=exception.getClass().getName()%><br> 에러 메시지 :
	<%=exception.getMessage()%>
</body>
</html>