



$(window).load(function() {
$('.flexslider').flexslider({
  animation: "slide",
  start: function(slider) {
    $('body').removeClass('loading');
  }
});
});

$(document).ready(function() {
$('a.info').tooltip();
$("#owl-demo").owlCarousel({
  items : 4
});
});
jQuery(document).ready(function(){
jQuery('ul.superfish').superfish();
new WOW().init();
});
jQuery(document).ready(function() {


        $('.bxslider1').bxSlider({
          minSlides: 5,
          maxSlides: 6,
          slideWidth: 360,
          slideMargin: 2,
          moveSlides: 1,
          responsive: true,
          nextSelector: '#slider-next',
          prevSelector: '#slider-prev',
          nextText: 'Next →',
          prevText: '← Prev'
        });

      });


$(function() {

        $('#da-slider').cslider({
          autoplay    : true,
          bgincrement : 100 ,
          interval : 8000
        });

      });

function popup_close(){
        $('.header-popup').css('display','none')
 }