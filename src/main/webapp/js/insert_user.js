var SUCCESS = 0;
$(function(){
	findRoleIdHRUser();
        $('.add-hr').click(addHr);
        $('.table-cont').on('click', '.edit-hr', editHr);
        $("#btn_sure_add").click(submitHr);
    });

function findRoleIdHRUser(){
	var url = '/personalitytest/user/findRoleIdHRUser.do';
	var data = { userId : JSON.parse(getCookie('user')).userId };
	$.getJSON(url, data, function(result) {
		if (result.state == SUCCESS) {
			var list = result.data;
			if (list.length != 0) {
				for (var i = 0; i < list.length; i++) {
					$("#hr_user").append(
							"<tr align='center'>"
	                        +"<td>"+list[i].userId+"</td>"
	                        +"<td>"+list[i].userSureName+"</td>"
	                        +"<td>"+list[i].userMobile+"</td>"
	                        +"<td><p class='email-num'>"+list[i].userEmail+"</p></td>"
	                        +"<td><p class='max-td1'>北京</p></td>"
	                        +"<td><p class='max-td1'>海淀</p></td>"
	                        +"<td><p class='max-td1'>魏公村分中心</p></td>"
	                        +"<td>"+list[i].roleId+"</td>"
	                        +"<td><input type='button' class='btn btn-small edit-hr'  value=' 修  改  '>" 
	                        +    "<input type='button' class='btn btn-small' value=' 删 除  ' data-toggle='modal' data-target='#open_tips'></td>"
	                       +"</tr>"
							);
				}
			} else {
				$("#hr_user").append(
                +'<tr style="display: none;">'
                    +'<td colspan="9">'
                        +'<div class="empty">'
                            +'<img src="../images/empty_1.png" alt=""/>'
                        +'</div>'
                    +'</td>'
                +'</tr>'
                );
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
