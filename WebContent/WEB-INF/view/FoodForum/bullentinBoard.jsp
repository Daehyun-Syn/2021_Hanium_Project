<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="static poly.util.CmmUtil.nvl"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="poly.dto.ProjectsDTO"%>

<!DOCTYPE html>
<html>
<!-- 컨토롤러에서 실행된 로직들의 결과값을 가져온다 == rlist에 담아진 값들  -->
<%
   List<ProjectsDTO> rList = (List<ProjectsDTO>) request.getAttribute("rList");
%>

<head>
<script src="https://translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
<script type="text/javascript">
   function googleTranslateElementInit() {new google.translate.TranslateElement({pageLanguage: 'en', includedLanguages : 'ko,en,ja,es,fr,zh-CN,ru,de,pt',layout: google.translate.TranslateElement.InlineLayout.SIMPLE}, 'google_translate_element');}
</script>

<meta charset="utf-8">
<title>AII FOR YOU</title>
<link
   href="${pageContext.request.contextPath}/resource/css/food_johns.css"
   typs="text/css" rel="stylesheet">
<!--이거 지우면 안됨-->
<link
   href="${pageContext.request.contextPath}/resource/css/food_styl.css"
   typs="text/css" rel="stylesheet">
<link rel="stylesheet" href="/resource/css/style.css">
<script
   src="${pageContext.request.contextPath}/resource/js/jquery-3.3.1.js">
</script>
<script
   src="${pageContext.request.contextPath}/resource/js/foodisotope.pkgd.js">
</script>
<script>
$(document).ready(function(e) {
    //메인 메뉴에 마우스 올리면 서브메뉴 나옴
   $('.nav > ul > li').hover(function(){
      $('.sub').stop().slideDown();
      $('.sub_bg').stop().slideDown();
   },
   function(){
      $('.sub').stop().slideUp();
      $('.sub_bg').stop().slideUp();
   });
   
   //버튼 누르면 색 고정
   $('button').click(function(){
      $('button').removeClass('active');
      $(this).addClass('active');
   });
});
</script>

<style>
#google_translate_element > div > div {
   position: relative;
   min-width: 150px;
   height:30px;
}

</style>
</head>

<body>
   <div class="wrap">


      <section>

         <h2 class="fppd_h2">
            <a href="/index.do"><img src="/resource/img/logo.png"
               class="img_size2" alt="logo"></a>
         </h2>
         <h2 class="h2_seat2" style="width:340px;">
            <code class="h2_seat_color" >Food Bulletin Board</code>
         </h2>
      
               
         
         <div class="siub">

            <!--<div class="siud_menu">
               <!--<ul class="menu_li">
                   <li><a href="siub_style.html">전체메뉴</a></li>
                    <li><a href="siub_style2.html">베스트메뉴</a></li>
                    <li><a href="#">사이드메뉴</a></li>
                    <li><a href="#">추가토핑</a></li>
                </ul>
            </div>-->

            <div class="filters button-group js-radio-button-group">
            
               <button class="button is-checked button_first" data-filter="*">All</button>
               <button class="button" data-filter=".a1">Main Dish</button>
               <button class="button" data-filter=".a2">Side Dish</button>
               <button class="button" data-filter=".a3">Meat</button>
            </div>

