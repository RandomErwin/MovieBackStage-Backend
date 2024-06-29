package org.web.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.web.interceptor.LoginInterceptor;

// header: 'Access-Control-Allow-Origin', VALID_ORIGIN
// header: 'Access-Control-Allow-Headers', 'content-type'
// header: 'Access-Control-Allow-Credentials', true
// 簡單請求 => 阻檔 response; 非簡單請求preflight => 阻檔 request

@Configuration
@EnableWebMvc // 表示為 Web MVC配置類別 => 靜態資源訪問
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    // 允許所有來源 => 若前端帶上cookie，後端必須指定哪個origin有權限
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // 對所有路徑進行CORS設置
                .allowedOrigins("http://localhost:3030")
                .allowCredentials(true)
                .allowedMethods("*") // 允許所有HTTP方法
                .allowedHeaders("*") // 允許所有標頭
                .exposedHeaders("*"); // 允許自定義標頭
        }
    // 覆寫 addInterceptors方法，註冊攔截器 => 調用addPathPatterns()攔截URL請求路徑(後端API)
    // loginInterceptor => 必須用 autowired 而非 new LoginInterceptor()
    // 攔截器會出現在有加入的Pattern addInterceptor("URL") => 登入頁不需要攔截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/permission/**");
    }
}
