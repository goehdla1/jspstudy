<%@page import="com.ict.edu.VO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ict.edu.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	ArrayList<VO> list = DAO.getInstance().getList();
pageContext.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div{text-align: center ; margin: 0px auto;}
	table{width: 500px; margin: 0px auto; border-collapse: collapse;}
	table, tr, th, td {border: 1px solid red;}
	fieldset { width: 300px;}
</style>
</head>
<body>

	<div>
		<h1> 전체 리스트 보기 </h1>
		<table>
			<thead>
					<tr>
					<th>번호</th><th>M_Id</th><th>M_Pw</th><th>M_Name</th><th>M_Age</th><th>M_Reg</th>
					</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${empty list}">
					<tr><td colspan="6"><h2> 원하는 자료가 존재하지 않습니다. </h2></td></tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="k" items="${list}">
							<tr>
							<td>${k.idx}</td>
			    				<td>${k.m_id}</td>
			    				<td>${k.m_pw}</td>
			    				<td>${k.m_name}</td>
			    				<td>${k.m_age}</td>
			    				<td>${k.m_reg.substring(0,10)}</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		
		
		</table>
	</div>
</body>
</html>