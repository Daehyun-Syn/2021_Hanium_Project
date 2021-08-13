<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="">
<head>

<script type="text/javascript">
   //회원가입 정보의 유효성 체크하기
   function doRegUserCheck(f){
      if(f.id.value==""){
         alert("Please enter your ID");
         f.id.focus();
         return false;
      }if(f.name.value==""){
         alert("Please enter your Name");
         f.name.focus();
         return false;
      }if(f.pwd.value==""){
         alert("Please enter your PW");
         f.pwd.focus();
         return false;
      }if(f.year.value=="year"){
         alert("Date of birth: Enter the year of birth.");
         f.year.focus();
         return false;
      }if(f.month.value=="month"){
          alert("Date of birth: Enter the month of birth.");
          f.month.focus();
          return false;
    }if(f.date.value=="date"){
        alert("Date of birth: Enter your date of birth.");
        f.date.focus();
        return false;
    }if(f.lang.value=="language"){
       alert("Please enter the language you use.");
       f.lang.focus();
       return false;
   }
   }
 
</script>
<!-- meta charset -->
<meta charset="utf-8">
<!-- site title -->
<title>AII FOR YOU</title>
<!-- meta description -->
<meta name="description" content="">
<!-- mobile viwport meta -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- fevicon -->
<link rel="shortcut icon" type="image/x-icon"
   href="/resource/favicon.ico">

<!-- ================================
        CSS Files
        ================================= -->
<link
   href="https://fonts.googleapis.com/css?family=Libre+Baskerville:400,400i|Open+Sans:400,600,700,800"
   rel="stylesheet">
<link rel="stylesheet" href="/resource/css/themefisher-fonts.min.css">
<link rel="stylesheet" href="/resource/css/bootstrap.min.css">
<link rel="stylesheet" href="/resource/css/main.css">
<link rel="stylesheet" href="/resource/css/style.css">
<link id="color-changer" rel="stylesheet"
   href="/resource/css/colors/color-0.css">
</head>

<body>
<script src="https://translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
<script type="text/javascript">
	function googleTranslateElementInit() {new google.translate.TranslateElement({pageLanguage: 'en', includedLanguages : 'ko,en,ja,es,fr,zh-CN,ru,de,pt', layout: google.translate.TranslateElement.InlineLayout.SIMPLE}, 'google_translate_element');}
