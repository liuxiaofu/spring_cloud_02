package com.wangshen.server_consume.service.Impl;

import com.wangshen.server_consume.service.UserFeignClient;
import model.User;
import org.springframework.stereotype.Component;

@Component
public class UserFeignClientFallback implements UserFeignClient
{
	/**
	 * 表示调用名称为：server_provider的服务中的
	 * 地址为：/user/login的方法
	 *
	 * @param user
	 * @return
	 */
	@Override
	public boolean login(User user)
	{
		return false;
	}

	@Override
	public String login2(User user)
	{
		return "异常，进入了Hystrix熔断器中。";
	}

	@Override
	public String login3(int count)
	{
		return null;
	}
}
