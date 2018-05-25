package com.example.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.model.RFile;
import com.example.service.RFileService;

@RestController
public class UploadController {

    private static String UPLOADED_FOLDER = "/upload/files/";
    
    @PostMapping("/upload/file")
    public String singleFileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
    	
        if (file.isEmpty()) return null;
        try {
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd");
        	/** 构建图片保存的目录 **/
    		String FilePathDir = UPLOADED_FOLDER + dateformat.format(new Date()) + "/";
    		/** 如果用的是Tomcat服务器，则文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\upload\\files\\文件夹中 */
    		String realPath = request.getSession().getServletContext().getRealPath(FilePathDir);

    		File filepath = new File(realPath);
    		if(!filepath.exists()) filepath.mkdirs();
    		String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
    		String finalName = UUID.randomUUID().toString()+ suffix;//构建文件名称
    		
            byte[] bytes = file.getBytes();
            Path path = Paths.get(realPath +  finalName);
            Files.write(path, bytes);
            return FilePathDir + finalName;
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /*
     * @RequestMapping(value = "/uploadMultiFile", method = RequestMethod.POST)
public String submit(@RequestParam("files") MultipartFile[] files, ModelMap modelMap) {
    modelMap.addAttribute("files", files);
    return "fileUploadView";
}
     * 
     * 
     * 
     * */
    
    
}
