<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> request를 이용한 헤드 정보 보기 </title>
</head>
<body>
<h2> HTTP 헤더 정보 보기 </h2>
<h3>
<%
	Enumeration e_num = request.getHeaderNames();
	while(e_num.hasMoreElements()){
		String h_name = (String) e_num.nextElement();
		String h_value = request.getHeader(h_name);
		out.println(h_name+" : " + h_value + "<br>");
	}
%>
</h3>

</body>
</html>