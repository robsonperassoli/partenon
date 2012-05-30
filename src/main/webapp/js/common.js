(function($) {
	var slide;
	var index=0;
	var count=0;
	var time=3000;
	var done=true;
	$.fn.SlidePlayer=function() {
		count=$('.slide-player li',this[0]).length;
		startSlide($('.slide-player li',this[0])[0]);
		$('.slide-menu a').bind('click',function() {
			if(done&&!$(this).is('.selected')) {
				Slide($(this).parent().find('a').index(this),this);
			}
		});
	};

	function Slide(ix,obj) {
		if(ix>=0) index=ix; 
		else index++;
		if(index>count-1) index=0;
		stopSlide();
		done=false;
		var father=$(obj).parents('.slide-box:eq(0)');
		var list=$('.slide-player',father);
		var trigger=$('.slide-menu',father);
		var old=$('>.selected',list);
		if(old.length>0) {
			old.css('z-index',10);
			$('>:eq('+index+')',list).addClass('selected').show();
			old.fadeOut(500,function() {	//fadeOut,hide,slideUp,slideDown;
				$(this).css('z-index',1).removeClass('selected');
				done=true;
				startSlide(obj);
			});
			trigger.find('a.selected').removeClass('selected');
			$('a:eq('+index+')',trigger).addClass('selected');
		}
	}
	//stop
	function stopSlide(){
		clearTimeout(slide);
	}
	//start
	function startSlide(obj){
		slide=setTimeout(function() {Slide(-1,obj)},time);
	}
})(jQuery);

$(document).ready(function(){
	$('.slide-box').SlidePlayer();
});