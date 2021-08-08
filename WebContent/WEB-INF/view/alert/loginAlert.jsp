<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="poly.util.CmmUtil" %>
<!DOCTYPE html>
<html>
<% 
String user_name = (String)session.getAttribute("id"); 
String jspRes = CmmUtil.nvl((String)request.getAttribute("res"), "0");
%>
<head>
<meta charset="UTF-8">
<title>AllForYou</title>
</head>
<body>

<% 
if (jspRes.equals("1")){
%>		
	<script>
	alert('<%=user_name%> , you succeeded in logging in.')
	document.location.href="/index.do"
	</script>

<% 
} else{
%>
	<script>
	alert('Login failed. Please check the ID and PW again.')
	document.location.href="/user/login.do"
	</script>
<%
}
%>
</body>
</html>