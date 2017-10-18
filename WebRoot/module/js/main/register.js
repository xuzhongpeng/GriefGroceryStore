$(function(){
	$(".personPu").css("border-bottom","0px solid #D9D9D9");
	$("#puOn").click(function(){
		var userID=$("#userID").val();
		var userName=$("#user-name").val();
		var password=$("#password").val();
		var email=$("#email").val();
		var headImg=$("#pictureID").val();
		data={
				userID:userID,
				userName:userName,
				type:1,
				password:password,
				email:email,
				headImg:headImg
		}
		$.ajax({
	         type: "POST",
	         url: "userManageController/save.do",
	         data: data,
	         success: function(data){
	        	 console.log(data);
	        	 layer.alert("恭喜注册成功",function(){
	        		 location.href="module/jsp/login.jsp";
	        	 });
	         }
		})
	})
})