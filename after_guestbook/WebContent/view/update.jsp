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
	function update_go(f) {
		var pw = f.pwd.value;
		if (pw = "${vo.pwd}") {
			f.action = "MyController?cmd=update_ok";
			f.submit();
		}else {
			alert ("비밀번호가 틀립니다.");
			f.pwd.value="";
			f.focus();
			return;
		}
		
		
	}
</script>
</head>
<body>
<div>
	<!-- session 에 저장되어 있는 데이터를 input 형식에 넣는다. -->
		<h2> 방명록 : 수정화면</h2>
		<hr>
		<p> [ <a href="/MyController?cmd=list"> 목록으로 이동 </a> ]  </p>
		<form method="post">
			<table>
				<tbody>
					<tr align="center">
						<th style="background-color: #99ccff">작성자</th>
						<td><input type="text" name="name" value="${vo.name}" size=20></td>
					</tr>
					<tr align="center">
						<th style="background-color: #99ccff">제  목</th>
						<td><input type="text" name="subject" value="${vo.subject}" size=20></td>
					</tr>
					<tr align="center">
						<th style="background-color: #99ccff">email</th>
						<td><input type="text" name="email" value="${vo.email}" size=20></td>
					</tr>
					<tr align="center">
						<th style="background-color: #99ccff">비밀번호</th>
						<td><input type="password" name="pwd"  size=20></td>
					</tr>
					<tr align="center">
						<th style="background-color: #99ccff" colspan="2">내용 입력</th>
					</tr>
					<tr align="center">
						<td colspan="2">
							<textarea rows="10" cols="60" name="content"><pre>${vo.content}</pre></textarea>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr align="center">
						<td colspan="2" style="background-color: #99ccff"> 
							<input type="button" value="수정하기" onclick="update_go(this.form)">
							<input type="reset">
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>

</body>
</html>