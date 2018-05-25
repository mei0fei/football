package com.example.service;

import com.example.model.RFile;

public interface RFileService {
	
	public int insert(RFile file);
	
	public int update(RFile file);

	public int delete(int fileid);

	public RFile selectOne(int fileid);
	
}
