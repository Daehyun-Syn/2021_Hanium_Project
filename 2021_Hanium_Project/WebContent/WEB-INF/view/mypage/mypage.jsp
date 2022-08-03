<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap" %>
<%@ page import="poly.dto.ProjectsDTO"%>      
<!DOCTYPE html>
<%
   ProjectsDTO pDTO = (ProjectsDTO)session.getAttribute("rDTO");
	HashMap<String,String> hm = (HashMap)request.getAttribute("hm");
%>
<html class="no-js" lang="">
<head>
<script src="https://translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
<script type="text/javascript">
	function googleTranslateElementInit() {new google.translate.TranslateElement({pageLanguage: 'en', includedLanguages : 'ko,ja,es,fr,zh-CN,ru,de,pt', layout: google.translate.TranslateElement.InlineLayout.SIMPLE}, 'google_translate_element');}
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
<link id="color-changer" rel="stylesheet" href="/resource/css/colors/color-0.css">

  <script type="text/javascript">
  

  </script>

</head>

<body>

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
									For you, for safe food, ALL FOR YOU.
									
								</p>
							</div>
						</div>
						
					</div>
					<!-- /.row -->

					<div class="row">

						<div
							class="col-xs-12 col-sm-7 col-md-7 col-md-offset-1 col-lg-offset-2 login_box mid">
							<div class="section-title clear">
							<div id="google_translate_element"></div>
								<h3>My page</h3>
								<span class="bar-dark"></span> <span class="bar-primary"></span>
							</div>
							<form action="/user/userUpdate.do" method="post">
								<div id="contact-form" class="row contact-form no-gutter"
									method="post">
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
												placeholder="ID : <%=pDTO.getUser_id()%>" disabled/>
										</div>
									</div>
									<!-- ./col- -->
									<div class="col-xs-12 col-sm-12">
										<div class="input-field">
											<span class="input-icon" id="subject"><i
												class="tf-ion-person"></i></span> <input type="text"
												class="form-control" name="name" placeholder="NAME : <%=pDTO.getUser_name()%>" disabled/>
										</div>
									</div>
									<!-- ./col- -->
									<div class="col-xs-12 col-sm-12">
										<div class="input-field message">
											<div class="check_styl">
			                                    <p>My allergy (Multiple choices)</p>
			                                    <input type="checkbox" id="갑각류" name="allergy1" value="Crustacean" <%=hm.get("Crustacean")%>> Crustacean
			                                    <input type="checkbox" id="달걀" name="allergy2" value="Egg" <%=hm.get("Egg")%>> Egg
			                                    <input type="checkbox" id="땅콩" name="allergy3" value="Peanut"<%=hm.get("Peanut")%>> Peanut
			                                    <input type="checkbox" id="밀" name="allergy4" value="Wheat" <%=hm.get("Wheat")%>> Wheat
			                                    <input type="checkbox" id="생선" name="allergy5" value="Fish" <%=hm.get("Fish")%>> Fish
			                                    <input type="checkbox" id="우유" name="allergy6" value="Milk" <%=hm.get("Milk")%>> Milk
			                                    <input type="checkbox" id="조개" name="allergy7" value="Clam" <%=hm.get("Clam")%>> Clam
			                                    <input type="checkbox" id="콩" name="allergy8" value="Bean" <%=hm.get("Bean")%>> Bean
			                                 </div>
										</div>
									</div>


                                    </div>

									<div class="col-xs-12 col-sm-12" style="padding-left: 0px; padding-right: 0px;">
										<div class="input-field div_margin2">
											<span class="btn-border email_length">
			                                    <button type="button" class="btn btn-sm btn-primary button_color button_color email_length" id="btnSave" onclick="location.href='/mypage/logout.do'">Sign out</button>
			                                 </span>
			                                 <span class="btn-border email_length">
			                                    <button type="submit"
			                                       class="btn btn-primary btn-custom-border text-uppercase email_length">Revise</button>
			                                 </span>
			                                 <span class="btn-border email_length">
			                                    <button type="button"
			                                       id="btnSave" onclick="location.href='/user/PWchange.do'"
			                                       class="btn btn-primary btn-custom-border text-uppercase email_length">CHANGE PASSWORD</button>
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

				<nav class="page-nav clear" style="bottom: -240px;">
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