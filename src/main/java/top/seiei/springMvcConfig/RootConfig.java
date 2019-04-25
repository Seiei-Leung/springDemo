package top.seiei.springMvcConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 该类是用于加载 ContextLoaderListener 应用上下文的配置类
 *
 * 本类包括：
 * - 导入其它应用上下文的配置文件
 * - 导入 .properties 的文件
 * - 扫描加载应用中的其他 bean，如中间层和数据层组件
 */
@Configuration
@PropertySource("classpath:properties/jdbc.properties") // 导入 .properties 文件
/*@ComponentScan("top.seiei") // 启动组件扫描*/
public class RootConfig {

}
