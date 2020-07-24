<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#bbs table {
	    width:800px;
	    margin:0 auto;
	    margin-top:20px;
	    border:1px solid black;
	    border-collapse:collapse;
	    font-size:14px;
	    
	}
	
	#bbs table caption {
	    font-size:20px;
	    font-weight:bold;
	    margin-bottom:10px;
	}
	
	#bbs table th {
	    text-align:center;
	    border:1px solid black;
	    padding:4px 10px;
	}
	
	#bbs table td {
	    text-align:left;
	    border:1px solid black;
	    padding:4px 10px;
	}
	
	.no {width:15%}
	.subject {width:30%}
	.writer {width:20%}
	.reg {width:20%}
	.hit {width:15%}
	.title{background:lightsteelblue}
	.odd {background:silver}
</style>
<script type="text/javascript">
	function list_go(f) {
		f.action = "/MyController?cmd=list";
		f.submit();
	}
	function update_go(f) {
		f.action = "/MyController?cmd=update";
		f.submit();
	}
	function delete_go(f) {
		f.action = "/MyController?cmd=delete";
		f.submit();
	}
</script>
</head>
<body>
	<div id="bbs">
	<form method="post">
		<table summary="게시판 글쓰기">
			<caption>게시판 글쓰기</caption>
			<tbody>
				<tr>
					<th>제목:</th>
					<td> ${bvo.subject}</td>
				</tr>
				<tr>
					<th>이름:</th>
					<td> ${bvo.writer }</td>
				</tr>
				<tr>
					<th>내용:</th>
					<td>
						 <script src="https://cdn.ckeditor.com/4.14.1/standard/ckeditor.js"></script>
						 <textarea name="content" readonly><pre>${bvo.content}</pre></textarea>
                		 <script>
                        	CKEDITOR.replace('content');
                		</script>
					</td>
				</tr>
				<tr>
					<th>첨부파일:</th>
						<c:choose>
							<c:when test="${empty bvo.file_name}">
								<td><b> 첨부파일 없음 </b></td>
							</c:when>
							<c:otherwise>
								<td>
									<img alt="" src="upload/${bvo.file_name}" style="width: 100px"><br>
									<a href="view/download.jsp?path=upload&file_name=${bvo.file_name}">${bvo.file_name}</a>
								</td>
							</c:otherwise>
						</c:choose>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" value="수정" onclick="update_go(this.form)">
						<input type="button" value="삭제" onclick="delete_go(this.form)">
						<input type="button" value="목록" onclick="list_go(this.form)">
					</td>
				</tr>
			</tbody>
		</table>
		</form>
	</div>
</body>
</html>

