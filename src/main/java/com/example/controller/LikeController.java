package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.model.ActionResult;
import com.example.model.Like;
import com.example.model.Tweet;
import com.example.service.LikeService;
import com.example.service.TweetService;

@RestController
@RequestMapping("/like")
public class LikeController {
	
	@Autowired
	private LikeService likeService;
	
	@Autowired
	private TweetService tweetService;
	
	//用户点赞一个tweet， 每个tweet只能点赞一次, 所以事先要判断是否已经点赞过。
	//点赞之后， 需要在tweet的字段like_cnt上加1， 所以这里我们使用了@Transactional
	@GetMapping(value="add/{tweetid}", produces="application/json" )
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public ActionResult add(@PathVariable int tweetid, HttpSession session) {
		
		ActionResult ar = new ActionResult();
		ar.setAct("点赞");
		Integer uid = (Integer)session.getAttribute("userid"); 
		if(uid==null) {
			ar.setResult("你需要登录");
			return ar;
		}
		
		Like like = new Like();
		like.setUserid(uid);
		like.setTweetid(tweetid);
		Like like2 = likeService.selectByUseridAndTweetid(like);
		if(like2==null) {//表示还没有点赞
			int cn = likeService.insertSelective(like);//点赞
			if(cn!=1) {
				ar.setResult("点赞失败");
				return ar;
			}
			cn = tweetService.increLikeCnt(tweetid); //点赞后， 点赞数加1
			if(cn!=1) {
				ar.setResult("点赞数加一失败");
				return ar;
			}
			ar.setResult("点赞成功");
		}else {//表示已经点赞过了
			ar.setResult("点赞失败， 因为你已经点赞了它。");
		}
		return ar;
	}
	
	//获取登录用户的对一个tweet的点赞记录 
	@GetMapping(value="select/{tweetid}",  produces="application/json" )
	public Like select(@PathVariable int tweetid, HttpSession session) {
		
		Integer uid = (Integer)session.getAttribute("userid");
		System.out.println("uid = " + uid);
		if(uid==null) {
			return null;
		}
		Like like = new Like();
		like.setUserid(uid);
		like.setTweetid(tweetid);
		
		return likeService.selectByUseridAndTweetid(like);
	}
	
	//取消对一个tweet的点赞， 需要判断用户是否对该tweet点赞过
	//取消点赞后， 该tweet的字段like_cnt减少1，所以这里我们使用了@Transactional
	@GetMapping(value="delete/{tweetid}", produces="application/json" )
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public ActionResult delete(@PathVariable int tweetid, HttpSession session) {
		
		ActionResult ar = new ActionResult();
		ar.setAct("取消点赞");
		
		Integer uid = (Integer)session.getAttribute("userid");
		if(uid==null) {
			ar.setResult("你需要登录");
			return ar;
		}
		Like like = new Like();
		like.setUserid(uid);
		like.setTweetid(tweetid);
		
		like = likeService.selectByUseridAndTweetid(like);
		
		if(like!=null) {//表示已经点赞过
			int cn = likeService.deleteByUseridAndTweetid(like); //取消点赞
			if(cn!=1) {
				ar.setResult("取消点赞失败");
				return ar;
			}
			cn = tweetService.decreLikeCnt(tweetid);
			if(cn!=1) {
				ar.setResult("点赞数减1失败");
				return ar;
			}
			ar.setResult("取消点赞成功");
			
		}else {
			ar.setResult("取消点赞失败， 因为你没有点赞这个tweet");
		}
		return ar;
	}
	
	
	
}
