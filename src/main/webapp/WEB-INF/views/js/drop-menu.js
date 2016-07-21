var $menu = $(".s-menu");
	
$menu.on("mouseenter", "li", function ( event ) {
	$(this).clearQueue();
	$(this).find(".drop-menu").fadeIn(100);
}).on("mouseleave", "li", function ( event ) {
	$(this).clearQueue();
	$(this).find(".drop-menu").fadeOut(100);
});