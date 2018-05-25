package com.example.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.LikeMapper;
import com.example.mapper.TweetMapper;
import com.example.model.Like;
import com.example.model.Tweet;
import com.example.service.LikeService;


@Service("likeService")
public class LikeServiceImpl implements LikeService {

	@Autowired
	private LikeMapper likeMapper;

	@Override
	public int deleteByUseridAndTweetid(Like record) {
		
		return likeMapper.deleteByUseridAndTweetid(record);
	}

	
	@Override
	@Transactional
	public int insertSelective(Like record) {
		Like l = likeMapper.selectByUseridAndTweetid(record);
		if(l==null) {
			return likeMapper.insertSelective(record);
		}
		return 0;
	}

	@Override
	public Like selectByUseridAndTweetid(Like record) {
		return likeMapper.selectByUseridAndTweetid(record);
		
	}

	
	
	

}
