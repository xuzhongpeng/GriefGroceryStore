package com.cqut.controller.picture;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.cqut.entity.picture.Picture;
import com.cqut.service.picture.IPictureService;
import com.cqut.tool.util.EntityIDFactory;


@Controller
@RequestMapping("/pictureController")
public class pictureController {
	@Resource(name = "pictureService")
	IPictureService service;
	
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
	public int update(String id,       
			 String url,        
			 String pictureName,               
			 String userID,
			 String pulishTime,              
			 String describe,HttpServletRequest req) {
		Picture picture=new Picture();
		picture.setID(id);
		picture.setUrl(url);
		picture.setPictureName(pictureName);
		picture.setUserID(userID);
		
		picture.setPicDescribe(describe);
		
		if(pulishTime!=""){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		    Date date=new Date();
			try {
				date = sdf.parse(pulishTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			picture.setPulishID(date);
		}
		System.out.println(picture);
		int result = service.update(picture);
		return result;
	}
	@RequestMapping("/shenhe")
	@ResponseBody
	public int shenhe(String id      
			,HttpServletRequest req) {
		
		int result = service.shenhe(id);
		return result;
	}
	/*图片上传*/
	
	@SuppressWarnings("deprecation")
	@RequestMapping("/upload1")
	@ResponseBody
	public JSONObject addFile(HttpServletRequest request,
			HttpServletResponse response)
			throws IllegalStateException, IOException {
		String uid=request.getParameter("uid");//获取uid
		String pid=request.getParameter("pid");//获取jsp id参数
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				MultipartFile file = multiRequest.getFile(iter.next());
				if (file != null) {
					String myFileName = file.getOriginalFilename();
					if (myFileName.trim() != "") {
						String fileName = file.getOriginalFilename();
						String fileExt = fileName.substring(
								fileName.lastIndexOf(".") + 1).toLowerCase();
						SimpleDateFormat df = new SimpleDateFormat(
								"yyyyMMddHHmmss");
						String newFileName = df.format(new Date());
						String fileNames = newFileName
								+ new Random().nextInt(1000) + "." + fileExt;
						String path1 = request.getContextPath();
						 String path = request.getSession().getServletContext().getRealPath("/").replace("GriefGroceryStore\\", "")
								 +"picture\\"+fileNames;//上传路径
						 
						File localFile = new File(path);
						if (!localFile.exists()) {// 如果文件夹不存在，自动创建
							localFile.mkdirs();
						}
						file.transferTo(localFile);
						Picture pic=new Picture();
						pic.setID(EntityIDFactory.createId());
						pic.setPictureName(fileName);
						pic.setUrl(fileNames);
						pic.setUserID(uid);
						pic.setPulishID(new Date());
						pic.setState(1);
						service.save(pic);
						return JSONObject.fromObject(pic);
					}
				}
			}			
		}
		return JSONObject.fromObject("0");
	}	
}
