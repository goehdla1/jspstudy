<%@page import="com.ict.edu.VO"%>
<%@page import="com.ict.edu.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%
	request.setCharacterEncoding("utf-8");
   
    // 방법1
	 String name = request.getParameter("name");
     String subject = request.getParameter("subject");
     String email = request.getParameter("email");
     String pwd = request.getParameter("pwd");
     String content = request.getParameter("content");
    
    // int result = DAO.getInstance().getInsert(name, subject, email, pwd, content);
	// pageContext.setAttribute("result", result);
	
    // 방법2
     VO vo = new VO();
     vo.setName(name);
     vo.setSubject(subject);
     vo.setEmail(email);
     vo.setPwd(pwd);
     vo.setContent(content);
     int result = DAO.getInstance().getInsert(vo); 
     pageContext.setAttribute("result", result);
%>
    
<c:choose>
	<c:when test="${result>0}">
		<script>
			alert("삽입 성공");
			location.href = "list.jsp";
		</script>
	</c:when>
	<c:otherwise>
		<script>
			alert("삽입 실패");
			location.href = "write.jsp";
		</script>
	</c:otherwise>
</c:choose>











