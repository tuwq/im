package root.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import root.exception.CheckParamException;
import root.util.ThreadUtil;

public class HttpFilter implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("add....start");
		ThreadUtil.add(request);
		ThreadUtil.add(response);
		System.out.println(ThreadUtil.getCurrentResponse());
		System.out.println(ThreadUtil.getCurrentRequest());
		System.out.println("add....end");
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
		removeThreadLocalInto();
	}

	public void removeThreadLocalInto() {
		System.out.println("remove.....start");
		ThreadUtil.remove();
		System.out.println(ThreadUtil.getCurrentResponse());
		System.out.println(ThreadUtil.getCurrentRequest());
		System.out.println("remove.....end");
	}
}
