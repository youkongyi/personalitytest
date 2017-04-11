/*
 * 应试者信息脚本
 */
var SUCCESS = 0;
$(function(){
	/*登录后立即显示已录入的应试者信息*/
	loadCandiDateMessage();
	
});
function loadCandiDateMessage(){
	var url='/personalitytest/message/candiDate.do';
	var data={ userId:getCookie('userId') };
	$.getJSON(url, data, function(result){
		if(result.state==SUCCESS){
			var list  = result.data;
			if(list){
				for(var i=0;i<list.length;i++){
				$("#message").append("<tr align='center'>"
										+"<td>"+list[i].candidateId+"</td>"
										+"<td>"+list[i].name+"</td>"
										+"<td>"+list[i].gender+"</td>"
										+"<td>"+list[i].mobile+"</td>"
										+"<td><p class='email-num'>"+list[i].email+"</p></td>"
										+"<td>"+list[i].cityId+"</td>"
										+"<td>"+list[i].positionId+"</td>"
										+"<td>"+list[i].stateId+"</td>"
						               +"<td>未答题</td>"
						               +"<td><span class='color1'>11</span>"
						                   +"<span class='color2'>7</span>"
						                   +"<span class='color3'>4</span>"
						                   +"<span class='color4'>8</span></td>"
						               +"<td><a href='xxxx.html'>详细</a></td>" 
						            +"</tr>");
						}
					} else {
						//查询无内容
						$("#message").append('<tr id="empty">'
							                    +'<td colspan="14">'
							                        +'<div class="empty">'
							                        	+'<img src="../images/empty_1.png" alt=""/>'
							                        +'</div>'
							                    +'</td>'
							                +'</tr>');
			}
//			model.updateNotebooks(list, page);
			
		}
	});
}