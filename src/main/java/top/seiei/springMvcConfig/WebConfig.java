package top.seiei.springMvcConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.List;

/**
 * 该类是用于加载 DispatcherServlet 应用上下文的配置类
 * 在使用 XML 配置的时候，可以使用声明 <mvc:annotation-driven> 来启动注解驱动的 Spring MVC
 * 在 JavaConfig 配置中，可以使用 @EnaleWebMvc 来启动 Spring MVC
 *
 * 本类包含：
 * - 配置视图解析器
 * - 扫描加载应用中的控制器组件
 * - 配置静态资源的处理：扩展 WebMvcConfigurerAdapter 并重写了 configureDefaultServeltHandling 方法
 */
@Configuration
@EnableWebMvc // 启动 Spring Mvc
@ComponentScan("top.seiei.controller") // 启动组件扫描，导入控制器
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     *  配置 JSP 视图解析器
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/");
        resolver.setSuffix(".html");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    /**
     *  以下两个 Bean 用于收，发 json 数据，支持 @RequestBody 注释将json对象转换为 java 对象
     */
    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
        return mappingJackson2HttpMessageConverter;
    }
    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter(MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter) {
        RequestMappingHandlerAdapter requestMappingHandlerAdapter = new RequestMappingHandlerAdapter();
        List<HttpMessageConverter<?>> httpMessageConverters = new ArrayList<>();
        httpMessageConverters.add(mappingJackson2HttpMessageConverter);
        requestMappingHandlerAdapter.setMessageConverters(httpMessageConverters);
        return requestMappingHandlerAdapter;
    }

    /**
     * 文件上传
     */
    @Bean("multipartResolver")
    public CommonsMultipartResolver commonsMultipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSize(10485760);
        commonsMultipartResolver.setMaxInMemorySize(4096);
        commonsMultipartResolver.setDefaultEncoding("UTF-8");
        return commonsMultipartResolver;
    }

    /**
     * 配置静态资源的处理
     * 通过调用 DefaultServletHandlerConfigurer 的 enable 方法
     * 会使 DispathcerServlet 将对静态资源的请求转发到 Servlet 容器中默认的 Servlet 上
     * 而不是使用 DispatcherServlet 本身来处理此类请求
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
