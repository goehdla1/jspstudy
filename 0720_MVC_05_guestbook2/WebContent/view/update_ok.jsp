
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${result>0}">
		<script>
			alert("업데이트 성공");
			location.href = "/0720_MVC_05_guestbook2/MyController?cmd=onelist&idx=${idx}"
		</script>
	</c:when>
	<c:otherwise>
		<script>
			alert("업데이트 실패");
			history.go(-2);
		</script>
	</c:otherwise>
</c:choose>
