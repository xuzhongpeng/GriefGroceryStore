package com.cqut.service.userManage;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.cqut.dao.base.BaseEntityDao;
import com.cqut.dao.base.EntityDao;
import com.cqut.dao.base.SearchDao;
import com.cqut.entity.friend.friend;
import com.cqut.entity.testReport.TestReport;
import com.cqut.entity.userManage.userManage;
import com.cqut.service.base.SearchService;
import com.cqut.tool.util.EntityIDFactory;
import com.cqut.tool.util.PropertiesTool;

@Service
public class userManageService extends SearchService implements
IUserManageService {

	@Resource(name = "entityDao")
	EntityDao entityDao;

	@Resource(name = "searchDao")
	SearchDao searchDao;

	@Resource(name = "baseEntityDao")
	BaseEntityDao baseEntityDao;
	
	
	@Override
	public String getBaseEntityName() {
		return "user";
	}

	@Override
	public String getBasePrimaryKey() {
		return "user.ID";
	}

	@Override
	public Map<String, Object> getuserManageWithPaging(int limit, int offset,
			String order, String sort, String name) {
		int index = limit;
		int pageNum = offset / limit ;
		String baseEntity = "user";//查询的条件和表
		String[] properties = new String[] {"*"};//查询的列名

		//String joinEntity = " LEFT JOIN fileinformation ON c.fileID = fileinformation.ID   ";
		String condition = "1=1";
		if(name!=null && name!=""&& name!="undefined"){		
			condition += " and userName like '%"+name+"%'";
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
	public int save(userManage user){
		System.out.println(user.getUserID());
		if(user.getUserID()==null||user.getUserID().equals("")){
			user.setUserID(getUUID());
		}
		int result = entityDao.save(user);
		return result;
	}
	@Override
	public int update(userManage user){
		String condition="userID="+user.getUserID();
		int result = entityDao.updatePropByCondition(user,condition);
		return result;
	}
	@Override
	public int delete(String[] userId){
		String dstr="userID in (";
		
		for(int i=0;i<userId.length;i++){
			dstr+="'"+userId[i]+"',";
		}
		dstr=dstr.substring(0,dstr.length()-1);
		dstr+=" )";
		int result = entityDao.deleteByCondition(dstr,userManage.class);
		return result;
	}
	public static String getUUID(){
        UUID uuid=UUID.randomUUID();
        String str = uuid.toString(); 
        String uuidStr=str.replace("-", "");
        uuidStr=uuidStr.substring(0, 7);
        return uuidStr;
      }

	@Override
	public List<userManage> getByName(String name,String password,String  type) {
		System.out.println(type);
		int Type=0;
		if(type!=null){
			Type=Integer.parseInt(type);
		}
		else{
			Type=1;
		}
		List<userManage> user=entityDao.getByCondition("userID='"+name+"' and password='"+password+"' AND type="+Type,userManage.class);
		
		return user;
	}

	@Override
	public int followFriend(String userID, String friendID) {
		friend ff=new friend();
		ff.setID(EntityIDFactory.createId());
		ff.setUserID(userID);
		ff.setFriendID(friendID);
		int count=entityDao.getCountByCondition("userID='"+userID+"' AND friendID='"+friendID+"'", friend.class);
		if(count==0){
			int result=entityDao.save(ff);
			return result;
		}else{
			return 2;
		}
	}

	@Override
	public List<userManage> getByID(String userID) {
		List<userManage> user=entityDao.getByCondition("userID='"+userID+"'",userManage.class);
		
		return user;
	}

}
