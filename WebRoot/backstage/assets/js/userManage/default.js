$(function(){
	$(".nav-link").click(function(){
		$(".nav-link").attr("class","nav-link tpl-left-nav-link-list");
		$(this).attr("class","nav-link active");
		$("#iframeId").attr("src",$(this).attr('href'));		
		return false;
	})
	if(!getCookie("ADMINUSERID")){		
		location.href="backstage/login.html";
	}
	else{
		USERID=getCookie("ADMINUSERID");
		// $("#toUser").attr("href","module/jsp/main/personHomepage.jsp?personID="+USERID);
		$.ajax({
	         type: "POST",
	         url: "userManageController/getByID.do",
	         data: {userID:USERID},
	         success: function(data){
	        	 data=JSON.parse(data);	  
	        	 $("#userName11").html(data[0].userName);
	        	 $("#headImg").attr("src",data[0].headImg);
	         }
		})
	}
	
})