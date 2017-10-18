package com.cqut.service.dailyManage;

import java.util.List;
import java.util.Map;

import com.cqut.entity.dailyManage.daily;

public interface IdailyManageService {
	public Map<String, Object> getWithPaging(int limit, int offset,
			String order, String sort, String name);

	 public int save(daily daily);
	 public int update(daily daily);

	 public int delete(String[] dailyId);

	public Map<String, Object> fineByID(String id);

	Map<String, Object> getAllInfo(String userID, int limit, int offset);

	public int likes(String dailyID, int type);

	public Map<String, Object> getHotDaily(int limit, int offset);

	public Map<String, Object> getPictureDaily(int limit, int offset);

	public Map<String, Object> getPersonPictureDaily(int limit, int offset,
			String userID);
}
