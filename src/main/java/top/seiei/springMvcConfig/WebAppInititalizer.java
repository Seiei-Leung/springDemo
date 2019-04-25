package top.seiei.springMvcConfig;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 同时使用这个和 web.xml 会发生冲突报错
 */
public class WebAppInititalizer {

}

/*public class WebAppInititalizer extends AbstractAnnotationConfigDispatcherServletInitializer {

    *//**
     * 指定 ContextLoaderListener 加载应用上下文的配置类
     * @return
     *//*
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }

    *//**
     * 指定 DispatcherServlet 加载应用上下文的配置类
     * @return
     *//*
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }

    *//**
     * 用于将 DispatcherServlet 映射到“/”上
     * @return
     *//*
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}*/
