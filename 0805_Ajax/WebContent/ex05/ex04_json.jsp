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
		/* 	$.getJSON("data04.js",function(data){
				$.each(data,function(k,v){
					table += "<tr>";
					table += "<td>"+ v["name"]+"</td><td>"+v["price"]+"</td>";
					table += "</tr>";
					
				});
				table += "</body></table>"
					$("#out").append(table);
			}); */
			
			// key,value 사용 안하고 this를 사용하는 방법
			
		 	$.getJSON("data04.js",function(data){
				$.each(data,function(){
					table += "<tr>";
					table += "<td>"+ this["name"]+"</td><td>"+this["price"]+"</td>";
					table += "</tr>";
					
				});
				table += "</body></table>"
					$("#out").append(table);
			}); 
			
			
		});
	});

</script>
</head>
<body>
	<div id="btn"> json 가져오기 </div>
	<div id="out"></div>
</body>
</html>