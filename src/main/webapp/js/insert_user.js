var SUSCCESS = 0;
$(function(){
        $('.add-hr').click(addHr);
        $('.table-cont').on('click', '.edit-hr', editHr);
        $("#btn_sure_add").click(submitHr);
    });
    
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
        var userName = $.trim($('#f_Customer_Name').val());
        var userMobile = $.trim($('#f_Customer_Tel1').val());
        var pemail = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/i;
        var userEmail = $.trim($('#f_Customer_Email').val());
        var roleId = $("#roleId").val();
        var userId = getCookie("userId");
        if (userName == undefined || userName == "") {
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
        		userName : userName,
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
                if(result.state == SUSCCESS){
                	location.href='/personalitytest/admin/tjhr.html';
                	return;
                }
            },
            error: function(){
            	
            }
        });
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
