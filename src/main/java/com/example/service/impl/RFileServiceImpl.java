package com.example.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.RFileMapper;
import com.example.model.RFile;

import com.example.service.RFileService;

@Service("fileService")
public class RFileServiceImpl implements RFileService {
	
	@Autowired
	private RFileMapper fileMapper;

	@Override
	public int insert(RFile file) {
		return fileMapper.insertSelective(file);
	}

	@Override
	public int update(RFile file) {
		return fileMapper.updateByPrimaryKeySelective(file);
	}

	@Override
	public int delete(int fileid) {
		return fileMapper.deleteByPrimaryKey(fileid);
	}

	@Override
	public RFile selectOne(int fileid) {
		return fileMapper.selectByPrimaryKey(fileid);
	}

	
}