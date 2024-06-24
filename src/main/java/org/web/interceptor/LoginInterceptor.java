package org.web.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    // 請求進入Controller之前執行，用來初始化、預處理、判斷是否繼續執行下去
    // 回傳Boolean值，返回false => 後續Interceptor和Controller都不執行
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        if(request.getSession().getAttribute("users") == null){
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
