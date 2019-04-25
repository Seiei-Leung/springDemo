package top.seiei.bean;

import top.seiei.interfaces.Quest;

public class BraveKnight {

    private Quest quest;

    public BraveKnight(Quest quest) {
        this.quest = quest;
    }

    public void embarkOnQuest() {
        quest.embark();
    }
}
