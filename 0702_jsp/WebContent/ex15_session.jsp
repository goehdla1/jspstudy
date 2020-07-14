<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 기본객체 : session</title>
</head>
<body>

	<h2> ex15 페이지 </h2>
	<h3>
		이름 :
		<%=pageContext.getAttribute("name")%></h3>
	<h3>
		나이 :
		<%=pageContext.getAttribute("age")%></h3>
	<hr>
	<h3>
		이름 :
		<%=request.getAttribute("name")%></h3>
	<h3>
		나이 :
		<%=request.getAttribute("age")%></h3>
	<hr>
	<h3>
		이름 :
		<%=session.getAttribute("name")%></h3>
	<h3>
		나이 :
		<%=session.getAttribute("age")%></h3>
		
</body>
</html>