<div id="google_translate_element"></div>
            <div class="grid">
               <div class="element-item transition metal a1"
                  data-category="transition">
                  <a href="#"><img src="/resource/img/food/bibimbap.jpg">
                  </a>
                  <div class=".a1">
                     <h3>Bibimbap</h3>
                     <p>
                        Add herbs, meat, and garnish to rice,<br>and boiled rice with sesame oil and seasoning
                     </p>
                     <p class="p1" style="margin:2% 0 1% 0; font-weight:600;">allergy information</p>
                     <p>Beef,Egg,Bean</p>
                  </div>
               </div>
               <div class="element-item metalloid a1 a3" data-category="metalloid">
                  <a href="#"><img src="/resource/img/food/bulgogi.jpg"></a>
                  <div class="a1a2a3">
                     <h3>Bulgogi</h3>
                     <p>
                        Korean cuisine to bake and eat<br>thin beef after seasoning
                     </p>
                     <p class="p1" style="margin:2% 0 1% 0; font-weight:600;">allergy information</p>
                     <p>Pork,Bean</p>
                  </div>
               </div>
               <div class="element-item post-transition metal a2"
                  data-category="post-transition">
                  <a href="#"><img src="/resource/img/food/cabbagekimchi.jpg"></a>
                  <div class="a2">
                     <h3>Baechukimchi</h3>
                     <p>
                        Kimchi which is made of Chinese cabbage as the main material, rinses in salt, and then puts spice and dips
                     </p>
                     <p class="p1" style="margin:2% 0 1% 0; font-weight:600;">allergy information</p>
                     <p>Wheat,Shrimp</p>
                  </div>
               </div>
               <div class="element-item post-transition metal a1 a3"
                  data-category="post-transition">
                  <a href="#"><img src="/resource/img/food/chicken.jpg"></a>
                  <div class="c1 c3">
                     <h3>Friedchiken</h3>
                     <p>Fried chicken with frying powder and fried dishes</p>
                     <p class="p1" style="margin:2% 0 1% 0; font-weight:600;">allergy information</p>
                     <p>Chicken,Wheat,Milk</p>
                  </div>
               </div>
               <div class="element-item transition metal a2"
                  data-category="transition">
                  <a href="#"><img src="/resource/img/food/cucumber.jpg"></a>
                  <div class="c1 c2">
                     <h3>Oisobagi</h3>
                     <p>
                        Kimchi is dipped in a cow mixed with green onions, garlic, ginger, and red pepper powder in three or four branches of cucumber waist.
                     </p>
                     <p class="p1" style="margin:2% 0 1% 0; font-weight:600;">allergy information</p>
                     <p>Fish</p>
                  </div>
               </div>
               <div class="element-item alkali metal a2" data-category="alkali">
                  <a href="#"><img src="/resource/img/food/fern.jpg"></a>
                  <div class="c1">
                     <h3>Gosarinamul</h3>
                     <p>
                        After the fresh can bracken or the dried bracken is parboiled, it is called in the water and then seasoned and roasted herb.
                     </p>
                     <p class="p1" style="margin:2% 0 1% 0; font-weight:600;">allergy information</p>
                     <p>Bean류</p>
                  </div>
               </div>
               <div class="element-item alkali metal a1" data-category="alkali">
                  <a href="#"><img src="/resource/img/food/gimbap.jpg"></a>
                  <div class="c1">
                     <h3>Gimbap</h3>
                     <p>
                        The food is spread on the steamed rice, and the cow is put in various side dishes and rolled and cut and eaten.
                     </p>
                     <p class="p1" style="margin:2% 0 1% 0; font-weight:600;">allergy information</p>
                     <p>
                        Beef,Bean
                     </p>
                  </div>
               </div>
               <div class="element-item transition metal a2"
                  data-category="transition">
                  <a href="#"><img src="/resource/img/food/greenonion.jpg"></a>
                  <div class="c1 c2">
                     <h3>Pakimchi</h3>
                     <p>kimchi dipped in green onion</p>
                     <p class="p1" style="margin:2% 0 1% 0; font-weight:600;">allergy information</p>
                     <p>Fish</p>
                  </div>
               </div>
               <div class="element-item alkaline-earth metal a1"
                  data-category="alkaline-earth">
                  <a href="#"><img src="/resource/img/food/greenPancake.jpg"></a>
                  <div class="c1 c2">
                     <h3>Pajeon</h3>
                     <p>
                        Seismic Korean pizza is added to dough flour. In addition, meat, shellfish, oysters are added.
                     </p>
                     <p class="p1" style="margin:2% 0 1% 0; font-weight:600;">allergy information</p>
                     <p>Crustacean,Beef,Wheat,Bean</p>
                  </div>
               </div>
               <div class="element-item transition metal a1"
                  data-category="transition">
                  <a href="#"><img src="/resource/img/food/kimchipancake.jpg"></a>
                  <div class="c1">
                     <h3>Kimchijeon</h3>
                     <p>
                        Seismic Korean pizza with green onions in dough. In addition, pork or cheese is added.
                     </p>
                     <p class="p1" style="margin:2% 0 1% 0; font-weight:600;">allergy information</p>
                     <p>Crustaceans,Wheat,Bean</p>
                  </div>
               </div>
               <div class="element-item post-transition metal a1"
                  data-category="post-transition">
                  <a href="#"><img src="/resource/img/food/kimchirice.jpg"></a>
                  <div class="c1 c2">
                     <h3>Kimchibokkeumbap</h3>
                     <p>
                        Rice is chopped with kimchi, vegetables, etc., and roasted in oil.
                     </p>
                     <p class="p1" style="margin:2% 0 1% 0; font-weight:600;">allergy information</p>
                     <p>Eggs,Pork,Bean</p>
                  </div>
               </div>
               <div class="element-item metalloid a2" data-category="metalloid">
                  <a href="#"><img src="/resource/img/food/kimchistew.jpg"></a>
                  <div class="c1">
                     <h3>Kimchijjigae</h3>
                     <p>The stew boiled with kimchi.</p>
                     <p class="p1" style="margin:2% 0 1% 0; font-weight:600;">allergy information</p>
                     <p>Pork,Bean</p>
                  </div>
               </div>
               <div class="element-item transition metal a1"
                  data-category="transition">
                  <a href="#"><img src="/resource/img/food/noodles.jpg"></a>
                  <div class="c1">
                     <h3>Janchiguksu</h3>
                     <p>
                        It is a name derived from the fact that it was able to taste on the feast day.
                     </p>
                     <p class="p1" style="margin:2% 0 1% 0; font-weight:600;">allergy information</p>
                     <p>Wheat,Crustacean,Bean</p>
                  </div>
               </div>
               <div class="element-item lanthanoid metal inner-transition a2"
                  data-category="lanthanoid">
                  <a href="#"><img src="/resource/img/food/pumpkinstirfried.jpg"></a>
                  <div class="c1">
                     <h3>Aehobakbokkeum</h3>
                     <p>
                        Slice the zucchini thinly, put the shrimp, garlic, etc., and roasted in oil.
                     </p>
                     <p class="p1" style="margin:2% 0 1% 0; font-weight:600;">allergy information</p>
                     <p>Shrimp</p>
                  </div>
               </div>
               <div class="element-item noble-gas nonmetal a1 a3"
                  data-category="noble-gas">
                  <a href="#"><img src="/resource/img/food/ribsteamed.jpg"></a>
                  <div class="c1 c2">
                     <h3>Galbijjim</h3>
                     <p>Ribs such as cows and pigs are seasoned with seasonings, and the soup is boiled.</p>
                     <p class="p1" style="margin:2% 0 1% 0; font-weight:600;">allergy information</p>
                     <p>Beef,Bean</p>
                  </div>
               </div>
               <div class="element-item diatomic nonmetal a2"
                  data-category="diatomic">
                  <a href="#"><img src="/resource/img/food/radishkimchi.jpg"></a>
                  <div class="c1">
                     <h3>Kkakdugi</h3>
                     <p>
                        Kimchi made by cutting radish small and squarely and salted with salt and then mixed with spices such as red pepper powder.
                     </p>
                     <p class="p1" style="margin:2% 0 1% 0; font-weight:600;">allergy information</p>
                     <p>Bean</p>
                  </div>
               </div>
               <div class="element-item actinoid metal inner-transition a1 a3"
                  data-category="actinoid">
                  <a href="#"><img src="/resource/img/food/samgyetang.jpg"></a>
                  <div class="c1">
                     <h3>Samgyetang</h3>
                     <p>
                     Food that has chickens filled with herbal medicines and glutinous rice.
                     </p>
                     <p class="p1" style="margin:2% 0 1% 0; font-weight:600;">allergy information</p>
                     <p>Chicken</p>
                  </div>
               </div>
               <div class="element-item actinoid metal inner-transition a1 a2"
                  data-category="actinoid">
                  <a href="#"><img src="/resource/img/food/RiceSoup.jpg"></a>
                  <div class="c1">
                     <h3>Tteongmandutguk</h3>
                     <p>Cooking soup with dumplings in rice cake soup.</p>
                     <p class="p1" style="margin:2% 0 1% 0; font-weight:600;">allergy information</p>
                     <p>Wheat,Pork,Egg</p>
                  </div>
               </div>
               <div class="element-item actinoid metal inner-transition a1 a3"
                  data-category="actinoid">
                  <a href="#"><img src="/resource/img/food/seasoningchicken.jpg"></a>
                  <div class="c1">
                     <h3>Yangnyeomchicken</h3>
                     <p>
                        Food mixed with sauce made from soy sauce or red pepper paste.
                     </p>
                     <p class="p1" style="margin:2% 0 1% 0; font-weight:600;">allergy information</p>
                     <p>Chicken,Bean,Tomato Milk</p>
                  </div>
               </div>
               <div class="element-item actinoid metal inner-transition a2"
                  data-category="actinoid">
                  <a href="#"><img src="/resource/img/food/SeaweedSoup.jpg"></a>
                  <div class="c1">
                     <h3>Miyeokguk</h3>
                     <p>
                        It is a seaweed-boiled soup that helps clear blood circulation and blood.
                     </p>
                     <p class="p1" style="margin:2% 0 1% 0; font-weight:600;">allergy information</p>
                     <p>Bean</p>
                  </div>
               </div>
               <div class="element-item actinoid metal inner-transition a1"
                  data-category="actinoid">
                  <a href="#"><img src="/resource/img/food/songpyeon.jpg"></a>
                  <div class="c1">
                     <h3>Songpyeon</h3>
                     <p>
                        The rice flour is made with boiling water and the cattle including sesame, bean, the adzuki bean etc. is put and it makes into the half moon shape and the pine needles is spread and it makes.
                     </p>
                     <p class="p1" style="margin:2% 0 1% 0; font-weight:600;">allergy information</p>
                     <p>Bean</p>
                  </div>
               </div>
               <div class="element-item actinoid metal inner-transition a1 a3"
                  data-category="actinoid">
                  <a href="#"><img src="/resource/img/food/SpicyChicken.jpg"></a>
                  <div class="c1">
                     <h3>Dakgalbi</h3>
                     <p>
                        It is a food that is spicyly roasted with various vegetables by cutting chicken into a bite size.
                     </p>
                     <p class="p1" style="margin:2% 0 1% 0; font-weight:600;">allergy information</p>
                     <p>Chicken,Wheat,Bean</p>
                  </div>
               </div>
               <div class="element-item actinoid metal inner-transition a2"
                  data-category="actinoid">
                  <a href="#"><img src="/resource/img/food/spinach.jpg"></a>
                  <div class="c1">
                     <h3>Sigeumchinamul</h3>
                     <p>
                        Spinach parboiled in boiling water is dried with salt, wave, garlic, sesame oil, sesame salt.
                     </p>
                     <p class="p1" style="margin:2% 0 1% 0; font-weight:600;">allergy information</p>
                     <p>Fish</p>
                  </div>
               </div>
               <div class="element-item actinoid metal inner-transition a1 a3"
                  data-category="actinoid">
                  <a href="#"><img src="/resource/img/food/steamedchicken.jpg"></a>
                  <div class="c1">
                     <h3>Jjimdak</h3>
                     <p>
                        Cooking with various vegetables and noodles in the cut sweet meat.
                     </p>
                     <p class="p1" style="margin:2% 0 1% 0; font-weight:600;">allergy information</p>
                     <p>Bean,Chicken</p>
                  </div>
               </div>
               <div class="element-item actinoid metal inner-transition a1 a3"
                  data-category="actinoid">
                  <a href="#"><img src="/resource/img/food/stirfriedmeat.jpg"></a>
                  <div class="c1">
                     <h3>Jeyukbokkeum</h3>
                     <p>
                        It is the most popular food for Koreans who baked pork in red pepper sauce seasoning.
                     </p>
                     <p class="p1" style="margin:2% 0 1% 0; font-weight:600;">allergy information</p>
                     <p>
                        Bean,Pork
                     </p>
                  </div>
               </div>
               <div class="element-item actinoid metal inner-transition a1 a3"
                  data-category="actinoid">
                  <a href="#"><img src="/resource/img/food/tteokgalbi.jpg"></a>
                  <div class="c1">
                     <h3>Tteokgalbi</h3>
                     <p>
                        The food which the beef rib flesh is hardened and it is seasoned with soy sauce and it thickly sticks to the ribs and eaten
                     </p>
                     <p class="p1" style="margin:2% 0 1% 0; font-weight:600;">allergy information</p>
                     <p>Beef,Pork,Bean</p>
                  </div>
               </div>

            </div>
      </section>
      <div class="div_button">
         <button type="button" onclick="location.href='/index.do' "
            class="btn button_FA6862 button_FA6862_seat"
            style="width: 120px; margin-right: 10px;">previous page</button>
      </div>
   </div>



   <script>
