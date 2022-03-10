package com.rong.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 定义处理器拦截器 */
//拦截器有三个方法，实现的这个接口
    //如果返回值为true则表示放行，否则表示拦截
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute("uid") == null) {
            //使用重定向
            response.sendRedirect("/web/login.html");
            return false;
        }
        return true;
    }

}
