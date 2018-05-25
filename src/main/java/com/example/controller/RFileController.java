package com.example.controller;

import java.util.Date;
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
import com.example.model.RFile;
import com.example.model.User;
import com.example.service.RFileService;
import com.example.service.UserService;

@RestController
public class RFileController {
	
	@Autowired
	private RFileService fileService; 
	
	//记录用户上传的头像信息到RFile数据库中, 返回头像的id。
	@PostMapping(value="/avatar/save", produces="application/json")
	public int insert(@RequestParam String pathfile) {
		
        //存入信息到数据库中
		int pos = pathfile.lastIndexOf("/");
        RFile rfile = new RFile();
        rfile.setCreatedate(new Date());
        rfile.setPath(pathfile.substring(0, pos+1));
        rfile.setFilename(pathfile.substring(pos+1));
        
        int cn = fileService.insert(rfile);
        if(cn ==1 ) {
        	return rfile.getId();
        	
        }else {
        	return -1;
        	
        }
        
	}
	/*
public int insert(RFile file);
	
	public int update(RFile file);

	public int delete(int fileid);

	public RFile selectOne(int fileid);
	*/
	
	
}
