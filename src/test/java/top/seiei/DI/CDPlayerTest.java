package top.seiei.DI;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.seiei.bean.BraveKnight;
import top.seiei.bean.CDPlayer;
import top.seiei.interfaces.CD;
import top.seiei.springConfig.CDPlayerConfig;

/**
 * @ActiveProfiles 注释用于在测试单元中定义 环境
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
@ActiveProfiles("dev")
public class CDPlayerTest {

    @Autowired
    private CD cd;

    @Autowired
    private CDPlayer cdPlayer;

    @Autowired
    private BraveKnight braveKnight;

    @Test
    public void cdShouldNotBeNull() {
        cdPlayer.start();
        assertNotNull(cd);
    }

    @Test
    public void testImportAnnotation() {
        braveKnight.embarkOnQuest();
    }
}
