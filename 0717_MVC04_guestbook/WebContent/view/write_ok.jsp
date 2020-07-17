<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${result>0}">
		<script type="text/javascript">
			alert("삽입성공");
			location.href = "/0717_MVC04_guestbook/MyController?cmd=list";
		</script>
	</c:when>
		<c:otherwise>
			<script type="text/javascript">
			alert("삽입실패");
			location.href = "/0717_MVC04_guestbook/MyController?cmd=write"
			</script>
		</c:otherwise>
</c:choose>

</body>
</html>