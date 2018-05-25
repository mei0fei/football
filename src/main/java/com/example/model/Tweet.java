package com.example.model;

import java.util.Date;

public class Tweet {
    
	private Integer id;
    private String content;//消息内容
    private Integer userid;//发布者
    private Date createdate;
    private Integer defaultPhotoid;//默认显示照片信息
    private Integer likeCnt;//点赞次数
    private Integer collectCnt;//收藏次数
    private Integer deleted;//是否删除
    private Integer category;
    private Integer comtCnt;//评论次数
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Integer getDefaultPhotoid() {
		return defaultPhotoid;
	}
	public void setDefaultPhotoid(Integer defaultPhotoid) {
		this.defaultPhotoid = defaultPhotoid;
	}
	public Integer getLikeCnt() {
		return likeCnt;
	}
	public void setLikeCnt(Integer likeCnt) {
		this.likeCnt = likeCnt;
	}
	public Integer getCollectCnt() {
		return collectCnt;
	}
	public void setCollectCnt(Integer collectCnt) {
		this.collectCnt = collectCnt;
	}
	public Integer getDeleted() {
		return deleted;
	}
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public Integer getComtCnt() {
		return comtCnt;
	}
	public void setComtCnt(Integer comtCnt) {
		this.comtCnt = comtCnt;
	}

    
    
    
}