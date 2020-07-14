<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션 태그</title>
</head>
<body>
	<%-- forward : 페이지 이동 // response , request가 살아 있다. forward는 자기가 해당페이지로 날아간다.--%>
	<%-- <jsp:forward page="ex07_response.jsp" /> --%>
	<% request.setCharacterEncoding("utf-8");%>
	<jsp:forward page="ex08.jsp">
	<jsp:param value="방방이" name="id" />
	<jsp:param value="1324" name="pw" />
	
	</jsp:forward>
</body>
</html>