<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 기본객체 : session</title>
</head>
<body>
	<%--
	- session : 서버와 클라이언트간의 접속을 유지 시켜주기 위한 객체 (보통 로그인기능에 사용한다.)
			
			** 속성을 활용한 데이터 저장과 호출
			저장방법 : session.setAttribute("이름",데이터);
			호출방법 : session.getAttribute("이름");
			생명주기 : 일반적으로 웹브라우저가 종료되면 사라진다.

 --%>

	<%
	pageContext.setAttribute("name", "홍길동");
	pageContext.setAttribute("age", 25);

	request.setAttribute("name", "태권브이");
	request.setAttribute("age", 68);

	session.setAttribute("name", "둘리");
	session.setAttribute("age", 18);
	%>

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
		<%--request.getRequestDispatcher("ex15_session.jsp").forward(request, response);--%>
		<%response.sendRedirect("ex15_session.jsp"); %>
</body>
</html>