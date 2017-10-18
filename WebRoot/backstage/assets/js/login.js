$(function(){
	clearCookie("ADMINUSERID");
	$("#loginOK").click(function(){
		var userID=$("#userID").val();
		var password=$("#password").val();
		data={
				name:userID,
				password:password,
				type:2
				
		}
		$.ajax({
			type: "POST",
	        url: "../userManageController/getByName.do",
	        data: data,
	        success: function(data){
	        	data=JSON.parse(data);
	        	console.log(data);
	        	if(data.length!=0){	        		
	        		setCookie("ADMINUSERID",data[0].userID,7);	        		
	        		location.href="jsp/default.jsp";   		
	        	}
	        	else{
	        		$(".remind").html("QAQ 用户名或密码错误");
	        	}
	        }
		});
	})
})