<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
<style type="text/css">
	table { width: 500px; border-collapse: collapse; 
	text-align: center; border-color: tomato;}
	table, th, td { border: 1px solid tomato; }
	a{text-decoration: none;}
</style>
</head>
<body>
	<div align="center">
		<h2> 방명록 </h2>
		<hr>
		<p> [<a href="/MyController?cmd=write"> 방명록 쓰기 </a>] </p>
		<form method="post">
			<table>
				<thead>
					<tr bgcolor="#99ccff">
						<th>번호</th> <th>작성자</th> <th>제목</th> <th>작성일</th>
					</tr>
				</thead>
				<tbody>
					<%-- if문 처럼 나눠서 처리 하자 --%>
					<c:choose>
						<%-- 정보가 없을 때 --%>
						<c:when test="${empty list }">
							<tr>
								<td colspan="4"><h2> 정보가 존재하지 않습니다.</h2></td>
							</tr>
						</c:when>
						<%-- 정보가 있을 때  --%>
						<c:otherwise>
							<!-- 정보가 여러개 일때   -->
							<c:forEach var="k" items="${list}">
								<tr>
									<td>${k.idx } </td>
									<td>${k.name } </td>
									<td><a href="/MyController?cmd=onelist&idx=${k.idx}">${k.subject }</a></td>
									<td>${k.regdate.substring(0,10)} </td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>			
			</table>
		</form>
	</div>
</body>
</html>