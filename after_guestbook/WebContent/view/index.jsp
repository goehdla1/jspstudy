<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function list_go() {
		// 컨트롤러 방명록 전체보기의 정보를 가지고 가자
		location.href = "/MyController?cmd=list";
	}
</script>
</head>
<body>
	<button onclick="list_go()">방명록 전체보기</button>
</body>
</html>