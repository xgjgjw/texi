package com.mj.texi.book.controller;

import com.mj.texi.book.ServiceImpl.UserServiceImpl;
import com.mj.texi.book.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserServiceImpl userService;
	@ResponseBody
	@RequestMapping(value = "/getUserByName")
	public User getUserByName(String name){
		User user = userService.getUserByName(name);
		System.out.println(user.getName());
		return user;
	}
	@RequestMapping("/")
    public String welcome(){
		 return "index";
    }
}
