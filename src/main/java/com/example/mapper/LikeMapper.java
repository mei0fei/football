package com.example.mapper;

import com.example.model.Like;

public interface LikeMapper {
    
    int deleteByUseridAndTweetid(Like record);

    int insertSelective(Like record);

    Like selectByUseridAndTweetid(Like record);


}