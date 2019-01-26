package com.wangshen.server_consume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients // 用于调用注册到eureka中的其他服务
@EnableDiscoveryClient // 用于注册到eureka
@SpringBootApplication
public class ServerConsumeApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(ServerConsumeApplication.class, args);
	}

}

