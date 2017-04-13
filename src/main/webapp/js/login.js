/**
 * 登录脚本js
 */
$(function(){
	/**
	 * 检查账户
	 */
	$("#f_UserName").blur(userNameCheck);
	/**
	 * 检查密码
	 */
	$("#f_UserPassword").blur(passwordCheck);
	/**
	 * 用户登录
	 */
	$("#login_btn").click(userLogin);
});


function userLogin(){
	var login = userNameCheck()+passwordCheck();
	if(login != 2){
		console.log("账号密码不对");
		return false;
	}
	var userName = $('#f_UserName').val();
	var password = $('#f_UserPassword').val();
	var json = {
		'userName' : userName,
		'password' : password
	};
	$.ajax({
		//请求页面
		url : '/personalitytest/user/userLogin.do',
		//请求参数
		data : json,
		//返回的数据类型
		dataType : 'json',
		//请求类型
		type : 'POST',
		//指定函数
		success : function(result) {
			//返回值状态为0 则是正确返回,设置Cookie(保存UserId)并跳转页面 
			if (result.state == 0) {
				$('.error').hide();
				var user = result.data;
				setCookie('userId', user.userId);
				location.href='admin/menu.html';
				return;
				//返回值状态若为2 则返回帐号错误信息  直接return
			} else if (result.state == 1) {
				$(".tips_text").html(result.message);
				$('.error').show();
				return;
				//返回值状态若为3 则返回密码错误信息  直接return
			} else if (result.state == 2) {
				$(".tips_text").html(result.message);
				$('.error').show();
				return;
			}
			//其他状态则直接弹出报错信息
			alert(result.message);
		},
		 //严重错误时,页面错误信息
		error : function() {
			alert('Ajax请求失败');
		}
	});
	
	
}
function userNameCheck(){
	var userName = $("#f_UserName").val();
	if(!userName){
		$(".tips_text").html("请填写登录用户名！");
		return false;
	}
	var patrn=/^[0-9]{1,20}$/;
	if(patrn.exec(userName)){
		$(".tips_text").html("账号格式错误");
		return false;
	}
	patrn= /^[a-zA-Z]{1}[0-9a-zA-Z_]{5,16}$/; 
	if(!patrn.exec(userName)){
		$(".tips_text").html("账号格式错误");
		return false;
	}
	return true;
}
function passwordCheck(){
	var password = $("#f_UserPassword").val();
	if(!password){
		$(".tips_text").html("请填写登录密码！");
		return false;
	}
	if(password.length < 6){
		$(".tips_text").html("密码太短");
		return false;
	}
	var patrn=/^(\w){6,20}$/;
	if(!patrn.exec(password)){
		$(".tips_text").html("密码格式错误");
		return false;
	}
	return true;
}