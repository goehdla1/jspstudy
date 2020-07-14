<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("utf-8");%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션태그 : useBean</title>
</head>
<body>
	<%-- 자바에서 VO vo = new VO(); 같은 효과 --%>
	<jsp:useBean id="vo" class="com.ict.edu.VO" />
	
	<%-- 파라미터값들이 vo와 이름 같으면 setter 호출해서
	     파라미터값을 저장시킨다. 
	     name="vo"는 vo는 useBean id를 말한다.--%>
	<jsp:setProperty property="*" name="vo"/>
	
	<h2> 파리미터값 표시하기 </h2>
	<h3>
		<ul>
			<li> 이름 : <jsp:getProperty property="name" name="vo"/> </li>
			<li> 나이 : <jsp:getProperty property="age" name="vo"/>  </li>
			<li> 주소 : <%=vo.getAddr() %> </li>
			<li> 성별 : <%=vo.getGender() %> </li>
			<li> 취미 : <% for(String k : vo.getHobby()){%>
							 <%=k %>&nbsp;&nbsp; 
			            <%}%>
			</li>
			
			<li> 거주지 : <%=vo.getResidence() %> </li>
			<li> 반려동물 : <%for(String k : vo.getAnimal()){
							out.println(k+"&nbsp;&nbsp;");	
			            }%>
			</li>
			<li>cPage : <%=vo.getcPage() %> </li>
		</ul>
	</h3>
</body>
</html>










