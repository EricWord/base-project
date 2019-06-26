package cn.cncoders.baseproject.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Description 配置文件
 * @Author eric
 * @Version V1.0.0
 * @Date 2019/6/26
 */
@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addRedirectViewController("/eric","success");
        //欢迎页重定向
        registry.addRedirectViewController("/","login");
        registry.addRedirectViewController("/index.html","login");

    }
}
