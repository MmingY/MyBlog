package com.ming.blog.interceptor.handler;

import com.ming.blog.bean.RespBean;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证失败的处理
 */
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse
            , AuthenticationException exception) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        RespBean respBean;
        if (exception instanceof BadCredentialsException ||
                exception instanceof UsernameNotFoundException) {
            respBean = new RespBean("error", "账户名或者密码输入错误!");
        } else if (exception instanceof LockedException) {
            respBean = new RespBean("error", "账户被锁定，请联系管理员!");
        } else if (exception instanceof CredentialsExpiredException) {
            respBean = new RespBean("error", "密码过期，请联系管理员!");
        } else if (exception instanceof AccountExpiredException) {
            respBean = new RespBean("error", "账户过期，请联系管理员!");
        } else if (exception instanceof DisabledException) {
            respBean = new RespBean("error", "账户被禁用，请联系管理员!");
        } else {
            respBean = new RespBean("error", "登录失败!");
        }
        httpServletResponse.setStatus(401);
        httpServletResponse.getWriter().println(respBean);
//        new GalenWebMvcWrite().writeToWeb(httpServletResponse, respBean);
    }
}
