<%@page import="com.ict.edu.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
    
    String name = request.getParameter("name");
    String subject = request.getParameter("subject");
    String email = request.getParameter("email");
    String content = request.getParameter("content");
    String idx = request.getParameter("idx");
    
    int result = DAO.getInstance().getUpdate(name, subject, 
    		email, content, idx);
    pageContext.setAttribute("result", result);
%>    
<jsp:forward page="onelist.jsp?idx=${vo.idx}"></jsp:forward>
