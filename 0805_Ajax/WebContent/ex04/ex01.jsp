<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btn1").click(function() {
			// .load(url,data,callback)
			$("#res1").load("data1.jsp")
		});

	});
	$(function() {
		$("#btn2").click(function() {
			// .load(url,data,callback)
			$("#res2").load("data2.jsp")
		});
		$("#menu").on("mouseover", function() {
			$("#output").load("data3.jsp")
		})
		$("#menu").on("mouseout", function() {
			$("#output").empty()
		})

	});
</script>
</head>
<body>
	<div>
		<h2>iframe 활용</h2>
		<iframe src="data1.jsp" style="width: 80%; height: 50%;"> </iframe>

	</div>
	<div>
		<h2>include 활용</h2>
		<jsp:include page="data1.jsp"></jsp:include>

	</div>
	<hr>

	<div>
		<h2>jQuery 활용</h2>
		<p id="res1"></p>
		<button id="btn1">가져오기</button>
	</div>

	<div>
		<h2>jQuery 활용</h2>
		<p id="res2"></p>
		<button id="btn2">가져오기</button>
	</div>

	<hr>

	<div>
		<p id="menu">메뉴 보기</p>
		<span id="output"></span>
	</div>

</body>
</html>