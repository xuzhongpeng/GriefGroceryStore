$(function(){
	
	var head=document.getElementById("header");
	var headhtml="<img class='logo' id='logo' src='module/jsp/header/img/biaoti.png'/>"
					+"	<ul>"
					+	"	<li class='a indexPu' src='module/jsp/index.jsp'>铺子首页</li>"
					+	"	<li class='a hotPu' src='module/jsp/main/HotMessage.jsp'>热门铺子</li>"
					+	"	<li class='a picturePu' src='module/jsp/main/pictureView.jsp'>图片铺</li>"
					+"		<li class='a typePu' src='module/jsp/main/classification.jsp'>分类</li>"
					+"		<li class='a personPu' src='module/jsp/main/personalInformation.jsp'>个人信息</li>"
					+"      <li class='a'>更多"
					+"				<div id='menu'><div class='sanjiao'></div>"
					+"           <ul class='xiala'>";
	if(!getCookie("USERID")){
		headhtml+=	    "       	<li class='b'><a href='module/jsp/login.jsp'> 登录</a></li>"
					+	"       	<li class='b'><a href='#'> 注册</a></li>";
	}	
	else{
		headhtml+="       	<li class='b'><a href='#'>" +
				"          永无岛</a></li>"
			+	"       	<li class='b'><a href='module/jsp/login.jsp'> 退出</a></li>";
	}
		headhtml+="			</ul></div></li>"
					+"	</ul>";
	head.innerHTML=headhtml;
	$(".a").click(function(){
		var href=$(this).attr("src");
		if(href!=undefined)
			location.href=href;
		else{
			var menu=$("#menu");
			if(menu.css("margin-top")!="0px"){
				menu.animate({
			    marginTop:"0px"
			  },400);;
			}
			else{
				menu.animate({
			    marginTop:"-400px"
			  },400);;
			}
		}
	})
	$(document).click(function(e){
		if($(e.target).attr('class')!="a"){
       	$("#menu").animate({
			    marginTop:"-400px"
			  },400);;
       }
        e.stopPropagation();
    })
    /*登录判断*/
})
