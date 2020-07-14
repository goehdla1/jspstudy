<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style type="text/css">
	div{text-align: center ; margin: 0px auto;}
	table{width: 500px; margin: 0px auto; border-collapse: collapse;}
	table, tr, th, td {border: 1px solid red;}
	fieldset { width: 300px;}
</style>
<script type="text/javascript">
	function join_ok(f) {
		// 유효성 검사 해야 됨
		var M_ID = f.M_ID.value ;
		if(M_ID==""){
			alert("아이디를 입력하세요");
			f.M_ID.value = "";
			f.M_ID.focus();
			return;
		}
		var M_PW = f.M_PW.value ;
		if(M_PW==""){
			alert("패스워드를 입력하세요");
			f.M_PW.value = "";
			f.M_PW.focus();
			return;
		}
		var M_NAME = f.M_NAME.value ;
		if(M_NAME==""){
			alert("이름을 입력하세요");
			f.M_NAME.value = "";
			f.M_NAME.focus();
			return;
		}
		var M_AGE = f.M_AGE.value ;
		if(M_AGE==""){
			alert("나이를 입력하세요");
			f.M_AGE.value = "";
			f.M_AGE.focus();
			return;
		}
		f.action = "join_ok.jsp";
		f.submit();
	}
</script>
</head>
<body>
	<div>
		<form method="post">
			<fieldset>
				<legend>회원가입</legend>
				<table>
					<tbody>
						<tr>
							<th>*M_ID</th>
							<td><input type="text" name="M_ID" size="15"></td>
						</tr>
						<tr>
							<th>*M_PW</th>
							<td><input type="password" name="M_PW" size="15"></td>
						</tr>
						<tr>
							<th>*M_name</th>
							<td><input type="text" name="M_NAME" size="15"></td>
						</tr>
						<tr>
							<th>*M_age</th>
							<td><input type="number" name="M_AGE" size="15"></td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="reset" value="취소">
								&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="button" value="회원가입" onclick="join_ok(this.form)"> 
							</td>
						</tr>
					</tbody>
				</table>
			</fieldset>
		</form>
	</div>
</body>
</html>