package com.langg.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 拦截处理
 *
 * @author zh
 * @date 2019/11/14 11:19
 * @since 1.0.0
 */
@Component
public class SecurityInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        HttpSession session = request.getSession();

        response.setContentType("application/text; charset=utf-8");
        if (session.getAttribute(session.getId()) != null) {
            return true;
        }
        response.getWriter().write("请先登陆");
        return false;
    }
}
