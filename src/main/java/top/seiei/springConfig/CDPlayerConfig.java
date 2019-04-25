package top.seiei.springConfig;

import org.springframework.context.annotation.*;
import top.seiei.aspects.RegisterCDCounter;
import top.seiei.bean.CDOfTaka;
import top.seiei.bean.CDPlayer;
import top.seiei.interfaces.CD;

/**
 * @Configuration 注释是用于声明该 JAVA 文件是 Spring 配置代码
 * @ComponentScan 注释用于表明自动扫描基础包下使用了 @Component 等注释声明的 Bean
 */
@Configuration
@Import(BraveKnightConfigBak.class)
@EnableAspectJAutoProxy
/*@ComponentScan(value = "top.seiei.bean")*/
public class CDPlayerConfig {

    @Bean
    public RegisterCDCounter registerCDCounter() {
        return new RegisterCDCounter();
    }

    /**
     * @Bean 表示会创建一个 bean 实例并将注册到 Spring 应用上下文
     */
    @Bean
    public CD cdOfTaka() {
        return new CDOfTaka();
    }

    @Bean
    public CDPlayer cdPlayer(CD cd) {
        return new CDPlayer(cd);
    }
}