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
		 //.ajax({url, method, data, dataType, success, error})
		   $.ajax({
				url : "data01.xml", //서버주소 , 서블릿 주소
				method : "get",
				dataType : "xml",
				success : function(data) {
					var table = "<table>";
					table += "<thead><tr><td>이름</td><td>가격</td></tr></thead>";
					table += "<tbody>";
					$(data).find("product").each(function() {
						var name = $(this).find("name").text();
						var price = $(this).find("price").text();
						table += "<tr><td>"+name+"</td><td>"+price+"</td></tr>";
					});
					
					table += "</tbody>";
					$("#out").append(table);
				},
				error : function() {
					alert("가져오기 실패");
				}
		});
	});

</script>
</head>
<body>
<div> xml 파일 가져오기 </div>
	<div id="out"></div>
	<select >
	</select>
</body>
</html>