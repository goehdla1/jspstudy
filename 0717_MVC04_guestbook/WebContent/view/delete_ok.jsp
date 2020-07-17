<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${result>0}">
		<script>
			alert("삭제성공");
			location.href = "/0717_MVC04_guestbook/MyController?cmd=list";
		</script>
	</c:when>
	<c:otherwise>
		<script>
			alert("삭제실패");
			history.go(-2);
		</script>
	</c:otherwise>
</c:choose>
</body>
</html>