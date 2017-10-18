$(function(){
	var userID=GetQueryString("personID");
	getLastHtml();
	if(userID==undefined||userID=="undefined"){
		userID="639478920";
	}
	var data={
			userID:userID
	}
	$.ajax({
		type: "POST",
        url: "userManageController/getByID.do",
        data: data,
        success: function(data){
        	data=JSON.parse(data);
        	if(data.length>0){
	    		$("#userImg").attr("src",data[0].headImg);
	        	$("#userName").attr("href","module/jsp/main/personHomepage.jsp?peronID="+data[0].userID);
	        	$("#userName").html(data[0].userName);
	        	$("#email").html(data[0].email);
	        	var registerTime=Format(data[0].registerTime,"yyyy-MM-dd hh:mm:ss");
	        	$("#registerTime").html(registerTime);
        	}
        }
	});
	refresh(userID);
})
var offsetNumber=0;
function refresh(userID){
	var data={
		userID:userID,
		limit:5,
		offset:offsetNumber
	}
	$.ajax({
        type: "POST",
        url: "dailyManageController/getPersonPictureDaily.do",
        data: data,
        success: function(data){
       	 data=eval("("+data+")");
       	 console.log(data);
      
       	 if(data!=null){	
       		    if(data.AllInfo.length!=0){
	        	//8
   		    	$("#caozuo").css("display","none");
	        	for(var i=0;i<data.AllInfo.length;i++){
	        		var type=data.AllInfo[i].contentType;
	        		var dailyID=data.AllInfo[i].ID;
		        	var userName=data.AllInfo[i].userName;
		        	var userImg=data.AllInfo[i].headImg;
		        	var content=data.AllInfo[i].content;
		        	var releaseTime=Format(data.AllInfo[i].releaseTime,"yyyy-MM-dd hh:mm:ss");
		        	var imgsrc=data.AllInfo[i].url;
		        	var loved=0;
		        	if(data.AllInfo[i].loved!=undefined){
		        	   loved=data.AllInfo[i].loved;
		        	}
		        	$(".leftFoot").remove();
		        	
		        	$(".m-postlst").append(addHtml(imgsrc,dailyID,releaseTime,loved));
	        		offsetNumber+=1;
	        		getlast=0;
	        	}
       		    }
	        	else{
	        		$(".leftFoot").remove();
	        		var footHtml="<div class='leftFoot' ><p class='FootText' style='margin-top:0px;'>已加载完</p></div>";
	        		$(".g-mnc").append(footHtml);
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
        	$(".g-mnc").append(footHtml);
        	getlast=1;
        	setTimeout("refresh()",1000);      	
        	}    
        	
    	}
    });
	
}
function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}
function addHtml(url,dailyID,releaseTime,loved){
 var html="<div class='m-post m-post-img'>" +
 		"    <input type='hidden' value='"+dailyID+"'>"+
	"		<div class='postinner'>"+
	"		<div class='ct'>"+
	"			<div class='ctc box'>"+
	"				<div class='pic'>	"+
	"					<a class='img' href='http://inschuanda.lofter.com/post/1ebda16f_112e6e9f'>"+
	"						<img src='http://127.0.0.1:8080/image/"+url+"'>"+
	"					</a>"+
	"				</div>"+
	"			</div>"+
	"		</div>"+
	"		<div class='info box'>"+
	"			<a class='date' href='http://inschuanda.lofter.com/post/1ebda16f_112e6e9f'>时间：<span>"+releaseTime+"</span></a>"+
	"			<span class='sep'>·</span><a class='hot' " +
	"				href='http://inschuanda.lofter.com/post/1ebda16f_112e6e9f'>热度：<span>"+loved+"</span></a>"+
	"		</div>"+
	"	</div>"+
	"	</div>";
 return html;
}