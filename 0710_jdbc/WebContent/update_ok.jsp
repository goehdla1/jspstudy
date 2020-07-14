<%@page import="com.ict.edu.DAO"%>
<%@page import="com.ict.edu.VO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	request.setCharacterEncoding("utf-8");
	String m_name = request.getParameter("M_NAME");
	String m_age = request.getParameter("M_AGE");
	VO vo = (VO)session.getAttribute("vo");
	String idx = vo.getIdx();
	int result = DAO.getInstance().getUpdate(m_name , m_age , idx);
	pageContext.setAttribute("result", result);
	
	// 기존의 session의 정보를 업데이트하자.
	vo.setM_name(m_name);
	vo.setM_age(m_age);
	
	// 같은이름이 있으면 덮어쓰기가 된다.
	session.setAttribute("vo",vo);
%>

<c:choose>
	<c:when test="${result>0}">
		<script>
			alert("수정성공");
			location.href = "onlist.jsp";
		</script>
	</c:when>
	<c:otherwise>
		<script>
			alert("수정실패");
			location.href = "update.jsp";
		</script>
	</c:otherwise>
</c:choose>