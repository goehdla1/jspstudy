<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL : 표현 언어</title>
</head>
<body>
	<%-- 
		- EL : JSP 에서 사용 가능한 새로운 스크릅트언어
			   표현식(<%=%>) 대신에 사용된다.
			* 파라미터 값을 받을 때도 사용 된다.
			* JSP가 가지고 있는 4가지 저장소에 저장된 정보를 호출 할 수 있다.
			* 표현식 대신 사용 할 수 있다.
			(    <%= 변수 or 메소드 or 계산식 %> ==> ${변수 or 메소드 or 계산식}    )
		
		--%>
	<h2> 표현식 산술 연상 사용 예제 </h2>
	<h3>
		<li> 15 + 7 = <%= 15+7 %> </li>
		<li> 15 - 7 = <%= 15-7 %> </li>
		<li> 15 * 7 = <%= 15*7 %> </li>
		<li> 15 / 7 = <%= 15/7 %> </li>
	</h3>
	<hr>
	<h2> 표현식 산술 연상 사용 예제 </h2>
	<h3>
		<li> 15 + 7 = ${15+7}  </li>
		<li> 15 - 7 = ${15-7} </li>
		<li> 15 * 7 = ${15*7} </li>
		<li> 15 / 7 = ${15/7} </li>
	</h3>
	<hr>
	
	<h2> 표현식 변수 사용 예제 </h2>
	<% int su1 = 125 + 25 ;  %>
	<h3><li>su1 = <%=su1%></li></h3>
	<hr>
	
	<h2> 표현식 변수 사용 예제 </h2>
	<%-- EL은 jsp에서 바로 만든 변수의 값은 호출 안된다. --%>
	<%-- 그래서 4가지 저장소에 변수의 값을 호출 하면 가능  
		*4가지 저장소 : pageContext , request , session , application
	--%>
	<% int s1 = 125 + 25 ;  %>
	<h3><li>s1 = ${s1} </li></h3>
	<hr>
	
	<% int s2 = 125 + 25 ; 
		pageContext.setAttribute("s2", s2);
	%>
	<h3><li>s2 = ${s2} </li></h3>
	<hr>
	<%-- 4가지 저장소에 속성의 이름이 같으면 우선순위는
		pageContext > request > session > application
	 --%>
	 <% pageContext.setAttribute("pc", "i3") ;%>
	 <% request.setAttribute("pc", "i5") ;%>
	 <% session.setAttribute("pc", "i7") ;%>
	 <% application.setAttribute("pc", "i9") ;%>
	 
	 <h3>
	 	<li> 호출하기 ( 우선순위 존재 ) </li>
	 	<li>  ${pc} </li>
	 	<li>  ${pageScope.pc} </li>
	 	<li>  ${requestScope.pc} </li>
	 	<li>  ${sessionScope.pc} </li>
	 	<li>  ${applicationScope.pc} </li>
	 	</h3>
	<%-- 파라미터에 사용되는 방법 --%>
 	<h2> form를 이용한 파라미터 전송 </h2>
 	<form method="post" action="ex40_result.jsp">
 		<fieldset>
 			<legend> submit을 이용한 데이터 전송 </legend>
 			<%-- required 필수사항 체크 --%>
 			<p>* 이름 : <input type="text" name="name" required></p>
 			<p> 나이 : <input type="number" name="age" ></p>
 			<p>* 주소 : <input type="text" name="addr" required></p>
 			<p>성별 : <input type="radio" name="gender" value="남성">남성
 			          <input type="radio" name="gender" value="여성">여성
 			</p> 
 			<p>취미 : <input type="checkbox" name="hobby" value="운동">운동
 			          <input type="checkbox" name="hobby" value="영화">영화
 			          <input type="checkbox" name="hobby" value="게임">게임
 			          <input type="checkbox" name="hobby" value="독서">독서
 			</p>
 			<input type="submit" value="회원가입" >
 		</fieldset>
 	</form>
 	<hr>
 	<form method="post" >
 		<fieldset>
 			<legend> JavaScript 데이터 전송 </legend>
 			<%-- JavaScript는 required가 적용 되지 않는다.  --%>
 			<p>* 이름 : <input type="text" name="name"></p>
 			<p> 나이 : <input type="number" name="age"></p>
 			<p>* 주소 : <input type="text" name="addr"></p>
 			<p>성별 : <input type="radio" name="gender" value="남성">남성
 			          <input type="radio" name="gender" value="여성">여성
 			</p> 
 			<p>취미 : <input type="checkbox" name="hobby" value="운동">운동
 			          <input type="checkbox" name="hobby" value="영화">영화
 			          <input type="checkbox" name="hobby" value="게임">게임
 			          <input type="checkbox" name="hobby" value="독서">독서
 			</p>
 			<input type="button" value="회원가입" onclick="send_go(this.form)" >
 		</fieldset>
 	</form>
</body>
</html>








