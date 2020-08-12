<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	function createRequest() {
		var req;
		try {
			req = new XMLHttpRequest();
		} catch (e) {
			try {
				 req = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				req = new ActiveXObject("Msxml3.XMLHTTP");
			}
		}
		return req ;
		
	}
	var request = new createRequest();
	
	request.open("GET","data02.xml", false);
	
	request.onreadystatechange = function() {
		if (request.readyState == 4 && request.status == 200) {
			
			var data = request.responseXML;
			
			var product = data.getElementsByTagName("product");
			
			for (var i = 0; i < array.length; i++) {
				var name = puroduct[i].attributes[0].value;
				var price = product[i].attributes[1].values;
				document.body.innderHTML += "<h2><li>"+name+","+price+"</li></h2>";
			}
			
			
			
		}
	}
	request.send();
	
</script>

</body>
</html>