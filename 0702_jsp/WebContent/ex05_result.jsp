<%@page import="java.util.Map"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8"); // 파라미터값 넘어오면 무조건 써라.
// 파라미터값 받기
String name = request.getParameter("name");
String age = request.getParameter("age");
String addr = request.getParameter("addr");
String gender = request.getParameter("gender");
String[] hobby = request.getParameterValues("hobby");
String residence = request.getParameter("residence");
String[] animal = request.getParameterValues("animal");
String cPage = request.getParameter("cPage");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>파리미터값 표시하기</h2>
	<h3>
		<ul>
			<li>이름 : <%=name%></li>
			<li>나이 : <%=age%></li>
			<li>주소 : <%=addr%></li>
			<li>성별 : <%=gender%></li>
			<li>취미 :<%
				for (String k : hobby) {
			%> <%=k%> <%
 	}
 %>
			</li>
			<li>취미 : <%
				for (String k : hobby) {
				out.println(k + "&nbsp;&nbsp;");
			}
			%></li>
			<li>거주지 : <%=residence%></li>
			<li>반려동물 : <%
				for (String k : animal) {
				out.println(k + "&nbsp;&nbsp;");
			}
			%></li>
			<li>cPage : <%=cPage%>
			</li>
		</ul>

	</h3>
	<h2>getParameterNames(): 파라미터 이름들 구하기</h2>
	<h3>
		<%
			Enumeration p_enum = request.getParameterNames();
		while (p_enum.hasMoreElements()) {
			String p_name = (String) p_enum.nextElement();
			out.println("<li>" + p_name + "</li>");
		}
		%>
	</h3>
	
	<h2> getParameterMap() : 파라미터 구하기 </h2>
	<h3>
		<%
			Map map = request.getParameterMap();
			map.get("name");
			String[] m_name = (String[])map.get("name");
			String[] m_age = (String[])map.get("age");
			String[] m_hobby = (String[])map.get("hobby");
		
		%>
	
	</h3>
</body>
</html>