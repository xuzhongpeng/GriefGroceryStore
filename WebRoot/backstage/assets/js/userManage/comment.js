$(function(){
	//var user=new person("1","1","3","4","5","6","7");
	//console.log(addHtml(user));
	//$("#tbody").append(addHtml(user));
	$("#add").click(function(){
		$("#edit").css("display","block");
		$("#edit").attr("title","add");
	});
	object={
		ID:{type:"hidden",value:"ID"},
		dailyID:{type:"text",value:'评论内容ID'},
		userName:{type:"text",value:'被评论人'},
		comment:{type:"text",value:'评论内容'},
		commentTime:{type:"date",value:'评论时间'},
		useredName:{type:"text",value:'评论人'}	
	}
	
	$("#table").after(addEditHtml(object));
	$("#cancl").click(function(){
		$("#edit").css("display","none");
		
	});
	/*初始化*/
	fresh("");
	 /*保存*/
	 $("#savethis").click(function(){
		 var id=$("#id").val();
		 var dailyID=$("#dailyID").val();
		 var userName=$("#userName").val();
		 var comment=$("#comment").val();
		 var commentTime=$("#commentTime").val();
		 var useredName=$("#useredName").val();
		 var data={  
				 id:id,    
				 dailyID:dailyID,        
				 userName:userName,               
				 comment:comment,
				 commentTime:commentTime,              
				 useredName:useredName      
		 }
		 $.ajax({
	         type: "POST",
	         url: "commentController/update.do",
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
})
function fresh(data){
	
/*初始化*/
	
	 $.ajax({
         type: "POST",
         url: "commentController/getWithPaging.do",
         data: data,
         success: function(data){
        	 	data=eval('(' + data + ')');
        	 	$("#tbody").empty();
        	 	for(var i=0;i<data.rows.length;i++){
        	 	var commentTime=Format(data.rows[i].commentTime,"yyyy-MM-dd");
        	 	var user=new person(data.rows[i].ID,data.rows[i].dailyID,data.rows[i].userName,
        	 			data.rows[i].comment,commentTime,data.rows[i].useredName);
        	 	$("#tbody").append(addHtml(user,i));
        	 	}
            }
      });
}
function person(ID,dailyID,userName,comment,commentTime,useredName)
{
	this.ID=ID,    
	this.dailyID=dailyID,        
	this.userName=userName,               
	this.comment=comment,
	this.commentTime=commentTime,              
	this.useredName=useredName  
	
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
	
	/*不可修改的字段*/
	$("#dailyID").attr("disabled", true); 
	$("#userName").attr("disabled", true); 
	$("#useredName").attr("disabled", true); 
	
	
	$("#id").val(text[0]);
	$("#dailyID").val(text[1]);
	$("#userName").val(text[2]);
	$("#comment").val(text[3]);
	$("#commentTime").val(text[4]);
	$("#useredName").val(text[5]);
}
function deleteThis(obj){
	var thisTd=$(obj).attr("title");
	var userId1=$('.'+thisTd).eq(0).html();
	userid=new Array();
	userid[0]=userId1;
	deleteAjax(userid);
}
function deleteAjax(id){
	data={
			id:JSON.stringify(id)
		}
		
		 $.ajax({
	         type: "POST",
	         url: "commentController/delete.do",
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
	


