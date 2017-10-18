$(function(){
	//var user=new person("1","1","3","4","5","6","7");
	//console.log(addHtml(user));
	//$("#tbody").append(addHtml(user));
	
	/*初始化*/
	fresh("");
	$("#add").attr("disabled", true); 
	/*$("#add").click(function(){
		$("#edit").css("display","block");
		$("#edit").attr("title","add");
	});*/
	object={
			userName:{type:"text",value:"用户名"},
			userID:{type:"hidden",value:"userID"},
			contentType:{type:"select",value:'发表类型',data:[{values:1,mean:"一般说说"},{values:2,mean:"图片说说"},{values:3,mean:"文章"}]},
			title:{type:"text",value:'标题'},
			content:{type:"text",value:'内容'},
			pictureID:{type:"text",value:'图片id'},
			releaseTime:{type:"date",value:'发表时间'}		
	}
	
	$("#table").after(addEditHtml(object));
	$("#cancl").click(function(){
		$("#edit").css("display","none");
		
	});
	
	 /*保存*/
	 $("#savethis").click(function(){
		 var id=$("#id").val();
		 var userName=$("#userName").val();
		 var userID=$("#userID").val();
		 var contentType=$("#contentType").val();
		 var title=$("#title").val();
		 var content=$("#content").val();
		 var pictureID=$("#pictureID").val();
		 var releaseTime=$("#releaseTime").val();
		 var data={  
				 id:id,
				 userName:userName, 
				 userID:userID,
				 contentType:contentType,        
				 title:title,               
				 content:content,
				 pictureID:pictureID,              
				 releaseTime:releaseTime,         
		 }
		 var type=$("#edit").attr("title");
		 
			 $.ajax({
		         type: "POST",
		         url: "dailyManageController/update.do",
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
		 
	 })
	 /*删除*/
	 $("#delete").click(function(){
		 var checkedbox=new Array();
		 var check=$(".checkbox");
		 for(var i=0;i<check.length;i++){ 
		 if(check[i].checked){
			 checkedbox.push(check[i].value);
		 }
		 deleteAjax(checkedbox);
		 }
	 })
	 /*刷新*/
	 $("#refresh").click(function(){
		 fresh("");
	 })
	 /*查找*/
	 $("#search").click(function(){
		 var name=$("#searchData").val();
		 var data={
				 name:name
		 }
		 fresh(data);
	 })
	 $("#contentType").find("option[text='图片说说']").attr("selected",true);
})
function fresh(data){
	
/*初始化*/
	 $.ajax({
         type: "POST",
         url: "dailyManageController/getWithPaging.do",
         data: data,
         success: function(data){
        	 	data=eval('(' + data + ')');
        	 	$("#tbody").empty();
        	 	for(var i=0;i<data.rows.length;i++){
        	 	var releaseTime=Format(data.rows[i].releaseTime,"yyyy-MM-dd");
        	 	var contentType="";
        	 	if(data.rows[i].contentType==1){
        	 		contentType="一般说说";
        	 	}
        	 	else if(data.rows[i].contentType==2){
        	 		contentType="图片说说";
        	 	}
        	 	else{
        	 		contentType="文章";
        	 	}
        	 	
        	 	var daily=new person(data.rows[i].ID,data.rows[i].userName,{type:'hidden',value:data.rows[i].userID},
        	 			contentType,
        	 			data.rows[i].title,data.rows[i].content,data.rows[i].pictureID,releaseTime);
        	 	$("#tbody").append(addHtml(daily,i));
        	 	}
            }
      });
}
function person(ID,userName,userID,contentType,title,content,pictureID,releaseTime)
{
	this.ID=ID;
	this.userName=userName;
	this.userID=userID;
	this.contentType=contentType;
	this.title=title;	
	this.content=content;
	this.pictureID=pictureID;
	this.releaseTime=releaseTime;
}
/*编辑*/
function update1(obj){
	var thisTd=$(obj).attr("title");
	var content=$('.'+thisTd);
	var text=new Array();
	for(var i=0;i<content.length;i++){
		text[i]=content.eq(i).html();
	}
	$("#edit").css("display","block");
	$("#edit").attr("title","update");
	$("#userName").attr("disabled", true); 
	
	$("#id").val(text[0]);
	$("#userName").val(text[1]);
	$("#userID").val(text[2]);
	$("#contentType").find("option[text='"+text[3]+"']").attr("selected",true);
	$("#title").val(text[4]);
	$("#content").val(text[5]);
	$("#pictureID").val(text[6]);
	$("#releaseTime").val(text[7]);	
}
function deleteThis(obj){
	var thisTd=$(obj).attr("title");
	var userId1=$('.'+thisTd).eq(0).html();
	id=new Array();
	id[0]=userId1;
	deleteAjax(id);
}
function deleteAjax(id){
	data={
			id:JSON.stringify(id)
		}
		
		 $.ajax({
	         type: "POST",
	         url: "dailyManageController/delete.do",
	         dataType: "json", 
	         data: data,
	         success: function(data){		        	 
	        	 if(data>0){
	        		 
		        	 location.reload();
	        	 }
	        	 else{
	        		 alert("删除失败");
	        	 }
	            }
		 });
}
	


