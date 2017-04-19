
var SUCCESS = 0;
$(function() {
	/*添加应试者信息*/
	$("#CustomerInfoAdd").click(insertCandiDateMessage);
})

function insertCandiDateMessage(){
	
	var userId = JSON.parse(getCookie('user')).userId;
	var name = $("#f_Customer_Name").val();
	var positionId = $("#f_Customer_Position").val();
	var mobile = $("#f_Customer_Tel1").val();
	var phone = $("#f_Customer_Tel2").val();
	var gender = $("#gender").val();
	var dayOfBirth = $("#indate").val();
	var email = $("#email").val();
	var education = $("#education").val();	
	var school = $("#f_Customer_School").val();
	var collage = $("#f_Customer_College").val();
	var major = $("#f_Customer_Professional").val();
	var graduation = $("#grade").val();
	var qq = $("#qq").val();
	var sourceId = $("#source").val();
	var cityId = $("#city").val();
	var stateId = $("#state").val();
	var json = {userId : userId,
		   		name : name,
		   		positionId : positionId,
		   		mobile : mobile,
		   		phone : phone,
		   		gender : gender,
		   		dayOfBirth : dayOfBirth,
		   		email : email,
		   		education : education,
		   		school : school,
		   		collage : collage,
		   		major : major,
		   		graduation : graduation,
		   		qq : qq,
		   		sourceId : sourceId,
		   		cityId : cityId,
		   		stateId : stateId
	};
	$.ajax({
        url: "/personalitytest/message/insertCandiDate.do",
        type: "POST",
        contentType : 'application/json;charset=utf-8', 
        dataType:"json",
        data: JSON.stringify(json),    //将Json对象序列化成Json字符串，JSON.stringify()原生态方法
        success: function(result){
            console.log(result.data);
        },
        error: function(){
        }
    });
}
