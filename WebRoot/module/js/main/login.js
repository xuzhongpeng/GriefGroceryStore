$(function(){
	clearCookie("USERID");
	$("#register").click(function(){
		location.href="module/jsp/main/register.jsp";
	})
	$("#loginOk").click(function(){
		var name=$("#name").val();
		var password=$("#password").val();
		var data={
				name:name,
				password:password
		}
		$.ajax({
			type: "POST",
	        url: "userManageController/getByName.do",
	        data: data,
	        success: function(data){
	        	data=JSON.parse(data);
	        	if(data.length!=0){
	        		setCookie("USERID",data[0].userID,7);
	        		var nexturl=GetQueryString("nextUrl");
	        		if(nexturl==null){
	        			location.href="module/jsp/index.jsp";
	        		}
	        		else{
	        			location.href="module/jsp/"+nexturl;
	        		}
	        	}
	        	else{
	        		$(".remind").html("QAQ 用户名或密码错误");
	        	}
	        }
		});
	})
})
function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}