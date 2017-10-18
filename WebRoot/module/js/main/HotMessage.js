$(function(){
	refresh();
	getLastHtml();
});
var offsetNumber=0;
function refresh(){
	var data={
		limit:10,
		offset:offsetNumber
	}
	$.ajax({
        type: "POST",
        url: "dailyManageController/getHotDaily.do",
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
	        			$(".center").append(textHtml(getuuid(),dailyID,userName,userImg,content,releaseTime,loved,userID));	
	        		}
	        		else if(type==2){
			        	var imgsrc=data.AllInfo[i].url;
			        	$(".center").append(picture(getuuid(),dailyID,userName,userImg,imgsrc,content,releaseTime,loved,userID));	
	        		}
	        		else if(type==3){
	        			var title=data.AllInfo[i].title;
	        			$(".center").append(article(getuuid(),dailyID,userName,userImg,content,releaseTime,title,loved,userID));	
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


/*下拉获取更多信息*/
var getlast=0;
function getLastHtml(){
    window.addEventListener("scroll", function(event) {        
    	
        var scrollTop = document.documentElement.scrollTop || window.pageYOffset || document.body.scrollTop;  
        if(document.documentElement.scrollHeight == document.documentElement.clientHeight + scrollTop ) {
        	var footHtml="<div class='leftFoot' ><div class='loading'></div><p class='FootText'>正在加载...</p></div>";
        	//$(".leftFoot").remove();
        	if(getlast==0){
        	$(".center").append(footHtml);
        	getlast=1;
        	setTimeout("refresh()",1000);      	
        	}    
        	
    	}
    });
	
}