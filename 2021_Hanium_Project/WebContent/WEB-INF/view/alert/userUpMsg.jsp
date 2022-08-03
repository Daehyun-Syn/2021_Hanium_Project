<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="poly.util.CmmUtil"%>
<%
	//Controller로 부터 전달받은 데이터
	String msg = CmmUtil.nvl((String) request.getAttribute("msg"));
	String res = CmmUtil.nvl((String)request.getAttribute("res"), "0");
	String allergy = CmmUtil.nvl((String)request.getAttribute("allergy"));
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AllForYou</title>
</head>
<body>

<% 
if (res.equals("1")){
%>		
	<script>
	alert('<%=msg%> \nThe changed allergy information is :  <%=allergy%> .');
	document.location.href="/index.do"
	</script>
<% 
} else{
%>
	<script>
	alert('<%=msg%>');
	document.location.href="/index.do"
	</script>
<%
}
%>

</body>
</html>