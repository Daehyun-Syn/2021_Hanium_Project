<%@page import="poly.util.CmmUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    
    String msg = CmmUtil.nvl((String)request.getAttribute("msg"));
	String url = CmmUtil.nvl((String)request.getAttribute("url"));
    
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
let msg = '<%=msg%>';
if(msg=='') { 
	location.href = "<%=url %>"
} else { 
	location.href = "<%=url %>"
	alert("<%=msg %>")
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>redirect</title>
</head>
<body>
</body>
</html>