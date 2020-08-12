<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table{width: 800px; margin: 0 auto; border-collapse: collapse;}
	table, th, td {border: 1px solid blue; text-align: center;}
</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btn1").click(function() {
			$("#output").empty();
			$.ajax({
				url: "/MyController01",
				dataType: "xml",
				type: "get",
				success:function(data){
					var table = "<table>"
					table += "<thead><tr><th>지역</th><th>온도</th><th>상태</th><th>아이콘</th></tr></thead>";
					table += "<tbody>";
					$(data).find("local").each(function() {
						table += "<tr>";
						table += "<td>"+ $(this).text()+"</td>";
						table += "<td>"+ $(this).attr("ta")+"</td>";
						table += "<td>"+ $(this).attr("desc")+"</td>";
						table += "<td><img src='http://www.kma.go.kr/images/icon/NW/NB"+ 
								$(this).attr("icon")+".png'></td>";
						table += "</tr>";
					});
					table += "</tbody></table>";
					$("#output").append(table);
				},
				error:function(){
					alert("읽기실패");
				}
			});
		}); // 버튼 끝
		$("#btn2").click(function() {
			$("#output").empty();
			$.ajax({
				url: "/MyController02" ,
				dataType: "json",
				type: "get",
				success:function(data){
					var table = "<table>"
					table += "<thead><tr><th>도서관이름</th><th>주소</th><th>휴관일</th><th>전화번호</th></tr></thead>";
					table += "<tbody>"
					$.each(data,function(k,v) {
						$.each(v["row"], function(data) {
							table += "<tr>";
							table += "<td>"+ this["LBRRY_NAME"]+"</td>";
							table += "<td>"+ this["ADRES"]+"</td>";
							table += "<td>"+ this["FDRM_CLOSE_DATE"]+"</td>";
							table += "<td>"+ this["TEL_NO"]+"</td>";
							table += "</tr>";
							
						});
					});
					
					
					table += "</tbody></table>"
					$("#output").append(table);
					
				},
				error:function(){
					alert("읽기실패");
				}
			});
		}); // 버튼 끝
	});
</script>
</head>
<body>
	<div>
		<button id="btn1"> XML 파일 가져오기 </button>
		<button id="btn2"> JSON 파일 가져오기 </button>
	</div>
	<br>
	<hr>
	<br>
	<div id="output"></div>
</body>
</html>