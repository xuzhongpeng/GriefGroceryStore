var offsetNumber=0;
$(function(){
	$("#alertImg").hover(function(){
		$(this).css("cursor","pointer");
	})
	refresh();
	getLastHtml();
})

var col=0;
function refresh(){
	var data={
			limit:10,
			offset:offsetNumber
		}
	$.ajax({
        type: "POST",
        url: "dailyManageController/getPictureDaily.do",
        data: data,
        success: function(data){
        	data=eval("("+data+")");
        	console.log(data);
        	//return;
        	if(data.AllInfo.length!=0){
	        	
	        	for(var i=0;i<data.AllInfo.length;i++){
	        		var dailyID=data.AllInfo[i].ID;
	        		var userID=data.AllInfo[i].userID;
		        	var userName=data.AllInfo[i].userName;
		        	var userImg=data.AllInfo[i].headImg;
		        	var content=data.AllInfo[i].content;
		        	var imgsrc=data.AllInfo[i].url;
		        	var releaseTime=Format(data.AllInfo[i].releaseTime,"yyyy-MM-dd hh:mm:ss");
		        	var loved=0;
		        	if(data.AllInfo[i].loved!=undefined){
		        	   loved=data.AllInfo[i].loved;
		        	}	
		        	$(".leftFoot").remove();
		        	$(".col").eq(col).append(addPic(userID,userImg,userName,dailyID,imgsrc,content,loved,getuuid()));
		        	col++;
		        	if(col==3){
		        		col=0;
		        	}
		        	offsetNumber+=1;
	        		getlast=0;
	        	}
   		    }
        	else{
        		$(".leftFoot").remove();
        		var footHtml="<div class='leftFoot' ><p class='FootText' style='margin-top:0px;'>已加载完</p></div>";
        		$(".center").after(footHtml);
        		getlast=1;
        	}
        	
        	
        }
	})
}
/*点赞*/
function lovedClick(dailyID,uuid,obj){
	if(!getCookie("USERID")){
		location.href="module/jsp/login.jsp?nextUrl=main/pictureView.jsp";
		return;
	}
	if($(obj).attr("title")!="cancel"){
		$(".lovedd").remove();
		$(obj).attr('title',"cancel");
		$(obj).parent().parent().append("<img class='lovedd' style='position: relative;top: -43px;left: 17px;width: 17px;opacity: 0;display: block;' src='module/img/love.png'>");
		$(".lovedd").animate({
		    width:'60',
		    top: '-126',
		    left: '-3',
		    opacity:'0.7'
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
        		var com="."+uuid;
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
function zhanshi(src){
	//页面层-佟丽娅
	$('#alertImg').attr("src",src);
	layer.open({
	  type: 1,
	  title: false,
	  closeBtn: 0,
	  area: '486px',
	  skin: 'layui-layer-nobg', //没有背景色
	  shadeClose: true,
	  content: $('#tong')
	});
	
	
}
function follow(userID,obj){
	if(!getCookie("USERID")){
		location.href="module/jsp/login.jsp?nextUrl=main/pictureView.jsp";
		return;
	}
	data={
			userID:getCookie("USERID"),
			friendID:userID
	}
	if(userID==getCookie("USERID")){
		alert("自己随时关注着自己哦");
		return;
	}
	$.ajax({
        type: "POST",
        url: "userManageController/follows.do",
        data: data,
        success: function(data){
        	console.log(data);
        	if(data!=0){
        		$(obj).html("已关注");
        		$(obj).parent().css("letter-spacing","0px").css("font-size","12px");
        	}
        }
    })	
}
function addPic(userID,headImg,userName,dailyID,pictureUrl,content,loved,uuid){
	var pictureHtml="<div class='pictureDiv'>"+
			"		<div class='userInfo'>"+
			"			<a class='user_headImg' href='#'>"+
			"			<img class='user_img'  src='"+headImg+"'>"+
			"			</a>"+
			"			<a class='user_userName' href='#'>"+userName+"</a>"+
			"			<a class='user_follow'><span onclick=\"follow('"+userID+"',this)\">关注</span></span></a>"+
			"		</div>"+
			"		<div class='img'>"+
			"			<img src='http://127.0.0.1:8080/image/"+pictureUrl+"'" +
					" onclick=\"zhanshi('http://127.0.0.1:8080/image/"+pictureUrl+"')\">"+
			"		</div>";
			if(content!=""){				
				pictureHtml+="<div class='user_content'>"+content+"</div>" +
						"<div class='actbar hr'>";
			}
			else{
				pictureHtml+="<div class='actbar'>";
			}
					
			pictureHtml+="	<a class='user_loved'><img src='module/img/loveF.png' onclick=\"lovedClick('"+dailyID+"','"+uuid+"',this)\"></a>"+
			"			<span class='user_lovedCount'><span class='"+uuid+"'>"+loved+"</span>人喜欢</span>"+
			"		</div>"+
			"	</div>";
	return pictureHtml;
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
	        	$(".center").after(footHtml);
	        	getlast=1;
	        	setTimeout("refresh()",1000);      	
        	}    
        	
    	}
    });
	
}
function S4() {
    return (((1+Math.random())*0x10000)|0).toString(16).substring(1);
}
function getuuid() {
    return (S4()+S4()+"-"+S4()+"-"+S4()+S4());
}