package com.cqut.service.dailyManage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cqut.dao.base.BaseEntityDao;
import com.cqut.dao.base.EntityDao;
import com.cqut.dao.base.SearchDao;
import com.cqut.entity.dailyManage.daily;
import com.cqut.entity.picture.Picture;
import com.cqut.service.base.SearchService;

@Service
public class dailyManageService  extends SearchService implements
IdailyManageService{

	@Resource(name = "entityDao")
	EntityDao entityDao;

	@Resource(name = "searchDao")
	SearchDao searchDao;

	@Resource(name = "baseEntityDao")
	BaseEntityDao baseEntityDao;
	
	
	@Override
	public String getBaseEntityName() {
		return "daily";
	}

	@Override
	public String getBasePrimaryKey() {
		return "daily.ID";
	}
	@Override
	public Map<String, Object> getWithPaging(int limit, int offset,
			String order, String sort, String name) {
		int index = limit;
		int pageNum = offset / limit ;
		String baseEntity = "daily inner join user on daily.userID=`user`.userID  ";//查询的条件和表
		String[] properties = new String[] {"daily.ID as ID",
				"userName",
				"daily.userID as userID",
				"contentType",
				"title",
				"content",
				"pictureID",
				"releaseTime",};//查询的列名

		//String joinEntity = "inner join user on daily.userID=`user`.userID  ";
		String condition = "1=1";
		if(name!=null && name!=""&& name!="undefined"){		
			condition += " and userID like '%"+name+"%'";
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
	public int save(daily daily){
		int result = entityDao.save(daily);
		return result;
	}
	@Override
	public int update(daily daily){
		int result = entityDao.updatePropByID(daily, daily.getID());
		return result;
	}
	@Override
	public int delete(String[] id){
		String dstr="ID in (";
		
		for(int i=0;i<id.length;i++){
			dstr+="'"+id[i]+"',";
		}
		dstr=dstr.substring(0,dstr.length()-1);
		dstr+=" )";
		int result = entityDao.deleteByCondition(dstr,daily.class);
		return result;
	}
	public static String getUUID(){
        UUID uuid=UUID.randomUUID();
        String str = uuid.toString(); 
        String uuidStr=str.replace("-", "");
        return uuidStr;
      }

	
	@Override
	public Map<String, Object> fineByID(String id) {
		String baseEntity = "daily " +
				"LEFT JOIN `user` ON daily.userID = `user`.userID " +
				"LEFT join picture on picture.ID=daily.pictureID";//查询的条件和表
		String[] properties = new String[] {"daily.ID",
				"daily.userID",
				"`user`.userName",
				"`user`.headImg AS headImg",
				"contentType",
				"title",
				"url",
				"content",
				"pictureID",
				"releaseTime",
				"musicSrc",
				"loved"};//查询的列名
		String condition="daily.ID='"+id+"'";
		List<Map<String, Object>> result=entityDao.searchForeign(properties, baseEntity, null, null, condition);
		
		Map<String, Object> map = new HashMap<String, Object>();		
		map.put("dailyInfo", result);
		return map;
	}
	@Override
	public Map<String, Object> getAllInfo(String userID,int limit,int offset){
		String order="Desc";
		String sort="releaseTime";
		int index = limit;
		int pageNum = offset / limit ;
		String baseEntity = "daily " +
				"LEFT JOIN `user` ON daily.userID = `user`.userID " +
				"LEFT join picture on picture.ID=daily.pictureID";//查询的条件和表
		String[] properties = new String[] {"daily.ID",
				"daily.userID",
				"`user`.userName",
				"`user`.headImg AS headImg",
				"contentType",
				"title",
				"url",
				"content",
				"pictureID",
				"releaseTime",
				"musicSrc",
				"loved"};//查询的列名
		String condition=" daily.userID = '"+userID+"' " +
				"OR daily.userID IN (" +
				"SELECT	friendID AS userID " +
				"FROM friend WHERE" +
				"	friend.userID = '"+userID+"')";
		List<Map<String, Object>> result=entityDao.searchWithpaging(
				properties, baseEntity, null, null, condition, null, sort,
				order, index, pageNum);		
		Map<String, Object> map = new HashMap<String, Object>();		
		map.put("AllInfo", result);		
		return map;
	}

	@Override
	public int likes(String dailyID, int type) {
		daily dd=new daily();
	    dd=entityDao.getByID(dailyID,daily.class);
	    if(type==1){
	    	dd.setLoved(dd.getLoved()+1);
	    }
	    else if(type==0){
	    	dd.setLoved(dd.getLoved()-1);
	    }
	    int result= entityDao.updatePropByID(dd, dd.getID());
		return result;
	}

	@Override
	public Map<String, Object> getHotDaily(int limit, int offset) {
		String order="Desc";
		String sort="loved";
		int index = limit;
		int pageNum = offset / limit ;
		String baseEntity = "daily " +
				"LEFT JOIN `user` ON daily.userID = `user`.userID " +
				"LEFT join picture on picture.ID=daily.pictureID";//查询的条件和表
		String[] properties = new String[] {"daily.ID",
				"daily.userID",
				"`user`.userName",
				"`user`.headImg AS headImg",
				"contentType",
				"title",
				"url",
				"content",
				"pictureID",
				"releaseTime",
				"musicSrc",
				"loved"};//查询的列名
		String condition="";
		List<Map<String, Object>> result=entityDao.searchWithpaging(
				properties, baseEntity, null, null, condition, null, sort,
				order, index, pageNum);		
		Map<String, Object> map = new HashMap<String, Object>();		
		map.put("AllInfo", result);		
		return map;
	}

	@Override
	public Map<String, Object> getPictureDaily(int limit, int offset) {
		String order="Desc";
		String sort="loved";
		int index = limit;
		int pageNum = offset / limit ;
		String baseEntity = "daily " +
				"LEFT JOIN `user` ON daily.userID = `user`.userID " +
				"LEFT join picture on picture.ID=daily.pictureID";//查询的条件和表
		String[] properties = new String[] {"daily.ID",
				"daily.userID",
				"`user`.userName AS userName",
				"`user`.headImg AS headImg",
				"contentType",
				"title",
				"url",
				"content",
				"pictureID",
				"releaseTime",
				"musicSrc",
				"loved"};//查询的列名
		String condition="contentType=2";
		List<Map<String, Object>> result=entityDao.searchWithpaging(
				properties, baseEntity, null, null, condition, null, sort,
				order, index, pageNum);		
		Map<String, Object> map = new HashMap<String, Object>();		
		map.put("AllInfo", result);		
		return map;
	}

	@Override
	public Map<String, Object> getPersonPictureDaily(int limit, int offset,
			String userID) {
		String order="Desc";
		String sort="releaseTime";
		int index = limit;
		int pageNum = offset / limit ;
		String baseEntity = "daily " +
				"LEFT JOIN `user` ON daily.userID = `user`.userID " +
				"LEFT join picture on picture.ID=daily.pictureID";//查询的条件和表
		String[] properties = new String[] {"daily.ID",
				"daily.userID",
				"`user`.userName AS userName",
				"`user`.headImg AS headImg",
				"contentType",
				"title",
				"url",
				"content",
				"pictureID",
				"releaseTime",
				"musicSrc",
				"loved"};//查询的列名
		String condition="contentType=2 and daily.userID='"+userID+"'";
		List<Map<String, Object>> result=entityDao.searchWithpaging(
				properties, baseEntity, null, null, condition, null, sort,
				order, index, pageNum);		
		Map<String, Object> map = new HashMap<String, Object>();		
		map.put("AllInfo", result);		
		return map;
	}
}
