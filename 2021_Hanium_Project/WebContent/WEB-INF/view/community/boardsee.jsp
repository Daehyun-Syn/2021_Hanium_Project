<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="poly.dto.ProjectsDTO"%>
<!DOCTYPE html>

<%
	ProjectsDTO pDTO = (ProjectsDTO)request.getAttribute("rDTO");
	String user_id = (String)session.getAttribute("id");
%>

<html lang="en">
<head>
<style>	
	h2{
		font-weight: bolder
	}
</style>
<script src="https://translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
<script type="text/javascript">
	function googleTranslateElementInit() {new google.translate.TranslateElement({pageLanguage: 'en', includedLanguages : 'ko,en,ja,es,fr,zh-CN,ru,de,pt', layout: google.translate.TranslateElement.InlineLayout.SIMPLE}, 'google_translate_element');}
</script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Post Details</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="/resource/css/style.css">
</head>
<body>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<div class="container">
		<h2><a href="/index.do"><img src="/resource/img/logo.png" class="img_size2"
		alt="올포유 로고"></a></h2>
		<h2 class="h2_seat">
			<code class="h2_seat_color">Community</code>
		</h2>
		
<div id="google_translate_element"></div>
		<table class="table table-striped table_reading">
			<thead class="thead_color ">
				<tr>
					<th class="thead_th">Title :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <%=pDTO.getBoard_title()%></th>
					<th class="thead_th">Writer : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <%=pDTO.getBoard_writer()%></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="2"><%=pDTO.getBoard_contents()%></td>
				</tr>
			</tbody>
		</table>
		<div class="div_button">
		
		<% if(user_id.equals(pDTO.getUser_id())) {%>
		<button type="button" class="btn button_FA6862 button_FA6862_seat" onclick="location.href='/community/boardupdate.do?number=<%=pDTO.getBoard_seq()%>'">MODIFY</button>
		<button type="button" class="btn button_FA6862 button_FA6862_seat" onclick="location.href='/community/boarddelete.do?number=<%=pDTO.getBoard_seq()%>'" style="margin-right:10px;">DELETE</button>
		<%} %>
		<button type="button"
				onclick="location.href='/index.do'"
				class="btn button_FA6862 button_FA6862_seat" style="width:120px; margin-right: 10px;">BACK</button>
		</div>
</body>
</html>


