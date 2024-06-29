package org.web.interceptor;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// HandlerInterceptor 屬於 Spring MVC 攔截器
// 主要攔截來自於 Web 的 request => implements HandlerInterceptor
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Value("${jwt.secret}")
    private String secret;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    // 請求在進入Controller之前執行，用來初始化、預處理、判斷是否繼續執行下去
    // 回傳Boolean值，返回false => 後續Interceptor和Controller都不執行
    // 目標: 若沒有登入(權限) => 返回登入頁面
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("攔截開始");

        final String requestTokenHeader = request.getHeader("Authorization");
        String jwtToken = null;
        if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            jwtToken = requestTokenHeader.substring(7);
            Claims claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(jwtToken)
                    .getBody();
            Integer userId = Integer.parseInt(claims.getSubject());
            request.setAttribute("userId", userId);
            return true;
        }
        return false;
    }

    // 預處理程式及Controller完成後 => 視圖渲染之前
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("已取得權限");
        // 繼續調用下一個攔截器
        //response.sendRedirect("http://localhost:3030/movies");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("攔截結束");
    }
}
