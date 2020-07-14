<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>html 주석과 jsp 내용 및 주석</title>
</head>
<body>
	<!-- html 주석 : 소스보기에서 내용이 보인다. -->
	<%--jsp 주석 : 소시보기에서 내용이 보이지 않는다. --%>
	<%--
	JSP : Java Server Page
		  HTML안에서 자바코드를 사용할 때 사용한다.
	JSP의 구성 요소
		- 지시어 (디렉티브) : <%@      %>
		- 선언부            : <%!      %>
		- 스크립트릿        : <%       %>
		- 표현식            : <%=      %>
		
	1. 지시어(디렉티브) : page , include , taglib
	   표현방법 : <%@ 지시어 종류 %>
	   1) page 지시어 : 보통 해당 문서의 맨 앞에 사용
	   					JSP 페이지에 대한 정보를 입력하기 위해서 사용
	   					** 현재 JSP 페이지에 대한 정보를 지정
	   					** 톰켓이 해당 page지시어를 보고, 해당 페이지를 어떻게 해석할지 판단하는 정보가 된다.
	   					** 보통 이클립스에서는 자동으로 만들어 준다.
	   2) page 지시어 속성들
	   		- language : 스크립트 코드에 사용되는 언어.
	   		- contentType : 문서 타입과 문자셋 지정.(캐릭터 인코딩 지정)
	   			인코딩(부호화=암호화) : 정보의 형태를 변환하여 처리
	   			디코딩(복호화) 		  : 변환된 정보를 원래 형태로 되돌리는 것
	   		- pageEncoding : 해당문서를 UTF-8 형태로 변환해서 처리 한다.
	   		- session : 세션 여부 사용(기본값:true)
	   		 == session : 사용자 정보를 서버측에서 저장하고 관리하는 공간을 말한다.
	   					  생명주기는 웹 브라우저가 종료 될때 까지(로그인처리할때 사용)
	   					  예외) 은행 로그인 (정해진 시간이 되면 자동으로 로그아웃) - session 정보가 날아간다.
	   		- buffer : 출력버퍼의 크기 지정 (기본값:8kb)
	   		- autoFlush : 버퍼의 내용을 자동으로 출력 시켜준다.
	   		- errorPage : 오류 페이지를 지정 / 가는쪽
	   		- isErrorPage : 해당 페이지가 오류 페이지이면 true , 기본값 : false / 받는쪽 - 오류난 페이지를 처리해준다.
	   	3) include 지시어 : 특정 영역에 다른 문서를 포함시킬 때 사용.
	   						지정한 문서의 소스를 복사하여 현재 문서에 붙여넣는 것과 같음 
	   						** html의 iframe과 비슷하다.
	   						차후에 JSTL 배울 때 사용할 것이다.!
	   	4) taglib 지시어 : 해당 페이지에서 사용할 태그 라이브러리를 지정한다. / 차후에 배울게요^^
 --%>
</body>
</html>