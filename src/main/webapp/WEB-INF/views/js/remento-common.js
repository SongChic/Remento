$(document).ready(function ( event ) {
	
	var scrollValue = $(document).scrollTop();	
	if ( scrollValue > 0 ) {
		$(".first-section-arrow").addClass("hide");
	} else {
		$(".first-section-arrow").removeClass("hide");
	}
	
	$("img.lazy").lazyload();
	$(".lazy").lazyload();
	$(".background-section.lazy").lazyload({
	      effect : "fadeIn"
    });

});