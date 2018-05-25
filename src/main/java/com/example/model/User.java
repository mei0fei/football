package com.example.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	private Integer id;
	private Integer avatarId;//头像ID，关联文件表
	private String nickname;//昵称
	private String loginname;//注册名称
	private String password;
	private Integer age;
	
	private String sex;
	private String address;
	//private String email;
	private String qqUid;//QQ三方绑定
	private String wechatUid;//微信绑定
	private String weiboUid;//微博绑定

	private String signnature;//个性签名
	private Integer fbage;//球龄
	private String favoriteTeam;//最喜欢的球队
	private Date regdate;//注册日期
	private Integer isadmin;//是否管理员
	//private Integer informCnt;//举报次数
	
	
	/** ==================以下为非数据库字段，充当VO和DTO===================== */
	private String avatarpath;// 头像路径
	
	public String getAvatarpath() {
		return avatarpath;
	}

	public void setAvatarpath(String avatarpath) {
		this.avatarpath = avatarpath;
	}
	
	public User() {
	}
	
	public User(String loginname) {
		this.loginname = loginname;
	}

	public User(int id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", avatarId=" + avatarId + ", nickname=" + nickname + ", loginname=" + loginname
				+ ", password=" + password + ", age=" + age + ", sex=" + sex + ", address=" + address + ", qqUid="
				+ qqUid + ", wechatUid=" + wechatUid + ", weiboUid=" + weiboUid + ", signnature=" + signnature
				+ ", fbage=" + fbage + ", favoriteTeam=" + favoriteTeam + ", regdate=" + regdate + ", isadmin="
				+ isadmin + "]";
	}

	public Integer getAvatarId() {
		return avatarId;
	}

	public void setAvatarId(Integer avatarId) {
		this.avatarId = avatarId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname == null ? null : nickname.trim();
	}

	/** 登陆名 */
	public String getLoginname() {
		return loginname;
	}

	/** 登陆名 */
	public void setLoginname(String loginname) {
		this.loginname = loginname == null ? null : loginname.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public String getQqUid() {
		return qqUid;
	}

	public void setQqUid(String qqUid) {
		this.qqUid = qqUid == null ? null : qqUid.trim();
	}

	public String getSignnature() {
		return signnature;
	}

	public void setSignnature(String signnature) {
		this.signnature = signnature == null ? null : signnature.trim();
	}

	public Integer getFbage() {
		return fbage;
	}

	public void setFbage(Integer fbage) {
		this.fbage = fbage;
	}

	public String getFavoriteTeam() {
		return favoriteTeam;
	}

	public String getWechatUid() {
		return wechatUid;
	}

	public void setWechatUid(String wechatUid) {
		this.wechatUid = wechatUid;
	}

	public void setFavoriteTeam(String favoriteTeam) {
		this.favoriteTeam = favoriteTeam == null ? null : favoriteTeam.trim();
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getWeiboUid() {
		return weiboUid;
	}

	public void setWeiboUid(String weiboUid) {
		this.weiboUid = weiboUid;
	}
	
	public Integer getIsadmin() {
		return isadmin;
	}

	public void setIsadmin(Integer isadmin) {
		this.isadmin = isadmin;
	}
	
	
}