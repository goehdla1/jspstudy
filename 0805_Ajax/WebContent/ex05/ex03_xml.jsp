<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table {
	 width: 600px; margin-top: 50px; border-collapse: collapse;
}
table,th,td{
	border: 1px solid red; text-align: center;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btn").click(function() {
			$("#out").empty();
			var table = "<table>";
			table += "<thead><tr><td>이름</td><td>가격</td></tr></thead>";
			table += "<tbody>";
			$.get("data03.xml",function(data){
				$(data).find("product").each(function() {
					var name = $(this).text();
					var price = $(this).attr("price");
					table += "<tr>";
					table += "<td>"+name+"</td><td>"+price+"</td>";
					table += "</tr>";
				});		
				table += "</tbody></table>";
				$("#out").append(table);
			});
			
		});
	});
</script>
</head>
<body>
	<div id="btn">가져오기</div>
	<div id="out"></div>
</body>
</html>