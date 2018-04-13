package tk.baseaccept.pass.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/*********************************************************************
 * @Author: Administrator extends BaseAccpet 
 * @Date: 2018/4/12 0012 下午 8:08 
 * @Package: tk.baseaccept.pass.chat.config
 * @ClassInfo
 * 配置静态资源映射
 **********************************************************************/
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //将所有/static/** 访问都映射到classpath:/static/ 目录下
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}