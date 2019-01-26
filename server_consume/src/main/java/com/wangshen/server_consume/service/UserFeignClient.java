package com.wangshen.server_consume.service;

import com.wangshen.server_consume.service.Impl.UserFeignClientFallback;
import model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// 实现类不用写，feign组件帮我们实现
@FeignClient(name = "SERVER-PROVIDER", fallback = UserFeignClientFallback.class) // name:为我们要调用的，注册到eureka中的服务
public interface UserFeignClient
{

	/**
	 * 表示调用名称为：server_provider的服务中的
	 * 地址为：/user/login的方法
	 *
	 * @return
	 */
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public boolean login(User user);

	@RequestMapping(value = "/user/login2", method = RequestMethod.POST)
	public String login2(User user);

	@RequestMapping(value = "/user/login3", method = RequestMethod.POST)
	public String login3(@RequestParam int count);
}
