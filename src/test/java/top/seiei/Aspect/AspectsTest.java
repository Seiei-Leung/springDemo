package top.seiei.Aspect;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.seiei.aspects.RegisterCDCounter;
import top.seiei.bean.BraveKnight;
import top.seiei.bean.CDPlayer;
import top.seiei.interfaces.CD;
import top.seiei.springConfig.CDPlayerConfig;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class AspectsTest {

    @Autowired
    private CD cd;

    @Autowired
    private CDPlayer cdPlayer;

    @Autowired
    private BraveKnight braveKnight;

    @Autowired
    private RegisterCDCounter registerCDCounter;

    @Test
    public void testOfNormalAspect() {
        braveKnight.embarkOnQuest();
    }

    @Test
    public void testOfArgsAnnotation() {
        cdPlayer.registerCD(1);
        cdPlayer.registerCD(1);
        assertEquals(2, registerCDCounter.cdCounts.get(1).longValue());
    }

}
