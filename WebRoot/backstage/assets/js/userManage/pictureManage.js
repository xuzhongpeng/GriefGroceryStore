$(function(){
	fresh();
	object={
			ID:{type:"hidden",value:"ID"},
			pictureName:{type:"text",value:'图片名称'},
			img:{type:"img",value:'上传图片'},
			userID:{type:"text",value:'上传用户'},
			pulishTime:{type:"date",value:'上传时间'},
			describe:{type:"text",value:'描述'}	
		}
	$("#table").after(addEditHtml(object));
	$("#add").click(function(){
		$("#edit",window.parent.document).css("display","block");
		$("#edit",window.parent.document).css("top","80px");
		$("#edit",window.parent.document).attr("title","add");
	});
	$('#default',window.parent.document).after(addEditHtml(object));
	$("#cancl",window.parent.document).click(function(){
		$("#edit",window.parent.document).css("display","none");
	});
	/*保存*/
	$("#savethis",window.parent.document).click(function(){
		 var id=$("#ID",window.parent.document).val();
		 var url=$("#img",window.parent.document).attr("src");
		 var pictureName=$("#pictureName",window.parent.document).val();
		 var userID=$("#userID",window.parent.document).val();
		 var pulishTime=$("#pulishTime",window.parent.document).val();
		 var describe=$("#describe",window.parent.document).val();
		 var data={  
				 id:id,    
				 url:url,        
				 pictureName:pictureName,               
				 userID:userID,
				 pulishTime:pulishTime,              
				 describe:describe      
		 }
		 $.ajax({
	         type: "POST",
	         url: "pictureController/update.do",
	         data: data,
	         success: function(data){		        	 
	        	 if(data==1){
	        		 $("#edit").css("display","none");
		        	 location.reload();
	        	 }
	        	 else{
	        		 alert("保存失败");
	        	 }
	            }
		 });
	});	
	/*编辑*/
	$("#updatethis").click(function(){
		
	})
})
/*初始化*/
function fresh(data){
 $.ajax({
     type: "POST",
     url: "pictureController/getWithPaging.do",
     data: data,
     success: function(data){
    	 	data=eval('(' + data + ')');
    	 	$("#pictureDiv").remove();
    	 	for(var i=0;i<data.rows.length;i++){
    	 	var pulishTime=Format(data.rows[i].pulishTime,"yyyy-MM-dd");
    	 	var url="http://127.0.0.1:8080/image/"+data.rows[i].url;
    	 	var pic=new picture(data.rows[i].ID,data.rows[i].pictureName,url,
    	 			data.rows[i].userID,data.rows[i].userName,data.rows[i].picDescribe,data.rows[i].state,
    	 			pulishTime,data.rows[i].headImg);
    	 	$("#picture").prepend(addpic(pic,i));
    	 	}
        }
  });
}
function picture(ID,pictureName,url,userID,userName,describe,state,pulishTime,headImg)
{
	this.ID=ID,    
	this.pictureName=pictureName,        
	this.url=url,               
	this.userID=userID,
	this.userName=userName,
	this.describe=describe,   
	this.state=state,
	this.pulishTime=pulishTime,
	this.headImg=headImg	
}
/*编辑*/
function update1(obj){
	var thisTd=$(obj).attr("title");
	var content=$('.'+thisTd);
	var text=new Array();
	for(var i=0;i<content.length;i++){
		text[i]=content.eq(i).html();
	}
	text[0]=content.eq(0).val();
	text[1]=content.eq(1).val();
	text[4]=content.eq(4).attr("src");
	$("#edit",window.parent.document).css("display","block");
	$("#edit",window.parent.document).attr("title","update");
	
	/*不可修改的字段*/
	/*$("#dailyID").attr("disabled", true); 
	$("#userName").attr("disabled", true); 
	$("#useredName").attr("disabled", true); */

	
	$("#ID",window.parent.document).val(text[0]);
	$("#userID",window.parent.document).val(text[1]);
	//$("#img").val(text[2]);
	$("#pulishTime",window.parent.document).val(text[2]);
	$("#pictureName",window.parent.document).val(text[3]);
	$("#img",window.parent.document).attr("src",text[4]);
	$("#describe",window.parent.document).val(text[5]);
}
function shenhe(obj){
	var thisTd=$(obj).attr("title");
	var content=$('.'+thisTd);
	var id=content.eq(0).val();
	data={
			id:id
	}
	$.ajax({
        type: "POST",
        url: "pictureController/shenhe.do",
        data: data,
        success: function(data){		        	 
       	 if(data==1){
       		 $(obj).attr("disabled","true");
       		 $(obj).html("已审核");
       		 }
       	 else{
       		 alert("审核失败");
       	 }
           }
	 });
}
/*增加图片框*/
function addpic(data,i){
	
	
var picTtml=""
	+"	<div class='am-u-sm-12 am-u-md-6 am-u-lg-4' title='pictureDiv'>  "
	+"	    <div class='tpl-table-images-content'> " +
			"<input class='ud"+i+"' type='hidden' value='"+data.ID+"'>" +
		" <input class='ud"+i+"' type='hidden' value='"+data.userID+"'>      "
	+"	        <div class='tpl-table-images-content-i-time'>发布时间：" +
			"<span class='ud"+i+"'>"+data.pulishTime+"<span></div> "
	+"	         <div class='ud"+i+" tpl-i-title'>"+data.pictureName+"</div>                           "                                                    
	+"	        <a href='javascript:;' class='tpl-table-images-content-i'>                                                                         "
	+"	                                                                                                                                           "
	+"	            <span class='tpl-table-images-content-i-shadow'></span>                                                                        "
	+"	            <img class='ud"+i+"' src='"+data.url+"' alt=''>                                                                                 "
	+"	        </a>                                                                                                                               "
	+"	        <div class='tpl-table-images-content-block'> " ;
if(data.describe!=null){
	picTtml+="<div class='ud"+i+" tpl-i-font'>"+data.describe+"</div>";                   
}

picTtml+="	            <div class='tpl-i-more'>                                                                                                      "
	+"	                <ul>                                                                                                                       "
	+"	                    <div class='tpl-table-images-content-i-info'>                                                                          "
	+"	                        <span class='ico'  style='color:#333;'>                                                                            "
	+"	                            <img src='"+data.headImg+"' alt=''>"+data.userName+""
	+"	                         </span>		                                                                                                   "
	+"	                    </div>                                                                                                                 "
	+"	                </ul>                                                                                                                      "
	+"	            </div>                                                                                                                         "
	+"	            <div class='am-btn-toolbar'>                                                                                                   "
	+"	                <div class='am-btn-group am-btn-group-xs tpl-edit-content-btn'>  "
	+"	                    <button title='ud"+i+"'  onclick='update1(this);return false;' type='button' class='am-btn am-btn-default am-btn-secondary'><span class='am-icon-edit'></span> 编辑</button>  ";
	if(data.state==1){
		picTtml+="<button  title='ud"+i+"' onclick='shenhe(this);return false;' type='button' class='am-btn am-btn-default am-btn-warning' style='width: 90px !important;'><span class='am-icon-archive'></span> 审核通过</button> " ;
	}else{
		picTtml+="<button onclick='return false;' disabled='true' type='button' class='am-btn am-btn-default am-btn-warning'><span class='am-icon-archive'></span> 已审核</button> " ;
		}
	picTtml+="	                    <button onclick='deleteThis(this);return false;' type='button' class='am-btn am-btn-default am-btn-danger'><span class='am-icon-trash-o'></span> 删除</button>  "
	+"	                </div>                                                                                                                     "
	+"	            </div>                                                                                                                         "
	+"	        </div>                                                                                                                             "
	+"	    </div>                                                                                                                                 "
	+"	</div>";
return picTtml;
}

