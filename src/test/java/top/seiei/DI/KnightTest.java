package top.seiei.DI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;
import top.seiei.base.UnitTestBase;
import top.seiei.bean.BraveKnight;

@RunWith(BlockJUnit4ClassRunner.class)
public class KnightTest extends UnitTestBase {

    public KnightTest() {
        super("classpath:spring/slayDragonKnight.xml");
    }

    // 无法自动装配
    @Autowired
    private BraveKnight braveKnightBak;

    @Test
    public void slayDragon() {
        BraveKnight braveKnight = super.getBean("knight");
        braveKnight.embarkOnQuest();
    }
}
