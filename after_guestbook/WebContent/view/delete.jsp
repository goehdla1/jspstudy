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
	function delete_ok(f) {
		var pwd1 = f.pwd.value ; 
		
		if (pwd1 == "${vo.pwd}") {
			var chk = confirm("정말 삭제할까요?");
			if (chk) {
				f.action = "MyController?cmd=delete_ok";
				f.submit();
				
			}else{
				return;
			}
				
		}else {
			alert("비밀번호가 다릅니다.\n 다시입력하세요.")
			f.pwd.value="";
			f.pwd.focus();
			return;
		}
	}
</script>
</head>
<body>
<div>
		<h2> 방명록 : 상세내용보기 </h2>
		<hr>
		<p> [ <a href="/MyController?cmd=list"> 목록으로 이동 </a> ]  </p>
		<form>
		<table>
			<tbody>
			   <tr>
			   		<th bgcolor="#99ccff"> 패스워드 </th>
			   		<td><input type="password" name="pwd"></td>
			  </tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<input type="button" value="삭제" onclick="delete_ok(this.form)">
					</td>
				</tr>
			</tfoot>
		</table>		
		</form>
	</div>

</body>
</html>