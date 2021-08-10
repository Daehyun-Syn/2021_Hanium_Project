<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="poly.util.CmmUtil" %>
<%@ page import="poly.dto.ProjectsDTO" %>
<%
//Controller로 부터 전달받은 데이터
String msg = CmmUtil.nvl((String)request.getAttribute("msg"));
//Controller로부터 전달받은 웹(회원정보 입력화면)으로부터 입력받은 데이터(회원아이디, 이름, 이메일, 주소 등)
ProjectsDTO uDTO = (ProjectsDTO)request.getAttribute("uDTO");
if (uDTO==null){
	uDTO= new ProjectsDTO();
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AllForYou</title>
<script type="text/javascript">
   alert("<%=msg%>");
   document.location.href="/user/login.do"
</script>
</head>
<body>

</body>
</html>