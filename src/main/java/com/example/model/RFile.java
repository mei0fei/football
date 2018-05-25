package com.example.model;

import java.util.Date;

public class RFile {
	private Integer id;
	private String path;//路径upload/file/20150513/
	private String filename;//文件名xxx.png
	private Date createdate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	@Override
	public String toString() {
		return "RFile [id=" + id + ", path=" + path + ", filename=" + filename + ", createdate=" + createdate + "]";
	}
	
	
	
	
}
