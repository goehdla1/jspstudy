<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 인증 코드 요청 --%>
	<a href="https://kauth.kakao.com/oauth/authorize?client_id=8f3477e0d19a7f4678fae2f3cbe84d98&redirect_uri=http://localhost:8080/login&response_type=code">
		<img alt="" src="../img/kakao.png">
	</a>
</body>
</html>