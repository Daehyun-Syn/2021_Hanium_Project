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
	alert('The post has been deleted.')
	document.location.href="/community/boardlist.do"
	</script>

<% 
} else{
%>
	<script>
	alert('The deletion request failed.Please contact the manager.')
	document.location.href="/community/boardlist.do"
	</script>
<%
}
%>	

</body>
</html>