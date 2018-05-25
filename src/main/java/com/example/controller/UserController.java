package com.example.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.ActionResult;
import com.example.model.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/user/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//添加或注册一个用户信息
	@PostMapping(value="save", consumes="application/json", produces="application/json" )
	public ActionResult save(@RequestBody User user) {
		
		int cn = userService.insert(user);
		ActionResult ar = new ActionResult();
		ar.setAct("action save");
		
		if(cn==1) {
			System.out.println(user);
			ar.setResult("success");
		}else {
			ar.setResult("fail");
		}
		return ar;
	}
	
	//更新一个用户信息
	@PostMapping(value="update", consumes="application/json", produces="application/json" )
	public ActionResult update(User user) {
		int cn = userService.update(user);
		ActionResult ar = new ActionResult();
		ar.setAct("action updte");
		if(cn==1) {
			ar.setResult("success");
		}else {
			ar.setResult("fail");
		}
		return ar;
	}
	
	//删除一个用户信息
	@GetMapping("delete/{userid}")
	public ActionResult delete(@PathVariable int userid) {
		int cn = userService.delete(userid);
		ActionResult ar = new ActionResult();
		ar.setAct("action delete");
		if(cn==1) {
			ar.setResult("success");
		}else {
			ar.setResult("fail");
		}
		return ar;
	}
	
	//获取一个用户信息
	@GetMapping(value="query/{userid}",produces="application/json")
	public User selectOne(@PathVariable int userid) {
		return userService.selectOne(userid);
	}
	
	//根据用户登录名获取用户记录
	@GetMapping(value="querybyname",produces="application/json")
	public User selectByLoginname(HttpSession session) {
		
		String name =  (String)session.getAttribute("loginname");
		if(name==null) return null;
		User user = new User();
		user.setLoginname(name);
		return userService.getUserByLoginName(user);
		
	}
	
	//重新设置用户的密码， 参数user中要设置用登录名称loginname, 新密码password 
	@PostMapping(value="resetpwd", consumes="application/json", produces="application/json" )
	public ActionResult resetpwd(@RequestBody User user) {
		
		int cn = userService.resetpwd(user);
		ActionResult ar = new ActionResult();
		ar.setAct("action reset password");
		if(cn==1) {
			ar.setResult("success");
		}else {
			ar.setResult("fail");
		}
		return ar;	
		
	}
	
	//获取当前登录用户的密码
	@GetMapping(value = "password", produces="application/json")
	public String getPassword(HttpSession session) {
		String username = (String)session.getAttribute("loginname");
		if(username==null) return null;
		return userService.getPassword(username);
		
	}
	
	//登录操作， 参数user中要设置用登录名称loginname, 密码password 
	@PostMapping(value="login", consumes="application/json", produces="application/json" )
	public ActionResult login(@RequestBody User user, HttpSession session) {
		
		User u = userService.userLogin(user);
		ActionResult ar = new ActionResult();
		ar.setAct("action login");
		if(u!=null) {
			session.setAttribute("loginname", u.getLoginname());
			session.setAttribute("userid", u.getId());
			session.setAttribute("avatarid", u.getAvatarId());
			session.setAttribute("avatarpath", u.getAvatarpath());
			
			ar.setResult("success");
			
		}else {
			ar.setResult("fail");
			
		}
		return ar;	
		
	}
	
	//登出操作
	@GetMapping(value="logout", produces="application/json" )
	public ActionResult logout(HttpSession session) {
		session.invalidate();
		ActionResult ar = new ActionResult();
		ar.setAct("action logout");
		ar.setResult("success");
		return ar;	
		
	}
	
	//更新用户头像
	@PostMapping(value="avatar/update", produces="application/json")
	public ActionResult updateAvart(@RequestParam int avatarId, HttpSession session) {
		
		ActionResult ar = new ActionResult();
		ar.setAct("action update avart");
		String loginname = (String)session.getAttribute("loginname");
		if(loginname==null) {
			ar.setResult("failed, you need login");
			return ar;
		}
		User user = new User();
		user.setAvatarId(avatarId);
		user.setLoginname( loginname );
		int cn = userService.updateAvatar(user);
		if(cn==1) {
			ar.setResult("success");
		}else {
			ar.setResult("failed");
		}
		return ar;
		
	}
	
}
