$(function(){
	$("input").click(function(){
		if(this.checked) {
			$(this).parent().addClass("on");
		} else {
			$(this).parent().removeClass("on");
		}
	});
});

$('.toggle').on('click', function() {
  $('.container').stop().addClass('active');
});

$('.close').on('click', function() {
  $('.container').stop().removeClass('active');
});
