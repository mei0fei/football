package com.example.service;

import com.example.model.Tweet;

public interface TweetService {
	
	Tweet selectOne(Integer id);
    int insert(Tweet record);    
    int update(Tweet record);    
    int delete(Tweet record);
    

    int increLikeCnt(int tweetid);	//增加点赞数
    
	int decreLikeCnt(int tweetid);	//减少点赞数

}
