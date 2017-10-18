var USERID=getCookie("USERID");
$(function(){
	/*文本框随文字变化而变化*/

	
	/*$(document).on("click",".commentOn",function(this){
		comment(this);
	})*/
})
function inputFocus(obj){
	$(obj).css("min-height","80px");
}
function inputblur(obj){
	$(obj).css("min-height","30px");
}

/*点赞点击事件*/
function lovedClick(dailyID,uuid,obj){
	
		//var dailyID='20170915211628229';
		
		if($(obj).attr("title")=="love"){
			$(".lovedd").remove();
			$(obj).attr('title',"取消");
			console.log($(obj));
			$(obj).parent().parent().append("<img class='lovedd' style='position: relative;top: -1px;left: 298px;width: 0px;opacity:0' src='module/img/love.png'>");
			$(".lovedd").animate({
			    width:'60',
			    top: '-60',
			    left: '264',
			    opacity:'0.4'
			  },800);
			$(".lovedd").animate({
			    opacity:'0'
			  },300);		
			$(obj).attr('src',"module/img/love.png");
			Likes(dailyID,1,uuid);
			
		}
		else{
			$(obj).attr('src',"module/img/loveF.png");
			$(obj).attr('title',"love");
			Likes(dailyID,0,uuid);
		}
	
}
/*评论点击事件*/
function comment(data){
		var co="."+data+"";
		var com="#"+data;
		var $this=$(co);
		var dailyID=$(com).val();
		if($this.css("display")=="none"){
			$this.css("display","block");
			$this.css("opacity","0");
			$this.animate({
			    opacity:'1'
			  },800);
			addComment(data);
		}
		else{
			$this.css("display","none");
		}
	}
function addComment(uuid){
	var com="#"+uuid;
	dailyID=$(com).val();
	console.log(dailyID);
	data={
			dailyID:dailyID
	}
	$.ajax({
        type: "POST",
        url: "commentController/getCommentbyDailyID.do",
        data: data,
        success: function(data){
        	data=JSON.parse(data);
        	$(".userComment").remove();
        	for(var i=0;i<data.length;i++){
        		var co1="."+uuid;
        		
        		var commentTime=Format(data[i].commentTime,"yyyy-MM-dd hh:mm:ss");
        		var userName=data[i].userName;
        		var comment=data[i].COMMENT;
        		var headImg=data[i].headImg;
        		var html="<div class='userComment'>"
        		+"						<hr class='thisHr'>"
        		+"						<img src='"+headImg+"'></img>" 
        		+"				        <a class='commentUser'>"+userName+"</a>"
        		+"						<div class='commentInfo'>" 
        		+" 				        <p class='commentCon'>"+comment+"</p></div>" +
        				"   			<p class='time' style='float:right;margin-top: -16px;margin-right: 20px;font-size: 12px;'>" 
        								+commentTime+"</p>"
        		+"					</div>";
        		
        		$(co1).append(html);
        	}
        }
    })
}
//发表评论
function postComment(dailyID,obj,uuid){
	if(!USERID){
		location.href="module/jsp/login.jsp";
		return;
	}
	console.log("post");
	var comment=$(obj).parent().children(".inputComment").val();
	data={
			commentContent:comment,
			dailyID:dailyID,
			userID:USERID
	}
	$.ajax({
        type: "POST",
        url: "commentController/add.do",
        data: data,
        success: function(data){
        	if(data!='false'){
        		addComment(uuid);
        	}
        }
    })	
} 
//点赞
function Likes(dailyID,type,uuid){
	data={
			dailyID:dailyID,
			type:type
	}
	$.ajax({
        type: "POST",
        url: "dailyManageController/likes.do",
        data: data,
        success: function(data){
        	if(data!=0){
        		var com=".love"+uuid;
        		var count=$(com).html();
        		if(type==1)
        			count=parseInt(count)+1;
        		else
        			count=parseInt(count)-1;
        		$(com).html(count);
        	}
        }
    })	
}