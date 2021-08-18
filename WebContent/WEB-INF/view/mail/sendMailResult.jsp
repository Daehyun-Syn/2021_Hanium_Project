<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="poly.util.CmmUtil" %>
<%
String jspRes = CmmUtil.nvl((String)request.getAttribute("res"), "0");

String toMail = CmmUtil.nvl(request.getParameter("toMail"));
String title = CmmUtil.nvl(request.getParameter("title"));
String contents = CmmUtil.nvl(request.getParameter("contents"));

 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메일 발송 결과 보기</title>
</head>
<body>
<% 
if (jspRes.equals("1")){
%>		
	<script>
	alert('I sent a temporary password to <%=toMail%>')
	document.location.href="/user/login.do"
	</script>

<% 
} else{
%>
	<script>
	alert('Temporary password sending to <%=toMail%> failed.')
	document.location.href="/user/login.do"
	</script>
<%
}
%>	
</body>
</html>