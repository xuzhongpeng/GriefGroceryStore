package com.cqut.controller.comment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqut.entity.comment.Comment;
import com.cqut.service.comment.ICommentService;



@Controller
@RequestMapping("/commentController")
public class commentController {
	
	@Resource(name ="commentService")
	ICommentService service;
	
	
	
	@RequestMapping("/getWithPaging")
	@ResponseBody
	public JSONObject getWithPaging(String name,HttpServletRequest req) {
		Object session = req.getSession().getAttribute("EMPLOYEEID");
		String uploader = "";
		if (session != null) {
			uploader = session.toString();
		}
		int limit=10;
		int offset=0;
		String order="asc";
		String sort="ID";
		Map<String, Object> result = service.getWithPaging(limit,
				offset, order, sort,name);
		return JSONObject.fromObject(result);
	}
	  
	@RequestMapping("/update")
	@ResponseBody
	public int update(
			String id,       
			 String dailyID,        
			 String userName,               
			 String comment,
			 String commentTime,  
			 String useredName,HttpServletRequest req) {
		
		Comment comm=new Comment();
		comm.setID(id);
		comm.setDailyID(dailyID);
		comm.setComment(comment);
		if(commentTime!=""){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		    Date date=new Date();
			try {
				date = sdf.parse(commentTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			comm.setCommentTime(date);
		}
		
		int result = service.update(comm);
		return result;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public int delete(
			String id,HttpServletRequest req) {
		//String[] id= new String(req.getParameter("userid").getBytes("iso8859-1"),"utf-8")[];
		System.out.println("controller:"+id.toString());
		String Id=id.replace("\"", "").replace("[", "").replace("]", "").trim();
		String[] uid=Id.split(",");
		int result = service.delete(uid);
		return result;
	}
	@RequestMapping("/add")
	@ResponseBody
	public JSONObject add(
			String dailyID,String commentContent,String userID,HttpServletRequest req) {
		Comment comment=new Comment();
		comment.setDailyID(dailyID);
		comment.setComment(commentContent);
		comment.setUseredID(userID);
		comment.setCommentTime(new Date());
		int result = service.add(comment);
		if(result!=0){
			return JSONObject.fromObject(comment);
		}
		return JSONObject.fromObject("false");
	}
	
	@RequestMapping("/getCommentbyDailyID")
	@ResponseBody
	public JSONArray getCommentbyDailyID(
			String dailyID,HttpServletRequest req) {		
		List<Map<String, Object>> result = service.getbyDailyID(dailyID);
		return JSONArray.fromObject(result);
	}
}
