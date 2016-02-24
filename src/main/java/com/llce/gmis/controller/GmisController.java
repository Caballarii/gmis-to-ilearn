package com.llce.gmis.controller;

import net.sf.json.JSONObject;

import org.apache.el.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.llce.gmis.entity.User;
import com.llce.gmis.service.GmisService;

@Controller
@RequestMapping("/gmis/v1")
public class GmisController {
	
	@Autowired
	private GmisService gmisService;
	
	@RequestMapping("/hello")
	public String hello(){
		return "hello";
	}
	
	@RequestMapping(value="/user/{userName:\\w+}",method=RequestMethod.GET)
	public @ResponseBody User getUser(@PathVariable(value="userName") String userName){
		User user=gmisService.getUserByUserName(userName);
		return user;
	}
	
	@RequestMapping(value="/user/{id:\\d+}",method=RequestMethod.DELETE)
	public @ResponseBody Object deleteUser(@PathVariable("id") int id){
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("msg", "删除成功");
		return jsonObject;
	}
	
}
