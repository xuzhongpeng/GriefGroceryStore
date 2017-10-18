package com.cqut.service.userManage;

import java.util.List;
import java.util.Map;

import com.cqut.entity.userManage.userManage;

public interface IUserManageService {
	public Map<String, Object> getuserManageWithPaging(int limit, int offset,
			String order, String sort, String name);

	 public int save(userManage userManage);
	 public int update(userManage userManage);

	 public int delete(String[] userId);

	public List<userManage> getByName(String name,String password,String type);

	public int followFriend(String userID, String friendID);

	public List<userManage> getByID(String userID);
}
