package com.example.mapper;

import com.example.model.RFile;

public interface RFileMapper {
	int deleteByPrimaryKey(Integer id);

	int insertSelective(RFile record);

	RFile selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(RFile record);

}
