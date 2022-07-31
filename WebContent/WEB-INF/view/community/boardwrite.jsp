<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="poly.dto.ProjectsDTO"%>    
<%@ page import="poly.util.CmmUtil" %>
<!DOCTYPE html>
<html>
<% 
   ProjectsDTO rDTO = (ProjectsDTO)session.getAttribute("rDTO");
   String user_name = CmmUtil.nvl((String)rDTO.getUser_name()); 
   String user_id = CmmUtil.nvl((String)session.getAttribute("id"));    
%>
<head>
<script src="https://translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
<script type="text/javascript">
	function googleTranslateElementInit() {new google.translate.TranslateElement({pageLanguage: 'en', includedLanguages : 'ko,en,ja,es,fr,zh-CN,ru,de,pt', layout: google.translate.TranslateElement.InlineLayout.SIMPLE}, 'google_translate_element');}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
   integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
   crossorigin="anonymous"></script>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
   href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
   integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
   crossorigin="anonymous">
   <link rel="stylesheet" href="/resource/css/style.css">
<title>board</title>
<script>
   $(document).on('click', '#btnSave', function(e) {
      e.preventDefault();
      $("#form").submit();
   });
   $(document).on('click', '#btnList', function(e) {
      e.preventDefault();
      location.href = "${pageContext.request.contextPath}community/boardlist.do";
   });
</script>

<style>
body {
   padding-top: 70px;
   padding-bottom: 30px;
}
</style>

</head>
<body>
   <a href="/index.do"><img src="/resource/img/logo.png" class="img_size"
      alt="올포유 로고" /></a>
   <br>
   <br>

   <article>

      <div class="container" role="main">

         <h2 align="center">Write a post</h2>
	<div id="google_translate_element"></div>
         <form name="form" id="form" role="form" method="post"
            action="${pageContext.request.contextPath}/community/boardwrite/logic.do">

            <div class="mb-3">

               <label for="title">Title</label> <input type="text"
                  class="form-control" name="BOARD_TITLE" id="title"
                  placeholder="Please enter the title.">

            </div>



            <div class="mb-3">

               <label for="reg_id">Writer</label> <input type="text"
                  class="form-control" name="BOARD_WRITER" id="reg_id"
                  value=<%=user_name%> readonly>
                  
                  <input type ="hidden" value=<%=user_id%> name="id">

            </div>



            <div class="mb-3">

               <label for="content">Content</label>

               <textarea class="form-control" rows="5" name="BOARD_CONTENTS" id="content"
                  placeholder="Please enter the contents."></textarea>

            </div>



         </form>

         <div>
            <button type="button" onclick="location.href='/community/boardlist.do'" class="btn btn-sm btn-primary button_color">Back</button>
            <button type="button" class="btn btn-sm btn-primary button_color" id="btnSave">Register</button>

         </div>

      </div>

   </article>
</body>
</html>