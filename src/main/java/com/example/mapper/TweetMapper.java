package com.example.mapper;

import com.example.model.Tweet;



public interface TweetMapper {

	Tweet selectByPrimaryKey(Integer id);
    int insertSelective(Tweet record);    
    int updateByPrimaryKeySelective(Tweet record);    
    int deleteByPrimaryKey(Tweet record);
	int increLikeCnt(int tweetid);
	int decreLikeCnt(int tweetid);
    
    
}