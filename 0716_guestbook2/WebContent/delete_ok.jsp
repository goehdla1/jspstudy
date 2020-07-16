<%@page import="ict.com.edu.DAO"%>
<%@page import="ict.com.edu.VO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
<%
	// session이 가지고 있는 정보 중 idx를 가져오자
	VO vo = (VO)session.getAttribute("vo");
	String idx = vo.getIdx();
	int result = DAO.getInstance().getDelete(idx); 
	pageContext.setAttribute("result", result);
%>
<c:choose>
	<c:when test="${result>0}">
		<script>
			alert("삭제성공");
			location.href = "list.jsp";
		</script>
	</c:when>
	<c:otherwise>
		<script>
			alert("삭제실패");
			history.go(-2);
		</script>
	</c:otherwise>
</c:choose>