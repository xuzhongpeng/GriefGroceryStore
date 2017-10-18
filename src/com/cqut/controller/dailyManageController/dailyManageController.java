package com.cqut.controller.dailyManageController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqut.entity.dailyManage.daily;
import com.cqut.service.dailyManage.IdailyManageService;
import com.cqut.tool.util.EntityIDFactory;
@Controller
@RequestMapping("/dailyManageController")
public class dailyManageController {
	@Resource(name = "dailyManageService")
	IdailyManageService service;
	
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
	
	@RequestMapping("/save")
	@ResponseBody
	public JSONObject save( 
			String userID,
			 int contentType,        
			 String title,               
			 String content,
			 String pictureID,              
			 String musicSrc,HttpServletRequest req) {
		
		daily daily=new daily();
		daily.setID(EntityIDFactory.createId());
		daily.setContentType(contentType);
		daily.setUserID(userID);
		daily.setTitle(title);
		daily.setContent(content);
		daily.setPictureID(pictureID);
		daily.setMusicSrc(musicSrc);
		
		daily.setReleaseTime(new Date());
		
			
		int result = service.save(daily);
		if(result==1){
			return JSONObject.fromObject(service.fineByID(daily.getID()));
		}
		 return null;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public int update(
			String id,       
			 int contentType,        
			 String title,               
			 String content,
			 String pictureID,              
			 String releaseTime,HttpServletRequest req) {
		
		daily daily=new daily();
		daily.setID(id);
		daily.setContentType(contentType);
		daily.setTitle(title);
		daily.setContent(content);
		daily.setPictureID(pictureID);
		if(releaseTime!=""){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		    Date date=new Date();
			try {
				date = sdf.parse(releaseTime);
			} catch (ParseException e) {
				
				e.printStackTrace();
			}  
			daily.setReleaseTime(date);
		}
			
		int result = service.update(daily);
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
	@RequestMapping("/getAllInfo")
	@ResponseBody
	public JSONObject getAllInfo(
			String userID,int limit,int offset,HttpServletRequest req) {		
		Map<String, Object> result = service.getAllInfo(userID,limit,offset);
		return JSONObject.fromObject(result);
	}
	@RequestMapping("/likes")
	@ResponseBody
	public int likes(
			String dailyID,int type,HttpServletRequest req) {		
		
		return service.likes(dailyID,type);
	}
	@RequestMapping("/getHotDaily")
	@ResponseBody
	public JSONObject getHotDaily(int limit,int offset,HttpServletRequest req) {		
		Map<String, Object> result = service.getHotDaily(limit,offset);
		return JSONObject.fromObject(result);
	}
	
	@RequestMapping("/getPictureDaily")
	@ResponseBody
	public JSONObject getPictureDaily(int limit,int offset,HttpServletRequest req) {		
		Map<String, Object> result = service.getPictureDaily(limit,offset);
		return JSONObject.fromObject(result);
	}
	@RequestMapping("/getPersonPictureDaily")
	@ResponseBody
	public JSONObject getPersonPictureDaily(int limit,int offset,String userID,HttpServletRequest req) {		
		Map<String, Object> result = service.getPersonPictureDaily(limit,offset,userID);
		return JSONObject.fromObject(result);
	}
}
