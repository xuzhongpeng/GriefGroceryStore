package com.cqut.service.picture;

import java.util.Map;

import com.cqut.entity.picture.Picture;

public interface IPictureService {

	Map<String, Object> getWithPaging(int limit, int offset, String order,
			String sort, String name);

	int update(Picture picture);

	int shenhe(String id);

	int save(Picture pic);

}
