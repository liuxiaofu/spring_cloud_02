package com.wangshen.zuul.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

//@Configuration
public class PreFilter3 extends ZuulFilter
{
	// 过滤器类型：pre，route，post，error 共四种
	@Override
	public String filterType()
	{
		// 使用过滤器提供的常量，避免出错
		// 也可：return "pre";
		return FilterConstants.PRE_TYPE;
	}

	// 同类型优先级,例：所有pre类型过滤器的执行顺序
	// 数越小越先执行，可以为负数
	@Override
	public int filterOrder()
	{
		return 3;
	}

	// 返回true： 执行此过滤器
	// 返回false：不执行
	@Override
	public boolean shouldFilter()
	{
		RequestContext ctx = RequestContext.getCurrentContext();
		// 根据前面过滤器的结果，判断当前过滤器是否还继续执行
		return ctx.sendZuulResponse();
	}

	// 过滤要使用的核心方法
	// 此方法，返回值暂时没有作用。
	// 可以认为是Zuul组件预留的。都返回null即可。
	@Override
	public Object run() throws ZuulException
	{

		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		String key = request.getParameter("key");
		if (key != null && key.equals("3"))
		{
			ctx.setSendZuulResponse(false); // false：表示到此就结束了，没必要再进行路由转发了
		}

		System.out.println("执行了Filter3");
		return null;
	}
}
