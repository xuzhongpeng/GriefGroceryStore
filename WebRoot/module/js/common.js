
function picture(uuid,dailyID,userName,userImg,imgsrc,content,releaseTime,loved,userID){
	var pictureStr=""
	+" <div class='animation info1'>		"
	+		"<input  id='"+uuid+"'  type='hidden' value='"+dailyID+"'>"
	+"		<a href='module/jsp/main/personHomepage.jsp?personID="+userID+"'>" 
	+"		<img class='headeImg' src='"+userImg+"'></img></a>"
	+"		<div class='centerDiv'>"
	+"			<div class='triangle'></div>"
	+"			<div class='information'>"
	+"				<a class='userName' href='module/jsp/main/personHomepage.jsp?personID="+userID+"'>"+userName+"</a>"
	+"				<img class='picture' src='http://127.0.0.1:8080/image/"+imgsrc+"'>"
	+"				<p class='whatIsay'>"+content+"</p>	"
	+"				<div class='interactive'>" +
	"					<span class='pulishTime'>"+releaseTime+"</span>"
	+"					<span class='opti'><img class='love' title='love' src='module/img/loveF.png' onclick=\"lovedClick('"+dailyID+"','"+uuid+"',this)\"></span>"
	+"					<span class='opti'><a class='js-121488' >分享</a></span>"
	+"					<span class='opti'><a class='js-121488 commentOn' onclick=\"comment('"+uuid+"')\">评论</a></span>"
	+"					<span class='opti'><a class='js-121488' >喜欢(<span class='love"+uuid+"'>"+loved+"</span>)</a></span>"
	+"				</div>"
	+"				<div class='comment "+uuid+"' >"
	+"					<hr class='thisHr'>"
	+"					<textarea  type='textarea' class='inputComment' onfocus='inputFocus(this)' onblur='inputblur(this)' placeholder='说出你的想法'></textarea>"
	+"					<button class='button postComment' onclick=\"postComment('"+dailyID+"',this,'"+uuid+"')\">发表</button>"
	+"				</div>"
	+"			</div>"
	+"		</div>"
	+"	</div>";
	return pictureStr;
}