</script>

   <div class="preloader">
      <div class="loading-mask"></div>
      <div class="loading-mask"></div>
      <div class="loading-mask"></div>
      <div class="loading-mask"></div>
      <div class="loading-mask"></div>
   </div>

 

   <main class="site-wrapper">
      <div class="pt-table">
         <div class="pt-tablecell page-contact relative">
            <!-- .close -->
            <a href="./" class="page-close"><i class="tf-ion-close"></i></a>
            <!-- /.close -->

            <div class="container">
               <div class="row">
                  <div
                     class="col-xs-12 col-md-offset-1 col-md-10 col-lg-offset-2 col-lg-8 ">
                     <div class="page-title text-center login_imgbiv clearing_gap">
                        <h2>
                           <a href="/index.do"><img src="/resource/img/logorm.png" class="login_logo"></a>
                           <!--<h2>All <span class="primary">for you</span><span class="title-bg">Welcome</span>-->
                        </h2>
                        <p>
                           Please sign up as a member to use the All For You service.<br> For you, for safe food, ALL FOR YOU
                        </p>
                     </div>
                  </div>
          
               </div>
               <!-- /.row -->

               <div class="row">

                  <div
                     class="col-xs-12 col-sm-7 col-md-7 col-md-offset-1 col-lg-offset-2 login_box">
                     <div class="section-title clear">
                             <div id="google_translate_element"></div>
                        <h3>Sign up</h3>
                        <span class="bar-dark"></span> <span class="bar-primary"></span>
                     </div>
                     <form name ="f" method ="post" action="/user/user/join.do" onsubmit="return doRegUserCheck(this);">
                        <div id="contact-form" class="row contact-form no-gutter">
                           <!-- <div class="col-xs-12 col-sm-6">
                                        <div class="input-field name">
                                            <span class="input-icon" id="name" ><i class="tf-profile-male"></i></span>
                                            <input type="text" class="form-control"  placeholder="Enter your name">
                                        </div>
                                    </div> -- ./col- -->
                           <div class="col-xs-12 col-sm-6 email_length">
                              <div class="input-field email">
                                 <span class="input-icon" id="email"><i
                                    class="tf-envelope2"></i></span> <input type="email"
                                    class="form-control" name="id"
                                    placeholder="Please enter the email you want to use.">
                              </div>
                           </div>
                           <!-- ./col- -->
                           <div class="col-xs-12 col-sm-12">
                              <div class="input-field">
                                 <span class="input-icon" id="subject"><i
                                    class="tf-ion-android-unlock"></i></span> <input type="password"
                                    class="form-control" name="pwd"
                                    placeholder="Please enter the password you want to use.">
                              </div>
                           </div>


                           <!-- ./col- -->
                           <div class="col-xs-12 col-sm-12">
                              <div class="input-field">
                                 <span class="input-icon" id="subject"><i
                                    class="tf-ion-person"></i></span> <input type=""
                                    class="form-control" name="name" placeholder="Please type your name.">
                              </div>
                           </div>
                           <!-- ./col- -->
                           <div class="col-xs-12 col-sm-12">
                              <div class="input-field message">
                                 <div class="check_styl">
                                    <p>My allergy (Multiple choices)</p>
                                    <input type="checkbox" name="allergy1" value="Crustacean"> Crustacean
                                    <input type="checkbox" name="allergy2" value="Egg"> Egg
                                    <input type="checkbox" name="allergy3" value="Peanut"> Peanut
                                    <input type="checkbox" name="allergy4" value="Wheat"> Wheat
                                    <input type="checkbox" name="allergy5" value="Fish"> Fish
                                    <input type="checkbox" name="allergy6" value="Milk"> Milk
                                    <input type="checkbox" name="allergy7" value="Clam"> Clam
                                    <input type="checkbox" name="allergy8" value="Bean"> Bean
                                    
                                 </div>
                              </div>
                           </div>
                           <div class="col-xs-12 col-sm-12">
                              <div class="input-field message">
                                 <div class="check_styl check_styl2">
                                    <p>
                                       <span>Gender</span> <input type="radio" name="gender"
                                          value="man" checked> man <input type="radio"
                                          name="gender" value="woman" class="input_style">
                                       woman
                                    </p>

                                 </div>
                              </div>
                           </div>
                           <div class="col-xs-12 col-sm-12">
                              <div class="input-field message">
                                 <div class="check_styl check_styl2">
                                    <p>
                                       <span>Date of birth</span> <select name="year"
                                          class="check_styl2_child">
                                          <option value="year">year</option>
                                          <option value="1985">1985</option>
                                          <option value="1986">1986</option>
                                          <option value="1987">1987</option>
                                          <option value="1988">1988</option>
                                          <option value="1989">1989</option>
                                          <option value="1990">1990</option>
                                          <option value="1991">1991</option>
                                          <option value="1992">1992</option>
                                          <option value="1993">1993</option>
                                          <option value="1994">1994</option>
                                          <option value="1995">1995</option>
                                          <option value="1996">1996</option>
                                          <option value="1997">1997</option>
                                          <option value="1998">1998</option>
                                          <option value="1999">1999</option>
                                          <option value="2000">2000</option>
                                          <option value="2001">2001</option>
                                          <option value="2002">2002</option>
                                          <option value="2003">2003</option>
                                       </select> <select name="month">
                                          <option value="month">month</option>
                                          <option value="01">1</option>
                                          <option value="02">2</option>
                                          <option value="03">3</option>
                                          <option value="04">4</option>
                                          <option value="05">5</option>
                                          <option value="06">6</option>
                                          <option value="07">7</option>
                                          <option value="08">8</option>
                                          <option value="09">9</option>
                                          <option value="10">10</option>
                                          <option value="11">11</option>
                                          <option value="12">12</option>

                                       </select> <select name="date">
                                          <option value="date">date</option>
                                          <option value="01">1</option>
                                          <option value="02">2</option>
                                          <option value="03">3</option>
                                          <option value="04">4</option>
                                          <option value="05">5</option>
                                          <option value="06">6</option>
                                          <option value="07">7</option>
                                          <option value="08">8</option>
                                          <option value="09">9</option>
                                          <option value="10">10</option>
                                          <option value="11">11</option>
                                          <option value="12">12</option>
                                          <option value="13">13</option>
                                          <option value="14">14</option>
                                          <option value="15">15</option>
                                          <option value="16">16</option>
                                          <option value="17">17</option>
                                          <option value="18">18</option>
                                          <option value="19">19</option>
                                          <option value="20">20</option>
                                          <option value="21">21</option>
                                          <option value="22">22</option>
                                          <option value="23">23</option>
                                          <option value="24">24</option>
                                          <option value="25">25</option>
                                          <option value="26">26</option>
                                          <option value="27">27</option>
                                          <option value="28">28</option>
                                          <option value="29">29</option>
                                          <option value="30">30</option>
                                          <option value="31">31</option>

                                       </select>
                                    </p>
                                 </div>
                              </div>
                           </div>
                           <div class="col-xs-12 col-sm-12">
                              <div class="input-field message">
                                 <div class="check_styl check_styl2">
                                    <p>
                                       <span>Language</span> <select name="lang"
                                          class="check_styl2_child">
                                          <option value="language">language</option>
                                          <option value="ko">Korean</option>
                                          <option value="en">English</option>
                                          <option value="fr">French</option>
                                          <option value="ja">Japanese</option>
                                          <option value="zh-CN">Chinese</option>
                                          <option value="es">Spanish</option>
                                          <option value="ru">Russian</option>
										  <option value="de">German</option>
										  <option value="pt">Portuguese</option>
										  
                                       </select>
                                    </p>
                                 </div>
                              </div>
                           </div>

                           <!--<div class="col-xs-12 col-sm-12">
                                        <div class="input-field message">
                                            <span class= "input-icon" ><i class="tf-pricetags"></i></span>
                                            <textarea name="message" id="message" class="form-control" placeholder="Write your message"></textarea>
                                        </div>
                                    </div>  ./col- -->

                           <div class="col-xs-12 col-sm-12 ">
                              <div class="input-field div_margin2">
                                 <span class="btn-border email_length">
                                    <button type="submit"
                                       class="btn btn-primary btn-custom-border text-uppercase email_length">Sign up</button>
                                 </span>
                              </div>
                              <!--<div class="msg-success">Your Message was sent successfully</div> 
                              <div class="msg-failed">뭔가 잘못되었어요, 다시 시도해 보세요</div>-->
                           </div>
                        </div>
                        <!-- ./col- -->
                     </form>
                     <!-- /.row -->
                  </div>
                  <!-- /.col- -->
               </div>
               <!-- /.row -->
            </div>
            <!-- /.container -->

            <nav class="page-nav clear">
               <div class="container">
                  <div class="flex flex-middle space-between">
                     <span class="prev-page"><a href="/user/login.do"
                        class="link">&larr; Previous Page</a></span> <span class="copyright hidden-xs">Copyright
                        &copy; 2021 ALL FOR YOU, All Rights Reserved.</span>
                  </div>
               </div>
               <!-- /.page-nav -->
            </nav>
            <!-- /.container -->

         </div>
         <!-- /.pt-tablecell -->
      </div>
      <!-- /.pt-table -->
   </main>
   <!-- /.site-wrapper -->

   <!-- ================================
        JavaScript Libraries
        ================================= -->
   <script src="/resource/js/vendor/jquery-2.2.4.min.js"></script>
   <script src="/resource/js/vendor/bootstrap.min.js"></script>
   <script src="/resource/js/jquery.easing.min.js"></script>
   <script src="/resource/js/isotope.pkgd.min.js"></script>
   <script src="/resource/js/jquery.nicescroll.min.js"></script>
   <script src="/resource/js/owl.carousel.min.js"></script>
   <script src="/resource/js/jquery-validation.min.js"></script>
   <script src="/resource/js/form.min.js"></script>
   <script src="/resource/js/main.js"></script>
</body>
</html>