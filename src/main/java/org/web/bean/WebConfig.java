package org.web.bean;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.web.interceptor.LoginInterceptor;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // 對所有路徑進行CORS設置
                .allowedOrigins("*") // 允許所有來源
                .allowedMethods("*") // 允許所有HTTP方法
                .allowedHeaders("*") // 允許所有標頭
                .exposedHeaders("*"); // 允許自定義標頭
        }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/")
                .excludePathPatterns("/login", "/static/**");
    }
}

// header: 'Access-Control-Allow-Origin', VALID_ORIGIN
// header: 'Access-Control-Allow-Headers', 'content-type'
// header: 'Access-Control-Allow-Credentials', true

// 簡單請求 => 阻檔 response; 非簡單請求preflight => 阻檔 request