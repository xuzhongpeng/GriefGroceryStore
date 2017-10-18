var USERID;
$(function(){
	if(!getCookie("USERID")){
		location.href="module/jsp/login.jsp";
	}
	else{
		USERID=getCookie("USERID");
		$.ajax({
	         type: "POST",
	         url: "userManageController/getByID.do",
	         data: {userID:USERID},
	         success: function(data){
	        	 data=JSON.parse(data);
	        	 console.log(data[0].password);
	        	 $("#password").val(data[0].password);
	        	 $("#user-name").val(data[0].userName);
	        	 $("#email").val(data[0].email);
	        	 $("#myheadImg").css("display","block");
	        	 $("#pictureID").val(data[0].headImg);	        	 
	        	 $("#myheadImg").attr("src",data[0].headImg);
	         }
		})
	}
	
	$("#puOn").click(function(){
		var userName=$("#user-name").val();
		var password=$("#password").val();
		var email=$("#email").val();
		var headImg=$("#pictureID").val();
		data={
				id:USERID,
				userName:userName,
				type:1,
				password:password,
				email:email,
				headImg:headImg
		}
		$.ajax({
	         type: "POST",
	         url: "userManageController/update.do",
	         data: data,
	         success: function(data){
	        	 console.log(data);
	        	 layer.alert("修改成功");
	         }
		})
	})
});