<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div{text-align: center;}
	table{width: 800px; margin: 0 auto;}
	table, th, td {
		border: 1px solid darkblue;
		text-align: center;
		border-collapse:collapse; 
	}

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btn1").click(function() {
			$("#tbody").empty();
			$.ajax({
				url : "/MyController01",
				method : "get",
				dataType : "xml",
				success : function(data) {
					var tr = "";
					$(data).find("product").each(function() {
						tr += "<tr>";
						var name = $(this).find("name").text();
						var price= $(this).find("price").text();
						tr += "<td>"+name+"</td><td>"+price+"</td>";
						tr += "</tr>";
					});	
					$("tbody").append(tr);
				},
				error : function() {
					alert("가져오기 실패")
				}
			});
		});
		$("#btn2").click(function() {
			$("#tbody").empty();
			$.ajax({
				url : "/MyController02",
				method : "get",
				dataType : "xml",
				success : function(data) {
					var tr = "";
					$(data).find("product").each(function() {
						tr += "<tr>";
						var name = $(this).attr("name");
						var price= $(this).attr("price");
						tr += "<td>"+name+"</td><td>"+price+"</td>";
						tr += "</tr>";
					});	
					$("tbody").append(tr);
				},
				error : function() {
					alert("가져오기 실패")
				}
			});
		});
		$("#btn3").click(function() {
			$("#tbody").empty();
			$.ajax({
				url : "/MyController03",
				method : "get",
				dataType : "xml",
				success : function(data) {
					var tr = "";
					$(data).find("product").each(function() {
						tr += "<tr>";
						var name = $(this).text()
						var price= $(this).attr("price");
						tr += "<td>"+name+"</td><td>"+price+"</td>";
						tr += "</tr>";
					});	
					$("tbody").append(tr);
				},
				error : function() {
					alert("가져오기 실패")
				}
			});
		});
		
		$("#btn4").click(function() {
			$("#tbody").empty();
			$.ajax({
				url : "/MyController04",
				method : "get",
				dataType : "json",
				success : function(data) {
					var tr = "";
					$.each(data,function(k,v){
						tr +="<tr>";
						var name = v["name"];
						var price = v["price"];
						tr += "<td>"+name +"</td><td>"+price+"</td>";
						tr+="</tr>";
					});
					
					$("tbody").append(tr);
				},
				error : function() {
					alert("가져오기 실패")
				}
			});
		});
		$("#btn5").click(function() {
			$("#tbody").empty();
			$.ajax({
				url : "/MyController05",
				method : "get",
				dataType : "text",
				success : function(data) {
					var tr = "";
					var sp1 = data.split("/")
					for ( var k in sp1) {
						tr+="<tr>";
						var sp2 = sp1[k].split(",");
						for ( var k2 in sp2) {
							tr += "<td>"+ sp2[k2]+"</td>" ;
						}
						tr+="</tr>";	
					}
						
				
					
					$("tbody").append(tr);
				},
				error : function() {
					alert("가져오기 실패")
				}
			});
		});
	});
</script>
</head>
<body>
	<div>
		<button id="btn1"> XML 정보 가져오기 </button>
		<button id="btn2"> XML 정보 가져오기 </button>
		<button id="btn3"> XML 정보 가져오기 </button>
		<button id="btn4"> JSON 정보 가져오기 </button>
		<button id="btn5"> Text 정보 가져오기 </button>
	</div>
	<hr>
	<div>
		<table>
			<thead>
				<tr><th>종류</th> <th>가격</th></tr>
			</thead>
			<tbody id="tbody"></tbody>
		</table>
	</div>
</body>
</html>