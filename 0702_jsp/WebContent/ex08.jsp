<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
String pw = request.getParameter("pw");
String addr = "일산";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파라미터값 받기</title>
<script type="text/javascript">
function send_go(f) {
	f.action = "ex09.jsp";
	f.submit();
}
function send_go2(f) {
	f.action = "ex09.jsp";
	f.submit();
}
	function send_go3() {
		location.href="ex09.jsp";
	}
	function send_go4() {
		location.href="ex09.jsp?id=<%=id%>&pw=<%=pw%>";
	}
	function send_go5() {
		/* 뒤로가기 */
		history.go(-1);
	}
</script>
</head>
<body>
	<h1>파라미터값 결과 보기 (ex08.jsp)</h1>
	<h2>
		<li>id = <%=id%>
		</li>
		<li>pw = <%=pw%>
		</li>
	</h2>

	<%-- 다른 페이지로 이동하기 --%>

	<!-- 1. respnse.sendRedirect("이동 할 페이지")  / 중간페이지가 안보인다. -->
	<%-- <% response.sendRedirect("ex09.jsp"); %> --%>

	<!-- 2. request.getRequestdispatcher("이동 할 페이지").forward(resquest,response) -->
	>
	<%-- <% request.getRequestDispatcher("ex09.jsp").forward(request, response) ;%> --%>

	<!-- 다른페이지로 이동하기 (중간페이지에서 이벤트처리) -->
	<!-- 3. a 링크로 페이지 이동하기 -->
	<a href="ex09.jsp"> 다른페이지로 이동 </a>
	<br>
	<!-- 파라미터값을 가지고 간게 아니다. -->
	<a href="ex09.jsp?id=<%=id%>&pw=<%=pw%>"> 다른페이지로 이동</a>
	<!-- 파라미터값을 갖고 간다. -->
	<!-- 4. 자바 스크립트를 이용한 페이지 이동 -->

<form>
		<input type="button" value="보내기(파라미터 없음)" onclick="send_go(this.form)">
	</form>
	<form>
		<input type="button" value="보내기(파라미터 있음)" onclick="send_go2(this.form)">
		<input type="hidden" name="id" value="<%=id%>">
		<input type="hidden" name="pw" value="<%=pw%>">
	</form>

	<button onclick="send_go3()">보내기</button>
	<!-- 파라미터가 없다. / ()는 함수를 뜻한다. -->
	<button onclick="send_go4()">보내기</button>
	<!-- 파라미터가 있다. / ()는 함수를 뜻한다.-->
	<button onclick="send_go5()">뒤로가기</button>
</body>
</html>