package top.seiei.bean;

import org.springframework.stereotype.Component;
import top.seiei.interfaces.CD;

/**
 * @Component 注释声明该类为 组件类
 * 用于自动扫描
 */
@Component
public class CDOfTaka implements CD {

    private String title = "Ambitions";
    private String artist = "OOR";

    @Override
    public void play() {
        System.out.println(title + " was played by " + artist);
    }
}