function textHtml(uuid,dailyID,userName,userImg,content,releaseTime,loved,userID){
	var textStr=""
	+" <div class='animation info1'>		" 
	+		"<input id='"+uuid+"' type='hidden' value='"+dailyID+"'>"
	+"		<a href='module/jsp/main/personHomepage.jsp?personID="+userID+"'>" 
	+"		<img class='headeImg' src='"+userImg+"'></img></a>"
	+"		<div class='centerDiv'>"
	+"			<div class='triangle'></div>"
	+"			<div class='information'>"
	+"				<a class='userName' href='module/jsp/main/personHomepage.jsp?personID="+userID+"'>"+userName+"</a>"
	+"				<p class='whatIsay'>"+content+"</p>	"
	+"				<div class='interactive'>" +
			"			<span class='pulishTime'>"+releaseTime+"</span>"
	+"					<span class='opti'><img class='love' title='love' src='module/img/loveF.png' onclick=\"lovedClick('"+dailyID+"','"+uuid+"',this)\"></span>"
	+"					<span class='opti'><a class='js-121488'>分享</a></span>"
	+"					<span class='opti'><a class='js-121488 commentOn' onclick=\"comment('"+uuid+"')\">评论</a></span>"
	+"					<span class='opti'><a class='js-121488'>喜欢(<span class='love"+uuid+"'>"+loved+"</span>)</a></span>"
	+"				</div>"
	+"				<div class='comment "+uuid+"'>"
	+"					<hr class='thisHr'>"
	+"					<textarea  type='textarea' class='inputComment' onfocus='inputFocus(this)' onblur='inputblur(this)'  placeholder='说出你的想法'></textarea>"
	+"					<button class='button postComment' onclick=\"postComment('"+dailyID+"',this,'"+uuid+"')\">发表</button>"
	+"				</div>"
	+"			</div>"
	+"		</div>"
	+"	</div>";
	return textStr;
}
function article(uuid,dailyID,userName,userImg,content,releaseTime,title,loved,userID){
	var articleStr=""
	+" <div class='animation info1'>		"
	+		"<input id='"+uuid+"' type='hidden' value='"+dailyID+"'>"
	+"		<a href='module/jsp/main/personHomepage.jsp?personID="+userID+"'>" 
	+"		<img class='headeImg' src='"+userImg+"'></img></a>"
	+"		<div class='centerDiv'>"
	+"			<div class='triangle'></div>"
	+"			<div class='information'>"
	+"				<a class='userName' href='module/jsp/main/personHomepage.jsp?personID="+userID+"'>"+userName+"</a>"
	+"              <h3 class='articleTitle'>"+title+"</h3>"
	+"				<p class='whatIsay'>"+content+"</p>	"
	+"				<div class='interactive'>"+
	"					<span class='pulishTime'>"+releaseTime+"</span>"
	+"					<span class='opti'><img class='love' title='love' src='module/img/loveF.png' onclick=\"lovedClick('"+dailyID+"','"+uuid+"',this)\"></span>"
	+"					<span class='opti'><a class='js-121488'>分享</a></span>"
	+"					<span class='opti'><a class='js-121488 commentOn' onclick=\"comment('"+uuid+"')\">评论</a></span>"
	+"					<span class='opti'><a class='js-121488'>喜欢(<span class='love"+uuid+"'>"+loved+"</span>)</a></span>"
	+"				</div>" 
	+"				<div class='comment "+uuid+"'>"
	+"					<hr class='thisHr'>"
	+"					<textarea  type='textarea' class='inputComment' onfocus='inputFocus(this)' onblur='inputblur(this)'  placeholder='说出你的想法'></textarea>"
	+"					<button class='button postComment' onclick=\"postComment('"+dailyID+"',this,'"+uuid+"')\">发表</button>"
	+"				</div>"
	+"			</div>"
	+"		</div>"
	+"	</div>";
	return articleStr;
}
/*废弃*/
function music(){
	var musicStr=""
	+" <div class='animation info1'>		"
	+		"<input  id=''  type='hidden' value=''>"
	+"		<img class='headeImg' src='module/img/touxiang/zhangwanqing.jpg'></img>"
	+"		<div class='centerDiv'>"
	+"			<div class='triangle'></div>"
	+"			<div class='information'>"
	+"				<a class='userName' href='module/jsp/main/personHomepage.jsp?personID='>永无岛</a>"
	+"				<div class='music'>"
	+"					<p>爱你就像爱生命</p>"
	+"					<iframe frameborder='no' border='0' marginwidth='0' marginheight='0' width=330 height=86 src='http://music.163.com/outchain/player?type=2&id=427016671&auto=0&height=66'></iframe>"
	+"				</div>"
	+"				<div class='interactive'>"
	+"					<span class='opti'><img class='love' title='love' src='module/img/loveF.png'></span>"
	+"					<span class='opti'><a class='js-121488'>喜欢(1)</a></span>"
	+"				</div>"
	+"				<div class='comment'>"
	+"					<hr class='thisHr'>"
	+"					<textarea  type='textarea' class='inputComment' onfocus='inputFocus(this)' onblur='inputblur(this)'  placeholder='说出你的想法'></textarea>"
	+"					<button class='button postComment' onclick=\"postComment('')\">发表</button>"
	+"					"
	+"					<div class='userComment'>"
	+"						<hr class='thisHr'>"
	+"						<img src='module/img/touxiang/zhangwanqing.jpg'></img>"
	+"						<div class='commentInfo'><p>打飞机阿道夫骄"
	+"						"
	+"						</p></div>"
	+"					</div>"
	+"				</div>"
	+"			</div>"
	+"		</div>"
	+"	</div>";
	return musicStr;
}

function Format(data,fmt) { //author: meizz 
	if(data==undefined){
		return data;
	}
	if(!'month' in data){
		return data;
	}
    var o = {
        "M+": data.month + 1, //月份 
        "d+": data.date, //日 
        "h+": data.hours, //小时 
        "m+": data.minutes, //分 
        "s+": data.seconds, //秒 
        "q+": Math.floor((data.month + 3) / 3), //季度 
       // "S": this.milliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (data.year.toString().replace("1","20") + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}
function S4() {
    return (((1+Math.random())*0x10000)|0).toString(16).substring(1);
}
function getuuid() {
    return (S4()+S4()+"-"+S4()+"-"+S4()+S4());
}