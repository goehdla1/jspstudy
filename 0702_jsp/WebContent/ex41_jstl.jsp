<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL : JSP 표준 태그 라이브러리(core) </title>
</head>
<body>
<%--
	1. 라이브러리를 다운받아서 해당 프로젝트에게 저장한다.
	   (tomcat.apache.org)
	2. 다운받은 라이브러리를 WEB-INF안에 lib에 넣어주세요
	3. page지시어 및에 taglib 지시어를 통해서 선언하고 사용한다.
	  선언 방법
	  <%@ taglib prefix="" uri="" %>
	  코어 : <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
	  국제화 : 
	 4. 사용방법 : <c:명령어> </c:명령어> EL과 함께 사용한다.
 --%>
  <%--
  	 변수 생성(set)    : <c:set var="변수이름" value="데이터" />
  	 변수 출력(out)    : <c:out value="출력할 데이터 or ${변수이름}" />, ${변수이름}
  	 변수 삭제(remove) : <c:remove var="변수이름"/>
   --%>
   <h2>
     <%-- 변수 생성 --%>
     <c:set var="test" value="Hello JSP" />
     
     <%-- 변수데이터 출력 --%>
    <li><c:out value="test" /> </li>    <%-- test --%>
    <li><c:out value="${test}" /></li>  <%-- Hello JSP--%> 
    <li>${test}</li>                    <%-- Hello JSP--%> 
    
    <%-- 변수삭제 후 호출  --%>
    <c:remove var="test"/>
    <li><c:out value="${test}" /></li>  <%-- 안나옴--%> 
    <li>${test}</li>                    <%-- 안나옴--%>
    <hr>
    <%--
        if문의 특징 : else가 없다. 조건이 참이 아니면 if문 무시
    	<c:if test="조건식(관계연산,비교연산)=> EL방식사용" var="변수명">
            조건이 참이면 실행할 내용;
         </c:if> 
     --%>
    <c:if test="${5<4}">
      <li>Hello JSP World </li>
    </c:if>
    <c:if test="${5>4}">
      <li>Hello Web World </li>
    </c:if>
    <%-- sum의 점수가 90이상이면 합격 아니면 불합격 --%>
    <c:set var="sum" value="95" />
    <c:if test="${sum<90}">
     <li>불합격</li>
    </c:if>
    <c:if test="${sum>=90}">
     <li>합격</li>
    </c:if>
    
    <%-- choose문 : switch문과 비슷 (if ~ else를 대신 할 수 있다.) 
    <c:choose>
    	<c:when test="조건식1(EL)">조건1이 참일때 실행</c:when>
    	<c:when test="조건식2(EL)">조건2이 참일때 실행</c:when>
    	<c:when test="조건식3(EL)">조건3이 참일때 실행</c:when>
    	<c:otherwise>위 조건이 다 거짓일 때 실행</c:otherwise>
    </c:choose>
    
    --%>
    <%-- 평균 avg가 90이상이면 A, 80이상이면 B, 70이상이면 C, 나머지 F --%>
    <c:set var="avg" value="64.5" />
    <c:choose>
    	<c:when test="${avg>=90.0}"><li> A학점</li></c:when>
    	<c:when test="${avg>=80.0}"><li> B학점</li></c:when>
    	<c:when test="${avg>=70.0}"><li> C학점</li></c:when>
    	<c:otherwise><li>F학점</li></c:otherwise>
    </c:choose>
    <%--
    	반복문 :  
    	 1. 일반적인 for문 형식
    	<c:forEach begin="시작값" end="끝값" step="증가값" var="변수">
    		반복내용 (EL)
    	</c:forEach>
    	
    	2. 개선된 for문 형식 (배열,리스트에 사용)
    	 <c:forEach  var="" items="${배열,리스트}">반복내용</c:forEach>
     --%>
     
     <%-- 0-10까지 출력 --%>
     <c:forEach begin="0" end="10" step="1" var="k">
      ${k} &nbsp;&nbsp; 
     </c:forEach>
     <hr>
     
     <%-- 0-10까지 짝수만 출력 --%>
     <c:forEach begin="0" end="10" step="1" var="k">
     	<c:if test="${k%2==0}">
     	   ${k}&nbsp;&nbsp;
     	</c:if>
     </c:forEach>
     <hr>
     
     <%-- varStatus => count(1), index() --%>
     <c:forEach begin="20" end="29" step="1" var="k" varStatus="vs">
           ${k}  / ${vs.index}   / ${vs.count} <br>
     </c:forEach>
     <hr>
     
     <%--varStatus => first, last 결과는 boolean --%>
     <c:forEach begin="20" end="29" step="1" var="k" varStatus="vs">
           ${k}  / ${vs.first}   / ${vs.last} <br>
     </c:forEach>
     <hr>
     
	 <%-- 배열저장 --%>    
     <c:set var="arr" value="홍길동, 임꺽정, 장길산, 일지매" />
     
     <%-- 개선된 for문은 배열이나 리스트 처리에 적합 --%>
     <c:forEach var="k" items="${arr}">
     	${k} <br>
     </c:forEach>
     <hr>
     
     <%-- 반복하면서 나누기 
        <c:forTokens items="${배열,리스트}" delims="구분자"></c:forTokens> --%>
   
     <c:set var="arr2" 
     	value="홍길동,임꺽정,장길산/일지매,둘리/고길동,마이콜" />
     
     <c:forTokens var="k" items="${arr2}" delims=",">
     	${k} <br>
     </c:forTokens>
     <hr>
     
     <c:forTokens var="k" items="${arr2}" delims="/">
     	${k} <br>
     </c:forTokens>
     <hr>
     
     <c:forTokens var="k" items="${arr2}" delims="/,">
     	${k} <br>
     </c:forTokens>
     <hr>
     
     <%-- 페이지이동 : redirect
       JSTL에는 redirect는 존재, forward가 없다. 
       jsp액션에는 forward 존재, jsp액션에는 redirect가 없다.
       둘 다 파라미터값을 넘길 수 있다.
       
       <c:redirect url="이동페이지" />
      --%>
     
     <%-- <c:redirect url="ex42_result.jsp" /> --%>
     
     <%-- <jsp:forward page="ex42_result.jsp" /> --%>
     <%--
      <c:redirect url="ex42_result.jsp">
      	<c:param name="name" value="아수라백작" />   
      </c:redirect>
      --%>
      
      <%-- 한글처리  --%>
      <%--
      <%request.setCharacterEncoding("utf-8"); %>
      <jsp:forward page="ex42_result.jsp">
      	<jsp:param value="태권브이" name="name"/>
      </jsp:forward>
       --%>
   </h2>
</body>
</html>











