<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="static poly.util.CmmUtil.nvl"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="poly.dto.ProjectsDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.text.*"%>

<%
	DecimalFormat format = new DecimalFormat("0");
%>

<!DOCTYPE html>
<html lang="en">
<!-- 컨토롤러에서 실행된 로직들의 결과값을 가져온다 == rlist에 담아진 값들  -->
<%
	List<ProjectsDTO> rList = (List<ProjectsDTO>) request.getAttribute("rList");
%>
<head>
<script src="https://translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
<script type="text/javascript">
	function googleTranslateElementInit() {new google.translate.TranslateElement({pageLanguage: 'en', includedLanguages : 'ko,en,ja,es,fr,zh-CN,ru,de,pt', layout: google.translate.TranslateElement.InlineLayout.SIMPLE}, 'google_translate_element');}
</script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Community</title>
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
		<h2>
			<a href="/index.do"><img src="/resource/img/logo.png"
				class="img_size2" alt="올포유 로고"></a>
		</h2>
		<h2 class="h2_seat">
		
			<code class="h2_seat_color">Community</code>
		</h2>
		<div id="google_translate_element"></div>
		<table class="table table-striped">
			<thead class="thead_color">
				<tr>
					<th>Writing number</th>
					<th>Title</th>
					<th>Writer</th>
					<th>Date</th>
				</tr>
			</thead>
			<tbody>
				<!-- rList안의 ProjectsDTO가 p에 순차적으로 대입되며 실행되는 for문 -->
				<%
					for (ProjectsDTO p : rList) {
				%>
				<tr
					onclick="location.href='/community/boardsee.do?number=<%=p.getBoard_seq()%>'">
					<td><%=format.format(Double.parseDouble(p.getRownum()))%></td>
					<td><%=p.getBoard_title()%></td>
					<td><%=p.getBoard_writer()%></td>
					<td><%=p.getBoard_regdate()%></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>

		<div class="div_button">

			<button type="button"
				onclick="location.href='/community/boardwrite.do' "
				class="btn button_FA6862 button_FA6862_seat">WRITE</button>
			<button type="button" onclick="location.href='/index.do' "
				class="btn button_FA6862 button_FA6862_seat"
				style="width: 120px; margin-right: 10px;">BACK</button>
		</div>

	</div>
	<div style="display: block; text-align: center;">
		<c:if test="${paging.startPage != 1 }">
			<a
				href="/community/boardlist.do?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">&lt;</a>
		</c:if>
		<c:forEach begin="${paging.startPage }" end="${paging.endPage }"
			var="p">
			<c:choose>
				<c:when test="${p == paging.nowPage }">
					<b>${p }</b>
				</c:when>
				<c:when test="${p != paging.nowPage }">
					<a
						href="/community/boardlist.do?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
				</c:when>
			</c:choose>
		</c:forEach>
		<c:if test="${paging.endPage != paging.lastPage}">
			<a
				href="/community/boardlist.do?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">&gt;</a>
		</c:if>
	</div>
	<br>

</body>
</html>

