<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
	//객체 생성	
	var request = new XMLHttpRequest();
	// open ("전송방식 , "경로" , "비동기여부")
	request.open("GET","data.html",false);
	
	// send() : 실행
	request.send();
	
	// 화면에 출력 : innerHTML
	document.body.append(request.responseText);
	</script>
</body>
</html>