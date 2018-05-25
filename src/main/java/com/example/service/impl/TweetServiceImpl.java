package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.TweetMapper;
import com.example.model.Tweet;
import com.example.service.TweetService;

@Service("tweetService")
public class TweetServiceImpl implements TweetService {

	@Autowired
	private TweetMapper tweetMapper;
	
	@Override
	public Tweet selectOne(Integer id) {
		return tweetMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insert(Tweet record) {
		return tweetMapper.insertSelective(record);
	}

	@Override
	public int update(Tweet record) {
		return tweetMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int delete(Tweet record) {
		return tweetMapper.deleteByPrimaryKey(record);
	}
	
	@Override
    public int increLikeCnt(int tweetid) {
    	return tweetMapper.increLikeCnt(tweetid);
    }
	
	@Override
	public int decreLikeCnt(int tweetid) {
		return tweetMapper.decreLikeCnt(tweetid);
	}
	
}
