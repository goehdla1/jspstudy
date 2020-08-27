<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div{margin: 0px auto; width: 600px;}
	h2, p{text-align: center;}
	table { width: 500px; border-collapse: collapse; margin:0px auto; 
			text-align: center; border-color: tomato; }
	table, th, td { border: 1px solid tomato; }
	a{text-decoration: none;}
</style>
<script type="text/javascript">
	function update_go() {
		location.href = "/MyController?cmd=update";
	}
	function delete_go() {
		location.href = "/MyController?cmd=delete";
	}
</script>
</head>
<body>
	<div>
		<h2> 방명록 : 상세내용보기 </h2>
		<hr>
		<p> [ <a href="/MyController?cmd=list"> 목록으로 이동 </a> ]  </p>
		<table>
			<tbody>
			   <tr>
			   		<th bgcolor="#99ccff"> 작성자 </th>
			   		<td> ${vo.name }</td>
			   </tr>
			   <tr>
			   		<th bgcolor="#99ccff"> 제  목 </th>
			   		<td>${vo.subject }</td>
			   </tr>
			   <tr>
			   		<th bgcolor="#99ccff"> email </th>
			   		<td>${vo.email }</td>
			   </tr>
			   <tr>
			   		<td colspan="2"><pre>${vo.content }</pre></td>
			   </tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<button onclick="update_go()">수정하기</button>
						<button onclick="delete_go()">삭제하기</button>
					</td>
				</tr>
			</tfoot>
		</table>		
	</div>
</body>
</html>