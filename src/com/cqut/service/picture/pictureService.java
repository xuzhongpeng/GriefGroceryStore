package com.cqut.service.picture;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cqut.dao.base.BaseEntityDao;
import com.cqut.dao.base.EntityDao;
import com.cqut.dao.base.SearchDao;
import com.cqut.entity.picture.Picture;
import com.cqut.service.base.SearchService;

@Service
public class pictureService  extends SearchService implements IPictureService{

	@Resource(name = "entityDao")
	EntityDao entityDao;

	@Resource(name = "searchDao")
	SearchDao searchDao;

	@Resource(name = "baseEntityDao")
	BaseEntityDao baseEntityDao;
	
	@Override
	public String getBaseEntityName() {
		// TODO Auto-generated method stub
		return "picture";
	}

	@Override
	public String getBasePrimaryKey() {
		// TODO Auto-generated method stub
		return "picture.ID";
	}
	
	@Override
	public Map<String, Object> getWithPaging(int limit, int offset,
			String order, String sort, String name) {
		int index = limit;
		int pageNum = offset / limit ;
		String baseEntity = "picture " +
				"LEFT JOIN USER ON `user`.userID = picture.userID";//查询的条件和表
		String[] properties = new String[] {
				"picture.ID",
				"pictureName",
				"url",
				"picture.userID",
				"`user`.userName",
				"`user`.headImg",
				"pulishTime",
				"state",
				"`picDescribe`"};//查询的列名

		//String joinEntity = "inner join user on daily.userID=`user`.userID  ";
		String condition = "1=1";
		if(name!=null && name!=""&& name!="undefined"){		
			condition += " and picture.ID like '%"+name+"%'";
		}
		List<Map<String, Object>> result = entityDao.searchWithpaging(
				properties, baseEntity, null, null, condition, null, sort,
				order, index, pageNum);
		int count = entityDao.searchForeign(properties, baseEntity, null, null, condition).size();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", count);
		map.put("rows", result);
		return map;
	}

	@Override
	public int update(Picture picture) {		
		int result = entityDao.updatePropByID(picture, picture.getID());
		return result;
	}
	@Override
	public int save(Picture picture) {		
		int result = entityDao.save(picture);
		return result;
	}
	@Override
	public int shenhe(String id) {
		Picture pic=new Picture();
		pic.setState(1);
		int result = entityDao.updatePropByID(pic, id);
		return result;
	}
}
