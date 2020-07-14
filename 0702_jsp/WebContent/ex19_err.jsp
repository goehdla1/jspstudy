<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>요청처리과정에서 에러가 발생하였습니다.</h2>
	<h2>빠른 시간 내에 문제를 해결하도록 하겠습니다.</h2>
	<!-- 페이지 지시어 속성중 isELIgnored="true" 설정하면 exception을 사용 가능. -->
	<h2>
		에러타입 :
		<%=exception.getClass().getName()%></h2>
		<h2>에러 메세지 : <%= exception.getMessage() %></h2>
		
		

</body>
</html>