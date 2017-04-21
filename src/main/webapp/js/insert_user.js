var SUCCESS = 0;
$(function(){
		/* 查找所有HR */
		findRoleIdHRUser();
        $('.add-hr').click(addHr);
        $('.table-cont').on('click', '.edit-hr', editHr);
        /* 添加HR */
        $("#btn_sure_add").click(submitHr);
        /* 根据条件查找对应的HR信息  */
        $("#search_btn").click(findHRUser);
    });

function findRoleIdHRUser(){
	var url = '/personalitytest/user/findRoleIdHRUser.do';
	var data = { userId : JSON.parse(getCookie('user')).userId };
	$.getJSON(url, data, function(result) {
		if (result.state == SUCCESS) {
			var list = result.data;
			console.log(list);
			var length = list.list.length;
			if (length != 0) {
				for (var i = 0; i < length; i++) {
					$("#hr_user").append(
							"<tr align='center' id='userMessage'>"
	                        +"<td>"+list.list[i].userId+"</td>"
	                        +"<td>"+list.list[i].userSureName+"</td>"
	                        +"<td>"+list.list[i].userMobile+"</td>"
	                        +"<td><p class='email-num'>"+list.list[i].userEmail+"</p></td>"
	                        +"<td><p class='max-td1'>北京</p></td>"
	                        +"<td><p class='max-td1'>海淀</p></td>"
	                        +"<td><p class='max-td1'>魏公村分中心</p></td>"
	                        +"<td>"+list.list[i].roleId+"</td>"
	                        +"<td><input type='button' class='btn btn-small edit-hr'  value=' 修  改  '>" 
	                        +    "<input type='button' class='btn btn-small' value=' 删 除  ' data-toggle='modal' data-target='#open_tips'></td>"
	                       +"</tr>"
							);
				}
				$(".foot").append(
				'<ul class="pagination">'+
                '<li class="active"><a href="#">1<span class="sr-only">(current)</span></a></li>'+
            '</ul>'+
            '<p>共<span>'+list.total+'</span>条记录，每页<span>'+list.list[0].pageSize+'</span>条</p>'
				);
			} else {
				$("#not").show();
			}

		}
	})
}



    function addHr(){
        //打开对话框
        $('#open_tjhr .modal-title').html('添加HR');
        $('#open_tjhr').modal('show');
    }

    function editHr(){
         //打开对话框
        $('#open_tjhr .modal-title').html('修改HR');
        $('#open_tjhr').modal('show');
    }

   function submitHr() {
        var userSureName = $.trim($('#f_Customer_Name').val());
        var userMobile = $.trim($('#f_Customer_Tel1').val());
        var pemail = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/i;
        var userEmail = $.trim($('#f_Customer_Email').val());
        var roleId = $("#roleId").val();
        var userId = JSON.parse(getCookie('user')).userId;
        if (userSureName == undefined || userSureName == "") {
            $('.tips-text').html("姓名不能为空");
            return false;
        }
        if (userMobile == "") {
            $('.tips-text').html("手机号码不能为空");
            return false;
        } 
        if (!(/^1[3|4|5|7|8]\d{9}$/.test(userMobile))) {
            $('.tips-text').html("请输入正确的手机号码");
            return false;
        }
        if (userEmail == "") {
            $('.tips-text').html("请填写邮箱");
            return false;
        }
        if (!pemail.test(userEmail)) {
            $('.tips-text').html("邮箱格式不正确");
            return false;
        }
        var json = {
        		userId : userId,
        		userSureName : userSureName,
        		userMobile : userMobile,
        		userEmail : userEmail,
        		roleId : roleId
        };
        $.ajax({
            url: '/personalitytest/user/insertUser.do',
            type: 'POST',
            dataType:'json',
            data: json,  
            success: function(result){
                if(result.state == SUCCESS){
                	location.href='/personalitytest/admin/tjhr.html';
                	return;
                }
            },
            error: function(){
            	
            }
        });
    }
   
function findHRUser(){
	var url = '/personalitytest/user/findHRUser.do';
	var userSureName = $("#name").val();
	var userMobile = $("#mobile").val();
	var userEmail = $("#email").val();
	var data = {
		userId : JSON.parse(getCookie('user')).userId,
		userSureName : userSureName,
		userMobile : userMobile,
		userEmail : userEmail
	};
	$.getJSON(url, data, function(result) {
		if (result.state == SUCCESS) {
			$("#hr_user").children("#userMessage").remove();
			var list = result.data;
			var length = list.list.length
			if (length != 0) {
				$("#not").hide();
				for (var i = 0; i < length ; i++) {
					$("#hr_user").append(
							"<tr align='center' id='userMessage'>"
	                        +"<td>"+list.list[i].userId+"</td>"
	                        +"<td>"+list.list[i].userSureName+"</td>"
	                        +"<td>"+list.list[i].userMobile+"</td>"
	                        +"<td><p class='email-num'>"+list.list[i].userEmail+"</p></td>"
	                        +"<td><p class='max-td1'>北京</p></td>"
	                        +"<td><p class='max-td1'>海淀</p></td>"
	                        +"<td><p class='max-td1'>魏公村分中心</p></td>"
	                        +"<td>"+list.list[i].roleId+"</td>"
	                        +"<td><input type='button' class='btn btn-small edit-hr'  value=' 修  改  '>" 
	                        +    "<input type='button' class='btn btn-small' value=' 删  除  ' data-toggle='modal' data-target='#open_tips'></td>"
	                       +"</tr>"
							);
				}
				$(".foot").children().remove();
				$(".foot").append(
						'<ul class="pagination">'+
		                '<li class="active"><a href="#">1<span class="sr-only">(current)</span></a></li>'+
		            '</ul>'+
		            '<p>共<span>'+list.total+'</span>条记录，每页<span>'+list.list[0].pageSize+'</span>条</p>'
						);
			} else {
				$("#not").show();
			}
		}
	})
}   
   
