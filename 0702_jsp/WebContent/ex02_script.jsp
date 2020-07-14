<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
	스크립트 요소 : 1.선언부 2.스크립트릿 3.표현식
	1. 선언부 
		- 전역변수 선언과 메소드 선언을 할 때 사용.
		- <%! 자바코드 %>
	2. 스크립트릿
		- 순수 자바코드를 작성(실행)할 때 사용.
		- <% 자바코드 %>
	3. 표현식
		- 변수값을 출력할 때
		- 메소드 결과를 출력할 때
		- 나중에 El 이나 JSTl이 대신 사용 된다.
		- <%= %>
		
		** 위 3요소는 겹처서 사용할 수 없다. , 반드시 별도로 사용해야 된다.
 --%>

	<h2>1-10까지 출력하기.</h2>
	<%
		for (int i = 0; i < 11; i++) {

		// 콘솔에 출력하는 것이 아니므로 주석처리 .
		// System.out.println(i);
		// 웹 브라우저에 출력하기 위한 내장 객체 out 존재.

		out.println("<h4>" + i + "</h4>");
	}
	%>
	<hr>
	<h2>0-10 까지 출력하기, 합도 출력하기.</h2>
	<%
		int sum = 0;
	for (int i = 0; i < 11; i++) {
		out.println(i);
		sum = sum + i;
	}
	out.println(sum);
	%>
	<hr>
	<%
		int k = 0;
	%>
	<%
		for (int i = 0; i < 11; i++) {
		out.println(i);
		k = k + i;
	}
	%>
	<p>
		결과:
		<%=k%></p>
	<hr>
	<%!int res = 0;

	// 더하기 메소드 : void X
	public int add(int su1, int su2) {
		return su1 + su2;
	}

	// 빼기 메소드 : void O
	public void sub(int su1, int su2) {
		res = su1 - su2;
	}%>
	<p>
		7 + 5 =
		<%=add(7, 5)%>
	</p>
	<%
		sub(7, 5); // sub은 void라서 리턴이 되지 않는다. 그래서 따로 메소드를 실행 시켜줘야 한다.
	%>
	<p>
		7 - 5 =
		<%=res%> <%-- 실행시킨 메소드에 대한 결과값  --%>
	</p>
	<hr>
	
	<h2> 오늘 날짜와 운수 출력하기 </h2>
	<%
	Calendar now = Calendar.getInstance();
	int year = now.get(Calendar.YEAR);
	int month = now.get(Calendar.MONTH)+1;
	int day = now.get(Calendar.DATE);
	int lucky = (int)(Math.random()*101);
	%>
	
	<p> 오늘의 날짜 : <%= year %> 년 <%= month %>월 <%= day %>일 </p>
	<p> 오늘의 운세 : <%= lucky %> %</p>
</body>
</html>