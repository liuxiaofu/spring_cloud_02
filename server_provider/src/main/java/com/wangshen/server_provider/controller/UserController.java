package com.wangshen.server_provider.controller;

import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController
{
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public boolean login(User user)
	{
		boolean result = "wangshen".equals(user.getName()) && "123".equals(user.getPassword());

		logger.info("提供服务者为：server_provider,8001");
		return result;
	}


	@ResponseBody
	@RequestMapping(value = "/login3", method = RequestMethod.POST)
	public String login3(@RequestParam int count)
	{
		logger.info("提供服务者为：server_provider--8001,第-" + count + "-次");
		return "提供服务者为：server_provider--8001,第-" + count + "-次";
	}
}
