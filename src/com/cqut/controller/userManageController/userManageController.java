package com.cqut.controller.userManageController;

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

import com.cqut.entity.userManage.userManage;
import com.cqut.service.userManage.IUserManageService;

@Controller
@RequestMapping("/userManageController")
public class userManageController {

	@Resource(name = "userManageService")
	IUserManageService service;
	
	
	@RequestMapping("/getuserManageWithPaging")
	@ResponseBody
	public JSONObject getuserManageWithPaging(String name,HttpServletRequest req) {
		Object session = req.getSession().getAttribute("EMPLOYEEID");
		String uploader = "";
		if (session != null) {
			uploader = session.toString();
		}
		int limit=10;
		int offset=0;
		String order="asc";
		String sort="ID";
		Map<String, Object> result = service.getuserManageWithPaging(limit,
				offset, order, sort,name);
		return JSONObject.fromObject(result);
	}
	@RequestMapping("/save")
	@ResponseBody
	public int save(
			String userID,
			String userName,       
			 String password,        
			 int type,               
			 String registerTime,
			 String email,              
			 String headImg,HttpServletRequest req) {
		
		userManage user=new userManage();
		user.setUserID(userID);
		user.setUserName(userName);
		user.setPassword(password);
		user.setType(type);
		System.out.println("registerTime"+registerTime);
		if(registerTime!=""&&registerTime!=null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		    Date date=new Date();
			try {
				date = sdf.parse(registerTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		user.setRegisterTime(date);
		}
		else{
			user.setRegisterTime(new Date());
		}
		user.setEmail(email);
		user.setHeadImg(headImg);
		//System.out.println(user.toString()+registerTime);	
		int result = service.save(user);
		return result;
	}
	@RequestMapping("/update")
	@ResponseBody
	public int update(
			String id,
			String userName,       
			 String password,        
			 int type,               
			 String registerTime,
			 String email,              
			 String headImg,HttpServletRequest req) {
		
		userManage user=new userManage();
		user.setUserID(id);
		user.setUserName(userName);
		user.setPassword(password);
		user.setType(type);
		if(registerTime!=""&&registerTime!=null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		    Date date=new Date();
			try {
				date = sdf.parse(registerTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			user.setRegisterTime(date);
		}
		
		user.setEmail(email);
		user.setHeadImg(headImg);	
		int result = service.update(user);
		System.out.println(result);
		return result;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public int delete(
			String userid,HttpServletRequest req) {
		//String[] id= new String(req.getParameter("userid").getBytes("iso8859-1"),"utf-8")[];
		System.out.println("controller:"+userid.toString());
		String id=userid.replace("\"", "").replace("[", "").replace("]", "").trim();
		String[] uid=id.split(",");
		int result = service.delete(uid);
		return result;
	}
	@RequestMapping("/getByName")
	@ResponseBody
	public JSONArray getByName(
			String name,String password,String type,HttpServletRequest req) {
		
		
		
		List<userManage> result = service.getByName(name,password,type);
		return JSONArray.fromObject(result);
	}
	@RequestMapping("/getByID")
	@ResponseBody
	public JSONArray getByID(
			String userID,HttpServletRequest req) {
		
		List<userManage> result = service.getByID(userID);
		return JSONArray.fromObject(result);
	}
	@RequestMapping("/follows")
	@ResponseBody
	public int follows(
			String userID,String friendID,HttpServletRequest req) {
		
		int result = service.followFriend(userID,friendID);
		return result;
	}
}
