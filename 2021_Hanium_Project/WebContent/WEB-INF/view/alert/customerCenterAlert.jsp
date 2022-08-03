<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="poly.util.CmmUtil" %>
<%
String jspRes = CmmUtil.nvl((String)request.getAttribute("res"), "0");
 %>
    
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>AllForYou</title>

</head>
<body>
<% 
if (jspRes.equals("1")){
%>		
	<script>
	alert("I've received an inquiry.\nThe manager will review it and reply kindly.")
	document.location.href="/index.do"
	</script>

<% 
} else{
%>
	<script>
	alert('You failed to send the inquiry.')
	document.location.href="/index.do"
	</script>
<%
}
%>	

</div>

</body>
</html>
