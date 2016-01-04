package com.ouyeelf.ftz.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 资源拦截器
 * @author jdkleo
 *
 */
public class ResourceHandlerInterceptorAdapter extends HandlerInterceptorAdapter {

	/**
	 * 被拦截方法执行前
	 */
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		return true;
	}

	/**
	 * 被拦截方法执行前后
	 */
	public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler,modelAndView);
	}

	/**
	 * DispatcherServlet执行后
	 */
	public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object handler, Exception ex)throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}
}