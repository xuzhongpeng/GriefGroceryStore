var USERID;
$(function(){
	if(!getCookie("USERID")){
		
		location.href="module/jsp/login.jsp";
	}
	else{
		USERID=getCookie("USERID");
		 $("#toUser").attr("href","module/jsp/main/personHomepage.jsp?personID="+USERID);
		$.ajax({
	         type: "POST",
	         url: "userManageController/getByID.do",
	         data: {userID:USERID},
	         success: function(data){
	        	 data=JSON.parse(data);	  
	        	
	        	 $("#headImg").attr("src",data[0].headImg);
	         }
		})
	}
	/*发表点击事件*/
	tag(".n21","#writeText");
	tag(".n22","#wrapper");	
	tag(".n23","#articleText");
	//fileUploadInit("#filePicker:input");
	$('.titleArea').focus(function(){
		$(this).css("min-height","80px");
	});
	
	$('.titleArea').blur(function(){
		$(this).css("min-height","30px");
	});
	/*初始化主页消息*/
	refresh();
	/*下拉获取更多信息*/
	getLastHtml();
	/*上传图片消息*/
	$('#upPicturedown').click(function(){
		var content=$('#picContent').val();
		var pictureID=$('#pictureID').val();
		var userID=USERID;
		data={
				content:content,
				pictureID:pictureID,
				userID:userID,
				contentType:'2'
		}
		$.ajax({
	         type: "POST",
	         url: "dailyManageController/save.do",
	         data: data,
	         success: function(data){
	        	 data=eval("("+data+")");
	        	 console.log(data);
	        	 if(data!=null){	        		 
		        	$("#caozuo").css("display","none");
		        	var dailyID=data.dailyInfo[0].ID;
		        	var userName=data.dailyInfo[0].userName;
		        	var userImg=data.dailyInfo[0].headImg;
		        	var imgsrc=data.dailyInfo[0].url;
		        	var content=data.dailyInfo[0].content;
		        	var releaseTime=Format(data.dailyInfo[0].releaseTime,"yyyy-MM-dd hh:mm:ss");
		        	var loved=0;
		        	var userID=data.dailyInfo[0].userID;
		        	$(".leftInformation").prepend(picture(getuuid(),dailyID,userName,userImg,imgsrc,content,releaseTime,loved,userID));	
	        	 }
	        	 else{
	        		 alert("发布失败");
	        	 }
	            }
		 });
	})
	
	/*上传文字消息*/
	$('#uptextdown').click(function(){
		var content=CKEDITOR.instances.TextArea1.getData();
		var userID=USERID;
		data={
				content:content,
				userID:userID,
				contentType:'1'
		}
		$.ajax({
	         type: "POST",
	         url: "dailyManageController/save.do",
	         data: data,
	         success: function(data){
	        	 data=eval("("+data+")");
	        	 console.log(data);
	        	 if(data!=null){	        		 
		        	$("#caozuo").css("display","none");
		        	console.log(data);
		        	var dailyID=data.dailyInfo[0].ID;
		        	var userName=data.dailyInfo[0].userName;
		        	var userImg=data.dailyInfo[0].headImg;
		        	var content=data.dailyInfo[0].content;
		        	var releaseTime=Format(data.dailyInfo[0].releaseTime,"yyyy-MM-dd hh:mm:ss");
		        	var loved=0;
		        	var userID=data.dailyInfo[0].userID;
		        	$(".leftInformation").prepend(textHtml(getuuid(),dailyID,userName,userImg,content,releaseTime,loved,userID));	
	        	 }
	        	 else{
	        		 alert("发布失败");
	        	 }
	            }
		 });
	})
	/*上传文章消息*/
	$('#articleButton').click(function(){
		var title=$("#articleTitle").val();
		var content=CKEDITOR.instances.TextArea2.getData();
		var userID=USERID;
		data={
				title:title,
				content:content,
				userID:userID,
				contentType:'3'
		}
		$.ajax({
	         type: "POST",
	         url: "dailyManageController/save.do",
	         data: data,
	         success: function(data){
	        	 data=eval("("+data+")");
	        	 console.log(data);
	        	 if(data!=null){	        		 
		        	$("#caozuo").css("display","none");
		        	console.log(data);
		        	var dailyID=data.dailyInfo[0].ID;
		        	var userName=data.dailyInfo[0].userName;
		        	var userImg=data.dailyInfo[0].headImg;
		        	var content=data.dailyInfo[0].content;
		        	var releaseTime=Format(data.dailyInfo[0].releaseTime,"yyyy-MM-dd hh:mm:ss");
		        	var title=data.dailyInfo[0].title;
		        	var loved=0;
		        	var userID=data.dailyInfo[0].userID;
		        	$(".leftInformation").prepend(article(getuuid(),dailyID,userName,userImg,content,
		        			releaseTime,title,loved,userID));	
	        	 }
	        	 else{
	        		 alert("发布失败");
	        	 }
	            }
		 });
	})
})
var offsetNumber=0;
function refresh(){
	var data={
		userID:USERID,
		limit:10,
		offset:offsetNumber
	}
	$.ajax({
        type: "POST",
        url: "dailyManageController/getAllInfo.do",
        data: data,
        success: function(data){
       	 data=eval("("+data+")");
       	 if(data!=null){	
       		    if(data.AllInfo.length!=0){
	        	$("#caozuo").css("display","none");
	        	for(var i=0;i<data.AllInfo.length;i++){
	        		var type=data.AllInfo[i].contentType;
	        		var dailyID=data.AllInfo[i].ID;
		        	var userName=data.AllInfo[i].userName;
		        	var userImg=data.AllInfo[i].headImg;
		        	var content=data.AllInfo[i].content;
		        	var releaseTime=Format(data.AllInfo[i].releaseTime,"yyyy-MM-dd hh:mm:ss");
		        	var loved=0;
		        	if(data.AllInfo[i].loved!=undefined){
		        	   loved=data.AllInfo[i].loved;
		        	}
		        	var userID=data.AllInfo[i].userID;
		        	$(".leftFoot").remove();
		        	
	        		if(type==1){
	        			$(".leftInformation").append(textHtml(getuuid(),
	        					dailyID,userName,userImg,content,releaseTime,loved,userID));	
	        		}
	        		else if(type==2){
			        	var imgsrc=data.AllInfo[i].url;
			        	$(".leftInformation").append(picture(getuuid(),
			        			dailyID,userName,userImg,imgsrc,content,releaseTime,loved,userID));	
	        		}
	        		else if(type==3){
	        			var title=data.AllInfo[i].title;
	        			$(".leftInformation").append(article(getuuid(),
	        					dailyID,userName,userImg,content,releaseTime,title,loved,userID));	
	        		}
	        		offsetNumber+=1;
	        		getlast=0;
	        	}
       		    }
	        	else{
	        		$(".leftFoot").remove();
	        		var footHtml="<div class='leftFoot' ><p class='FootText' style='margin-top:0px;'>已加载完</p></div>";
	        		$(".leftInformation").append(footHtml);
	        		getlast=1;
	        	}
	        		
       	 }
       	 else{
       		 alert("发布失败");
       	 }
           }
	 });
}
/*clickName为类名或id名，blockname为id名*/
function tag(clickName,blockName){
	$(clickName).click(function(){	
	    var caozuo=$("#caozuo");			
		var $this=$(blockName);
		if(caozuo.css("display")=="none"){
			caozuo.css("display","block");
			$this.siblings().css("display","none");			
			$this.css("display","block");
			$this.css("opacity","0");
			if(blockName=="#wrapper"){
				$(".webuploader-element-invisible").parent().css("width","100%");
				$(".webuploader-element-invisible").parent().css("height","100%");
			}
			$this.animate({
			    opacity:'1'
			  },800);
		}
		else{
			if($this.css('display')=='none'){
				$this.siblings().css("display","none");
				$this.css('display',"block");
			}
			else{
				caozuo.css("display",'none');
			}
		}
	});
}
/*下拉获取更多信息*/
var getlast=0;
function getLastHtml(){
    window.addEventListener("scroll", function(event) {        
    	
        var scrollTop = document.documentElement.scrollTop || window.pageYOffset || document.body.scrollTop;  
        if(document.documentElement.scrollHeight == document.documentElement.clientHeight + scrollTop ) {
        	var footHtml="<div class='leftFoot' ><div class='loading'></div><p class='FootText'>正在加载...</p></div>";
        	//$(".leftFoot").remove();
        	if(getlast==0){
        	$(".leftInformation").append(footHtml);
        	getlast=1;
        	setTimeout("refresh()",1000);      	
        	}    
        	
    	}
    });
	
}

