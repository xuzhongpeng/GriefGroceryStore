$(function(){
	
	$("#save").click(function(){
		
	});
	$("#delete").click(function(){
		
	});
	
	
})
/*添加表单*/
function addEditHtml(object) {
    var editHtml="";
    editHtml+=head;
    editHtml=editHtml+" <div style='display:none' >"
    +"   <input type='text' name='ID' id='id'>" +
    		"</div>";
    for(var key in object){
    	
    	if(object[key].type=="select"){
    	editHtml=editHtml+" <div class='am-form-group'>"
           +"<label for='user-phone' class='am-u-sm-3 am-form-label'>"+object[key].value +"</label>"
           +"<div class='am-u-sm-9'>"
           +"    <select id='"+key+"' data-am-selected='{searchBox: 1}'>";
		   for(var obj in object[key].data){
			   editHtml=editHtml+"<option value='"+object[key].data[obj].values+"'>"+object[key].data[obj].mean+"</option>"
		   }
		   editHtml=editHtml+"</select>			"
	           +"</div>"
	           +"</div>";
    	}else if(object[key].type=="hidden"){
    		editHtml+=""
        		  +" 	<div class='am-form-group' style='display:none'>"
        		  +"     <label for='"+key+"' class='am-u-sm-3 am-form-label'>"+object[key].value+"</label>"
        		  +"     <div class='am-u-sm-9'>"
        		  +"         <input type='"+object[key].type+"' id='"+key+"' name='"+key+"' placeholder='"+object[key].value+"'>"
        		  +"     </div>"
        		  +" </div>";
    	}
    	else if(object[key].type=="img"){
    		editHtml+="<div class='am-form-group'>"
			            +"<label for='user-weibo' class='am-u-sm-3 am-form-label'>"+object[key].value
			            +		" <span class='tpl-form-line-small-title'>Images</span></label>"
			            +"<div class='am-u-sm-9'>"
			            +"    <div class='am-form-group am-form-file'>"
			            +"        <div class='tpl-form-file-img'>"
			            +"            <img id='"+key+"' src='"+object[key].src+"' alt=''>"
			            +"        </div>"
			            +"    </div>"
			            +"</div>"
			            +"</div>";
    	}
    	else{
        	editHtml+=""
      		  +" 	<div class='am-form-group' style='height:35px;'>"
      		  +"     <label for='"+key+"' class='am-u-sm-3 am-form-label'>"+object[key].value+"</label>"
      		  +"     <div class='am-u-sm-9'>"
      		  +"         <input type='"+object[key].type+"' id='"+key+"' name='"+key+"' placeholder='"+object[key].value+"'>"
      		  +"     </div>"
      		  +" </div>";
          	}
    }
    editHtml+=footer;
    return editHtml;
}
var head ="\
<div id='edit' title='' style='display:none;width:50%;height:350px;position:absolute;top:0px;z-index:10;left:30px;\
    background: #ffc url(mid.jpg) repeat-y center;left: 25%;'>\
    	<div class='tpl-portlet-components'>\
    <div class='portlet-title'>\
        <div class='caption font-green bold'>\
            <span class='am-icon-code'></span> 增加\
        </div>\
    </div>\
    <div class='tpl-block '>\
        <div class='am-g tpl-amazeui-form'>\
            <div class='am-u-sm-12 am-u-md-9'>\
                <form class='am-form am-form-horizontal'>";
var footer="\
			 <div class='am-form-group'>\
		    <div class='am-u-sm-9 am-u-sm-push-3'>\
		        <button type='button' id='savethis' class='am-btn am-btn-primary'>保存修改</button>\
		        <button type='button' id='cancl' class='am-btn am-btn-primary'>取消</button>\
		    </div>\
		</div>\
		</form>\
		</div>\
		</div>\
		</div>\
		</div>\
	 </div>";


/*表格的添加*/
function addHtml(person,index){
	var tableHtml ="";
	 tableHtml+="<tr>";
	tableHtml+="<td ><input class='checkbox' value='"+person.ID+"' type='checkbox'></td>";
	 for(var key in person){  
		 
		  if(person[key].type=="hidden"){
			 tableHtml+="<td style='display:none' class='td"+index+"'>"+person[key].value+"</td>";
		 }else{
			 tableHtml+="<td class='td"+index+"'>"+person[key]+"</td>";
		 }
		 
		 
	}    	
	 var tableHtml=tableHtml+"     <td>"
	         +"         <div class=''>"
	         +"             <div class='am-btn-group am-btn-group-xs'>"
	         +"                 <button title='td"+index+"' class='am-btn am-btn-default am-btn-xs am-text-secondary ' onclick='update1(this);return false;'><span class='am-icon-pencil-square-o'></span> 编辑</button>"
	         +"                 <button class='am-btn am-btn-default am-btn-xs am-hide-sm-only'><span class='am-icon-copy'></span> 复制</button>"
	         +"                 <button title='td"+index+"' class='am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only' onclick='deleteThis(this);return false;'><span class='am-icon-trash-o'></span> 删除</button>"
	         +"             </div>"
	         +"         </div>"
	         +"     </td>"
	         +" </tr>";
return tableHtml;
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
           
                