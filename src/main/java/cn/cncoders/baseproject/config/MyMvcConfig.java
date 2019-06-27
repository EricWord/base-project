package cn.cncoders.baseproject.config;

import cn.cncoders.baseproject.component.LoginInHandlerInterceptor;
import cn.cncoders.baseproject.component.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description 配置文件
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/6/26
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //欢迎页重定向
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");


    }

    /**
     * 注册拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //SpringBoot已经做好静态资源映射，故这里不需要处理静态资源
        registry.addInterceptor(new LoginInHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/index.html", "/", "/user/login");


    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocalResolver();
    }


}
