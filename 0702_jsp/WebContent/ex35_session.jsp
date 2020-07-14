<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
			// ex34_session에서 저장한 세션정보들을 불러와서 사용.
			String log = (String)session.getAttribute("log"); // 자료형을 몰라서 Object형으로 나온다. 그래서 자료형을 맞춰줘야함.
			if(log.equals("No")){%>
					<script> alert("로그인 실패");
					location.href= "ex33_session.jsp";</script>
			<% }else if(log.equals("Ok")){%>
				
		
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function add_go(f) {
		f.action = "ex36.jsp";
		f.submit();
	}
	function view_go() {
		location.href = "ex37.jsp";
	}
	function logout_go() {
		location.href = "ex38.jsp";
	}
</script>
</head>
<body>
	<% String id = (String)session.getAttribute("id"); %>
	<h2> <%= id %> 님 로그인 성공</h2>
	<hr>
	<h2> 장바구니 선택 </h2>
	<form method="post">
		<select name = "fruits">
		<option>:: 선택하세요 ::</option>
		<option>수박</option>
		<option>참외</option>
		<option>망고</option>
		<option>키위</option>
		<option>딸기</option>
	
		</select>
		<input type="button" value="장바구니에 추가" onclick="add_go(this.form)">
	
	
	</form>
	<hr>
	<!-- form 밖에서는 button을 써야한다. -->
	<button onclick="view_go()"> 장바구니 보기 </button>
	<button onclick="logout_go()"> 로그 아웃 </button>
</body>
</html>
	<%}
		%>