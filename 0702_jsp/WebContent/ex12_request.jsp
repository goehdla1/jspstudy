-<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 기본객체 : request</title>
</head>
<body>
	<!-- 
		request : 클라이언트가 요청한 정보를 담고 있는 객체
		
		** 속성을 활용한 데이터 저장과 호출
			우선순위 : pageContext < request ;
		
			저장방법 : request.setAttribute("이름",데이터);
			호출방법 : request.getAttribute("이름");
			생명주기 : response를 하기 전까지는 데이터를 가지고 있다.
		**page 보다 범위가 넓다. / page가 할 수 있는 것은 당연히 할 수 있다.

 -->

<%
	pageContext.setAttribute("name", "홍길동");
	pageContext.setAttribute("age", 25);

	request.setAttribute("name", "태권브이");
	request.setAttribute("age", 68);
%>

	<h3>이름 : <%= request.getAttribute("name") %></h3>
	<h3>나이 : <%= request.getAttribute("age") %></h3>
	
	<%-- ex13으로 페이지 이동. --%>
	<%-- 1. forward 방식 : request,response가 기존 것을 사용 --%>
	<%-- request.getRequestDispatcher("ex13_request.jsp").forward(request, response); --%> <!-- request 정보가 살아남는다. / page는 page가 넘어가면 사라져서 request만 넘어간다. -->
	<%-- 2. sendRedirect 방식 : request , response가 새로운 것을 사용 --%> <!-- response 가 되는 순간 request 는 사라진다. -->
	<% response.sendRedirect("ex13_request.jsp"); %>
</body>
</html>