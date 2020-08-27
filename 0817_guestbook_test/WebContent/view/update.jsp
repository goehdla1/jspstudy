<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title> 방 명 록 </title>
	<style type="text/css">
		a { text-decoration: none;}
		table{width: 500px; border-collapse:collapse; }
		table,tr,td{border: 1px solid black; padding: 3px}
	</style>
	<script type="text/javascript">
		function update_ok(f) {
			if(f.pwd.value == "${vo.pwd}"){
				f.action="/MyController?cmd=update";
				f.submit();
			}
			else{
				alert("비밀번호 불일치");
				f.pwd.focus();
			}
			
		}
		
		function update_no(){
			window.history.go(-1);
		}
		
	</script>
</head>
<body>
	<div align="center">
		<h2>방명록 : 내용화면</h2>
		<hr />
		<p>[<a href="/MyController?cmd=list">목록으로 이동</a>]</p>
		<form method="post">
			<table>
				<tr align="center">
					<td bgcolor="#99ccff">작성자</td>
					<td><input type="text" name="name" size ="20" value="${vo.name}"/></td>
				</tr>
				<tr align="center">
					<td bgcolor="#99ccff">제  목</td>
					<td><input type="text" name="subject" size ="20" value="${vo.subject}"/></td>
				</tr>
				<tr align="center">
					<td bgcolor="#99ccff">email</td>
					<td><input type="text" name="email" size ="20" value="${vo.email}"/></td>
				</tr>
				<tr align="center">
					<td bgcolor="#99ccff">비밀번호</td>
					<td><input type="password" name="pwd" size ="20" /></td>
				</tr>
				<tr align="center">
					<td colspan="2">
						<textarea rows="10" cols="60" name="content">${vo.content}</textarea>
					</td>
				</tr>
				<tfoot>
					<tr align="center">
						<td colspan="2">
							<input type="button" value="수정" onclick="update_ok(this.form)" />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="button" value="취소" onclick="update_no()"/>
							<input type="hidden" name="idx" value="${vo.idx}"/>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>