// init Isotope
var $grid = $('.grid').isotope({
  itemSelector: '.element-item',
  layoutMode: 'fitRows',
  getSortData: {
    name: '.name',
    symbol: '.symbol',
    number: '.number parseInt',
    category: '[data-category]',
    weight: function( itemElem ) {
      var weight = $( itemElem ).find('.weight').text();
      return parseFloat( weight.replace( /[\(\)]/g, '') );
    }
  }
});

// filter functions
var filterFns = {
  // show if number is greater than 50
  numberGreaterThan50: function() {
    var number = $(this).find('.number').text();
    return parseInt( number, 10 ) > 50;
  },
  // show if name ends with -ium
  ium: function() {
    var name = $(this).find('.name').text();
    return name.match( /ium$/ );
  }
};

// bind filter button click
$('.filters').on( 'click', 'button', function() {
  var filterValue = $( this ).attr('data-filter');
 
  filterValue = filterFns[ filterValue ] || filterValue;
  $grid.isotope({ filter: filterValue });
});

$('.button-group').each( function( i, buttonGroup ) {
  var $buttonGroup = $( buttonGroup );
  $buttonGroup.on( 'click', 'button', function() {
    $buttonGroup.find('.is-checked').removeClass('is-checked');
    $( this ).addClass('is-checked');
  });
});
  
</script>
</body>
</html>