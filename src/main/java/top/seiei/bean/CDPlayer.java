package top.seiei.bean;

import org.springframework.stereotype.Component;
import top.seiei.interfaces.CD;

@Component
public class CDPlayer {

    private CD cd;

    public CDPlayer(CD cd) {
        this.cd = cd;
    }

    public void start() {
        cd.play();
    }

    public void registerCD(Integer id) {

    }
}
