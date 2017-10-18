package com.cqut.service.comment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cqut.dao.base.BaseEntityDao;
import com.cqut.dao.base.EntityDao;
import com.cqut.dao.base.SearchDao;
import com.cqut.entity.comment.Comment;
import com.cqut.service.base.SearchService;


@Service
public class CommentService1 extends SearchService{

	@Resource(name = "entityDao")
	EntityDao entityDao;

	@Resource(name = "searchDao")
	SearchDao searchDao;
	
	@Resource(name = "baseEntityDao")
	BaseEntityDao baseEntityDao;
	
	@Override
	public String getBaseEntityName() {
		return "comment";
	}

	@Override
	public String getBasePrimaryKey() {
		return "ID";
	}
	public Map<String, Object> getWithPaging(int limit, int offset,
			String order, String sort, String name) {
		int index = limit;
		int pageNum = offset / limit ;
		String baseEntity = "COMMENT " +
				"LEFT JOIN daily on COMMENT.dailyID=daily.ID " +
				"LEFT JOIN user userA on  daily.userID=userA.userID " +
				"LEFT JOIN user userB on  useredID=userB.userID";//查询的条件和表
		String[] properties = new String[] {"COMMENT.ID",
				"dailyID",
				"userA.userName as userName",
				"comment",
				"commentTime",
				"useredID",
				"userB.userName as useredName"};//查询的列名

		//String joinEntity = "inner join user on daily.userID=`user`.userID  ";
		String condition = "1=1";
		if(name!=null && name!=""&& name!="undefined"){		
			condition += " and ID like '%"+name+"%'";
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
	
	public int save(Comment comment){
		comment.setID(getUUID());
		int result = entityDao.save(comment);
		return result;
	}
	public int update(Comment comment){
		int result = entityDao.updatePropByID(comment, comment.getID());
		return result;
	}
	public int delete(String[] id){
		String dstr="ID in (";
		
		for(int i=0;i<id.length;i++){
			dstr+="'"+id[i]+"',";
		}
		dstr=dstr.substring(0,dstr.length()-1);
		dstr+=" )";
		int result = entityDao.deleteByCondition(dstr,Comment.class);
		return result;
	}
	public static String getUUID(){
        UUID uuid=UUID.randomUUID();
        String str = uuid.toString(); 
        String uuidStr=str.replace("-", "");
        return uuidStr;
      }
	
}
