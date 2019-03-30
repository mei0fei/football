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
import com.example.model.Tweet;
import com.example.model.User;
import com.example.service.TweetService;

@RestController
@RequestMapping("/tweet")
public class TweetController {
	
	@Autowired
	private TweetService tweetService;
		
	//用户发送一个tweet
	@PostMapping(value="save", consumes="application/json", produces="application/json" )
	public ActionResult save(@RequestBody Tweet tweet, HttpSession session) {
		
		ActionResult ar = new ActionResult();
		ar.setAct("action tweet save");
		
		Integer id = (Integer)session.getAttribute("userid");
		//System.out.println("id="+id);
		if(id==null) {
			ar.setResult("failed to get user id, you should login");
			return ar;
		}
		
		tweet.setUserid(id);
		//System.out.println(tweet);
		
		int cn = tweetService.insert(tweet);
		
		if(cn==1) {
			//System.out.println(tweet);
			ar.setResult("success");
		}else {
			ar.setResult("failed to save tweet");
		}
		return ar;
		
	}
	
	//依据tweet的id，更新一个tweet信息, 因此参数tweet中需要设置id
	@PostMapping(value="update", consumes="application/json", produces="application/json" )
	public ActionResult update(@RequestBody Tweet tweet, HttpSession session) {
		
		ActionResult ar = new ActionResult();
		ar.setAct("action tweet updte");
		
		Integer uid = (Integer)session.getAttribute("userid");
		if(uid==null) {
			ar.setResult("failed to get user id, you should login");
			return ar;
		}
		tweet.setUserid(uid);
		
		int cn = tweetService.update(tweet);
		
		if(cn==1) {
			ar.setResult("success");
		}else {
			ar.setResult("fail");
		}
		return ar;
	}
	
	//删除一个tweet，参数tweet中需要设置 id 
	@GetMapping(value="delete/{tweetid}", produces="application/json" )
	//public ActionResult delete(@RequestBody Tweet tweet, HttpSession session) {
	public ActionResult delete(@PathVariable int tweetid, HttpSession session) {
		
		ActionResult ar = new ActionResult();
		ar.setAct("action tweet delete");
		
		Integer uid = (Integer)session.getAttribute("userid");
		if(uid==null) {
			ar.setResult("failed to get user id, you should login");
			return ar;
		}
		
		Tweet tweet = new Tweet();
		tweet.setId(tweetid);
		tweet.setUserid(uid);
		
		int cn = tweetService.delete(tweet);
		
		if(cn==1) {
			ar.setResult("success");
		}else {
			ar.setResult("fail");
		}
		return ar;
	}
	
	//获取一个tweet
	@GetMapping(value="{id}",produces="application/json")
	public Tweet selectOne(@PathVariable int id) {
		return tweetService.selectOne(id);
	}
	
	
}
