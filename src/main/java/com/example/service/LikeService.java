package com.example.service;

import com.example.model.Like;

public interface LikeService {
	
	int deleteByUseridAndTweetid(Like record);

    int insertSelective(Like record);

    Like selectByUseridAndTweetid(Like record);

}
