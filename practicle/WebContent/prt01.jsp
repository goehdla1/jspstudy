<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function send_go(f) {
		f.action = "prt02.jsp";
		f.submit();
		
	}
</script>
</head>
<body>
body>

 <h2> form를 이용한 파라미터 전송하기</h2>
	<form method="post">
		<fieldset>
			<legend> 데이터 전송 </legend>
			<p>이름 : <input type="text" name="name"></p>
			<p>나이 : <input type="number" name="age"></p>
			<p>주소 : <input type="text" name="addr"></p>
			<p>성별 : 
				<input type="radio" name="gender" value="남">남
				<input type="radio" name="gender" value="남">여
		 	</p>
			<p>취미 : <input type="checkbox" name="hobby" value="운동">운동
					  <input type="checkbox" name="hobby" value="독서">독서
					  <input type="checkbox" name="hobby" value="영화">영화
					  <input type="checkbox" name="hobby" value="게임">게임 
			</p>
			<p> 거주지 : <select name="residence">
							<option>::선택하세요::</option>
							<option>서울</option>
							<option>경기</option>
							<option>강원</option>							
							<option>제주</option>
						 </select>
			</p>
			<p> 반려동물 : <select name="animal" multiple size="4">
							<option>강아지</option>
							<option>고양이</option>
							<option>토끼</option>							
							<option>앵무새</option>
						 </select>
			</p>
			<input type="hidden" name="cPage" value="1">
			<input type="button" value="정보보내기" onclick="send_go(this.form)">
		</fieldset>
	</form>
</body>
</html>