<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
//세션 유지시간을5분
session.setMaxInactiveInterval(60*5); 
session.setAttribute("name", "Session Test!"); 
session.setAttribute("id", "Session ID!"); 
%>
<script>location.href="sessionTest.jsp";</script>
