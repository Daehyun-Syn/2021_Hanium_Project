<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<div id="google_translate_element"></div>
<script src="https://translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
<script type="text/javascript">
	function googleTranslateElementInit() {new google.translate.TranslateElement({pageLanguage: 'ko',autoDisplay: false}, 'google_translate_element');}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
안녕하세요! 김동협은 여자친구가 생길 예정입니다.
<form action="/resultProc.do">
<input type ="text" name= "search" id="search"></input>
<input type ="submit"></input>
</form>

</body>
</html>