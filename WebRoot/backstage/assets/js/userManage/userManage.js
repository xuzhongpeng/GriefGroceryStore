$(function(){
	//var user=new person("1","1","3","4","5","6","7");
	//console.log(addHtml(user));
	//$("#tbody").append(addHtml(user));
	$("#add").click(function(){
		$("#edit").css("display","block");
		$("#edit").attr("title","add");
	});
	object={
		userName:{type:"text",value:"姓名"},
		password:{type:"text",value:'密码'},
		type:{type:"select",value:'类型',data:[{values:1,mean:"管理员"},{values:2,mean:"用户"}]},
		registerTime:{type:"date",value:'注册时间'},
		email:{type:"text",value:'email'},
		headImg:{type:"text",value:'头像'}		
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
		 var userName=$("#userName").val();
		 var password=$("#password").val();
		 var type=$("#type").val();
		 var registerTime=$("#registerTime").val();
		 var email=$("#email").val();
		 var headImg=$("#headImg").val();
		 var data={  
				 id:id,
				 userName:userName,       
				 password:password,        
				 type:type,               
				 registerTime:registerTime,
				 email:email,              
				 headImg:headImg,         
		 }
		 var type=$("#edit").attr("title");
		 console.log(type);
		 if(type=="add"){
			 $.ajax({
		         type: "POST",
		         url: "userManageController/save.do",
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
		 }
		 else{
			 console.log("update");
			 $.ajax({
		         type: "POST",
		         url: "userManageController/update.do",
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
		 }
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
         url: "userManageController/getuserManageWithPaging.do",
         data: data,
         success: function(data){
        	 	data=eval('(' + data + ')');
        	 	$("#tbody").empty();
        	 	for(var i=0;i<data.rows.length;i++){
        	 	var registerTime=Format(data.rows[i].registerTime,"yyyy-MM-dd");
        	 	var user=new person(data.rows[i].userID,data.rows[i].userName,data.rows[i].password,
        	 			data.rows[i].type,registerTime,data.rows[i].email,data.rows[i].headImg);
        	 	$("#tbody").append(addHtml(user,i));
        	 	}
            }
      });
}
function person(ID,userName,password,type,registerTime,email,headImg)
{
	this.ID=ID;
	this.userName=userName;
	this.password=password;
	this.type=type;	
	this.registerTime=registerTime;
	this.email=email;
	this.headImg=headImg;
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
	$("#id").val(text[0]);
	$("#userName").val(text[1]);
	$("#password").val(text[2]);
	$("#type").find("option[text='用户']").attr("selected",true);
	$("#registerTime").val(text[4]);
	$("#email").val(text[5]);
	$("#headImg").val(text[6]);	
}
function deleteThis(obj){
	var thisTd=$(obj).attr("title");
	var userId1=$('.'+thisTd).eq(0).html();
	userid=new Array();
	userid[0]=userId1;
	deleteAjax(userid);
}
function deleteAjax(userid){
	data={
			userid:JSON.stringify(userid)
		}
		
		 $.ajax({
	         type: "POST",
	         url: "userManageController/delete.do",
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
	


