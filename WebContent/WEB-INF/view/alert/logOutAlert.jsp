<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<% 
String user_name = (String)session.getAttribute("name"); 	
%>
<head>
<meta charset="UTF-8">
<title>AllForYou</title>
</head>
<body>

<script>
alert('The logout was successful.')
document.location.href="/user/login.do"
</script>

</body>
</html>