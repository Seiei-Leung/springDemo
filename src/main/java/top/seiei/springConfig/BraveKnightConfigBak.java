package top.seiei.springConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import top.seiei.aspects.MinstrelByAspect;
import top.seiei.bean.BraveKnight;
import top.seiei.bean.Minstrel;
import top.seiei.bean.SlayDragonQuest;

/**
 * @EnableAspectJAutoProxy 注解用于启用 AspectJ 自动代理
 */
@Configuration
@EnableAspectJAutoProxy
public class BraveKnightConfigBak {

    @Bean
    public Minstrel minstrel(){
        return new Minstrel();
    }

    @Bean
    public MinstrelByAspect minstrelByAspect() {
        return new MinstrelByAspect();
    }

    @Bean
    public SlayDragonQuest slayDragonQuest() {
        return new SlayDragonQuest();
    }

    @Bean
    public BraveKnight braveKnight(SlayDragonQuest slayDragonQuest) {
        return new BraveKnight(slayDragonQuest);
    }
}
