package top.seiei.bean;

import top.seiei.interfaces.Quest;

public class SlayDragonQuest implements Quest {

    @Override
    public void embark() {
        System.out.println("Emarking on quest to slay the dragon!!");
    }
}
