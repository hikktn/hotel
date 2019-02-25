/**
 * 局部无刷新跳转
 */
$(function() {
	$("a").click(function () {
		var href=this.href;
		console.log(href);
		$(".mainbox").load(href);
		return false;
	});
	
	window.onload = function() {
		var href=$("#administration").attr('href');
		$(".mainbox").load(href);
		return false;
	}
});