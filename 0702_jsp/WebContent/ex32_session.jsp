<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 세션 연습 3</h1>
	<% session.setAttribute("ict", "jsp"); %>
	

		<%-- 세션 데이터 삭제 --%>
		<%-- 1. 속성만 삭제 --%>
		<%-- <% session.removeAttribute("ict") ; %> --%>
		<%-- <p> 세션 데이터 삭제 후 호출 : <%= session.getAttribute("ict") %></p> --%>
		
		<%-- 세션 시간 제한 --%>
		<%-- <% session.setMaxInactiveInterval(10); %> 
		<p> 세션ID : <%=session.getId()%></p>
		<p> 세션 데이터 호출 : <%= session.getAttribute("ict") %></p> --%>
		
		<%-- 3. 세션 전체 초기화 --%>
		<% session.invalidate(); %>
		<p> 세션ID : <%=session.getId()%></p>
		<%-- 호출 자체가 되지 않는다.(오류) --%>
		<%-- <p> 세션 데이터 호출 : <%= session.getAttribute("ict") %></p> --%>

</body>
</html>