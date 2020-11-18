package com.webwork.recruitsystem.Config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object loginUser= request.getSession().getAttribute("loginUser");

        if(loginUser==null) {
            request.setAttribute("msg", "还未登录");
            //转到login 页面
            request.getRequestDispatcher("/login").forward(request,response);
            return false;
        }
        return true;
    }
}
