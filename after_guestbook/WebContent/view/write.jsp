<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 방명록 쓰기 </title>
<style type="text/css">
	div{margin: 0px auto; width: 600px;}
	h2, p{text-align: center;}
	table { width: 500px; border-collapse: collapse; margin:0px auto; 
			text-align: center; border-color: tomato; }
	table, th, td { border: 1px solid tomato; }
	a{text-decoration: none;}
</style>
<script type="text/javascript">
	function insert_go(f) {
		f.action="/MyController?cmd=write_ok";
		f.submit();
	}
</script>
</head>
<body>
	<div>
		<h2> 방명록 : 작성화면</h2>
		<hr>
		<p> [ <a href="/MyController?cmd=list"> 목록으로 이동 </a> ]  </p>
		<form method="post">
			<table>
				<tbody>
					<tr align="center">
						<th style="background-color: #99ccff">작성자</th>
						<td><input type="text" name="name" size=20></td>
					</tr>
					<tr align="center">
						<th style="background-color: #99ccff">제  목</th>
						<td><input type="text" name="subject" size=20></td>
					</tr>
					<tr align="center">
						<th style="background-color: #99ccff">email</th>
						<td><input type="text" name="email" size=20></td>
					</tr>
					<tr align="center">
						<th style="background-color: #99ccff">비밀번호</th>
						<td><input type="password" name="pwd" size=20></td>
					</tr>
					<tr align="center">
						<th style="background-color: #99ccff" colspan="2">내용 입력</th>
					</tr>
					<tr align="center">
						<td colspan="2">
							<textarea rows="10" cols="60" name="content"></textarea>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr align="center">
						<td colspan="2" style="background-color: #99ccff"> 
							<input type="button" value="삽입하기" onclick="insert_go(this.form)">
							<input type="reset">
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>




