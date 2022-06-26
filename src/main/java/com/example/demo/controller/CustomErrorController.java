package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomErrorController implements ErrorController {

	@RequestMapping("/error")
	  @ResponseBody
	  Map<String,String> error(HttpServletRequest request) {
		Map<String,String> map=new HashMap<String,String>();
		map.put("error","page not found");
		return map;
	  }
	
	
}
