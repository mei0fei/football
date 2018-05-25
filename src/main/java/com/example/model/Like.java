package com.example.model;

public class Like {
    
    private Integer id;
    private Integer userid; //用户
    private Integer tweetid; //点赞了哪个tweet

   
    public Integer getId() {
        return id;
    }

    
    public void setId(Integer id) {
        this.id = id;
    }

    
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    
    public Integer getTweetid() {
        return tweetid;
    }

   
    public void setTweetid(Integer tweetid) {
        this.tweetid = tweetid;
    }
}