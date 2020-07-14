<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="vo" class="com.ict.edu02.VO" />
	<jsp:setProperty property="*" name="vo" />
	
	<h2> 파라미터값 표시</h2>
	<h3>
		<ul>
			<li>이름: <%= vo.get %>></li>
		</ul>
	
	</h3>
</body>
</html>