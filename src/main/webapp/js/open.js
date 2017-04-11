// JavaScript Document
//弹层
function popbox(obj){
	if($(document).height() > $(window).height()){
		heightnum = $(document).height();
	}else{
		heightnum = $(window).height();
	}
	$('.gray_layer').css('height',heightnum);
	$('.gray_layer').show();
	
	var marginLeft = $(obj).outerWidth()/-2;
	var marginTop = $(obj).outerHeight()/-2;
	$(obj).css('margin-left',marginLeft);
	$(obj).css('margin-top',marginTop);
	$(obj).fadeIn();
	
	return false;
}

function popclose(obj,obj2){
	$('.gray_layer').hide();
	$(obj).hide();
	if(obj2){
		popbox(obj2);
	}
}