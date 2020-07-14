<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
String pw = request.getParameter("pw");

// id와 pw가 같으면 로그인 성공
if (id.equals(pw)) {
	session.setAttribute("log", "Ok");
	session.setAttribute("id", id);
} else {
	session.setAttribute("log", "No");
}
/* response.sedRedirect 사용하면 request 정보는 사라지고 session 정보는 남아있다. */
response.sendRedirect("ex35_session.jsp");
%>
