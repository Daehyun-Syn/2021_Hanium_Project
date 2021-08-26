<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="poly.dto.ProjectsDTO"%>    
<%@ page import="poly.util.CmmUtil" %>
<!DOCTYPE html>
<html>
<% 
   String user_name = CmmUtil.nvl((String)session.getAttribute("id"));    
%>

<head>

<script src="https://translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
<script type="text/javascript">
	function googleTranslateElementInit() {new google.translate.TranslateElement({pageLanguage: 'en', includedLanguages : 'ko,en,ja,es,fr,zh-CN,ru,de,pt', layout: google.translate.TranslateElement.InlineLayout.SIMPLE}, 'google_translate_element');}
</script>
<meta charset="UTF-8">
<title>AII FOR YOU</title>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
   integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
   crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script><!-- 항상 최신버전의 JQuery를 사용가능하다. -->
   
<!-- Bootstrap CSS -->
<link rel="stylesheet"
   href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
   integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
   crossorigin="anonymous">
   <link rel="stylesheet" href="/resource/css/style.css">
   

<title>Customer Center</title>

<style type = "text/css">
body {
   padding-top: 70px;
   padding-bottom: 30px;
}
<pre><c:out value="${content}" /></pre>
</style>

</head>
<body>


   <a href="/index.do"><img src="/resource/img/logo.png" class="img_size"
      alt="올포유 로고" /></a>
   <br>
   <br>

   <article>


      <div class="container" role="main">

         <h2 align="center">CUSTOMER CENTER</h2>
<div id="google_translate_element"></div>
         <form name="form" id="form" role="form" method="post"
            action="/customerCenter/csCenterMails.do">

            <div class="mb-3">

               <label for="title">Title</label> <input type="text"
                  class="form-control" name="title" id="title"
                  placeholder="Please enter the title.">

            </div>

            <div class="mb-3">

               <label for="reg_id">Caution</label> <input type="text"
                  class="form-control" id="reg_id"
                  placeholder="Please make sure to fill out the form." readonly>

            </div>

            <div class="mb-3">

               <label for="content">Content</label>

               <textarea class="form-control" rows="7" name="contents" id="content">
               
name : 
cellphone : 
email : 

content : 
</textarea>

            </div>


            <button type="submit" class="btn btn-sm btn-primary button_color" id="trans">ASK</button>
<button type="button" onclick="location.href='/contact/contact.do'" class="btn btn-sm btn-primary button_color">BACK</button>
         </form>

      </div>

   </article>
</body>
</html>