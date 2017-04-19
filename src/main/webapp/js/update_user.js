 var SUCCESS = 0;
 $(function(){
	 $("#CustomerInfoAdd").click(update_user);
	 
 });

function update_user(){
	var userId = getCookie("userId");
	var userSureName = $("#f_Customer_Name").val();
	var userMobile = $("#f_Customer_Tel1").val();
	var userEmail = $("#f_Customer_Email").val();
	var userPassword = $("#f_Customer_pass1").val();
	var userPassword2 = $.trim($('#f_Customer_pass2').val());
	var pemail = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/i;
    if (userSureName == undefined || userSureName == "") {
        $('.tips-text').html("姓名不能为空");
        return false;
    } else {
        $('.tips-text').html("");
    }
    if (userMobile == "") {
        $('.tips-text').html("手机号码不能为空");
        return false;
    } else if (!(/^1[3|4|5|7|8]\d{9}$/.test(userMobile))) {
        $('.tips-text').html("请输入正确的手机号码");
        return false;
    } else {
        $('.tips-text').html("");
        
    }
    if (userEmail == "") {
        $('.tips-text').html("请填写邮箱");
        return false;
    } else if (!pemail.test(userEmail)) {
        $('.tips-text').html("邮箱格式不正确");
        return false;
    } else {
        $('.tips-text').html("");
    }
    if(userPassword == ""){
        $('.tips-text').html("修改密码不能为空");
        return false;
    }
    if(userPassword2 != userPassword){
        $('.tips-text').html("确认密码与修改密码不一致");
        return false;
    }
    var json = {
    		userId : userId,
    		userSureName : userSureName,
    		userMobile : userMobile,
    		userEmail : userEmail,
    		userPassword :userPassword
    };
    var url = '/personalitytest/user/updateUser.do';
	$.getJSON(url, json, function(result) {
		if (result.state == SUCCESS) {
			$('.tips-text').html(result.message);
		} else {
			$('.tips-text').html(result.message);
		}
		
	})
    
}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 