package top.seiei.base;

import org.junit.After;
import org.junit.Before;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试单元的生命周期事件
 */
public class UnitTestBase {

    private ClassPathXmlApplicationContext classPathXmlApplicationContext;

    private String springXmlpath = "";

    public UnitTestBase() {
    }

    public UnitTestBase(String springXmlpath) {
        this.springXmlpath = springXmlpath;
    }

    /**
     * 单元测试之前，创建 spring 上下文容器
     */
    @Before
    public void before() {
        if ("".equals(springXmlpath)) {
            springXmlpath = "classpath*:spring-*.xml";
        }
        try {
            classPathXmlApplicationContext = new ClassPathXmlApplicationContext(springXmlpath.split("[,\\s]+"));
            classPathXmlApplicationContext.start();
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }

    /**
     * 单元测试之后，清除资源
     */
    @After
    public void after() {
        classPathXmlApplicationContext.destroy();
    }

    /**
     * 在上下文容器中获取 bean
     * @param beanId 根据名称获取
     * @param <T> 该 bean 的类型
     * @return bean 值
     */
    @SuppressWarnings("unchecked")
    protected <T extends Object> T getBean(String beanId) {
        try {
            return (T) classPathXmlApplicationContext.getBean(beanId);
        } catch (BeansException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 在上下文容器中获取 bean
     * @param clazz 根据 class 类型获取
     * @param <T> 该 bean 的类型
     * @return bean 值
     */
    protected <T extends Object> T getBean(Class<T> clazz) {
        try {
            return classPathXmlApplicationContext.getBean(clazz);
        } catch (BeansException e) {
            e.printStackTrace();
            return null;
        }
    }
}
