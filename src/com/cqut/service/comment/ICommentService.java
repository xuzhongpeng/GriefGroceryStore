package com.cqut.service.comment;

import java.util.List;
import java.util.Map;

import com.cqut.entity.comment.Comment;

public interface ICommentService {

	Map<String, Object> getWithPaging(int limit, int offset, String order,
			String sort, String name);

	int save(Comment comment);

	int update(Comment comment);

	int delete(String[] id);

	List<Map<String, Object>> getbyDailyID(String dailyID);

	int add(Comment comment);


	
}
