package com.llce.gmis.controller;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.llce.gmis.entity.User;
import com.llce.gmis.service.GmisService;

@Controller
@RequestMapping("/gmis/v1")
public class GmisController {
	
	private static Logger logger = LoggerFactory.getLogger(GmisController.class);
	
	@Autowired
	private GmisService gmisService;
	
	@RequestMapping("/hello")
	public String hello(){
		return "hello";
	}
	
	@RequestMapping(value="/user/{userName:\\w+}",method=RequestMethod.GET)
	public @ResponseBody Object getUser(@PathVariable(value="userName") String userName){
		logger.info("searching user:"+userName);
		User user=gmisService.getUserByUserName(userName);
		JSONObject jsonObject=new JSONObject();
		if(user==null){
			jsonObject.put("msg", "not found");
			logger.error("error:"+userName+" not found!");
		
		}
		else{
			jsonObject.put("msg", "success");
			jsonObject.put("userId", user.getUserId());
			jsonObject.put("userName", user.getUserName());
			jsonObject.put("passwordHash", user.getPasswordHash());
			logger.info(userName+" found.");
		}
		return jsonObject;
	}
	
	@RequestMapping(value="/user/{id:\\d+}",method=RequestMethod.DELETE)
	public @ResponseBody Object deleteUser(@PathVariable("id") int id){
		logger.info("deleting user by id:"+id);
		gmisService.deleteUser(id);
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("msg", "success");
		logger.info("deleting '"+id+"' success");
		return jsonObject;
	}
	
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public @ResponseBody Object addUser(@RequestBody User user){
		logger.info("add user:"+user.getUserName());
		JSONObject jsonObject=new JSONObject();
		if(gmisService.getUserByUserName(user.getUserName())!=null){
			jsonObject.put("msg","duplicated");
			logger.error("error:duplicated username:"+user.getUserName());
			return jsonObject;
		}
	
		gmisService.addUser(user);
		jsonObject.put("msg", "success");
		jsonObject.put("userId", user.getUserId());
		logger.info("user '"+user.getUserName()+"' added successfully");
		return jsonObject;
	}
	
	@RequestMapping(value="/user",method=RequestMethod.PATCH)
	public @ResponseBody Object updateUser(@RequestBody User user){
		logger.info("update user:"+user.getUserName());
		gmisService.updateUser(user);
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("msg", "success");
		logger.info("update user '"+user.getUserName()+"' successfully");
		return jsonObject;
	}
	
}
