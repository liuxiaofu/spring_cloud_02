package com.wangshen.server_consume.controller;

import com.wangshen.server_consume.service.UserFeignClient;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserConsumerController
{
	private Logger logger = LoggerFactory.getLogger(UserConsumerController.class);


	@Autowired
	private UserFeignClient userFeignClient;

	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(User user)
	{
		boolean result = userFeignClient.login(user);
		String value = result ? "Hello," + user.getName() : "登陆失败！";
		return value;
	}

	@ResponseBody
	@RequestMapping(value = "/login2", method = RequestMethod.POST)
	public String login2(User user)
	{
		String result = userFeignClient.login2(user);
		return result;
	}


	@ResponseBody
	@RequestMapping(value = "/login3", method = RequestMethod.POST)
	public String login3(User user)
	{
		for (int i = 0; i < 10; i++)
		{
			String result = userFeignClient.login3(i);

			logger.info(result);
		}

		return "负载均衡Demo!";
	}
}
