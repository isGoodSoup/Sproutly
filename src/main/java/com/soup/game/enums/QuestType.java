package com.soup.game.enums;

import java.util.Random;

public enum QuestType {
    BREED, FETCH, HARVEST, KILL;

    private static final Random random = new Random();

    /**
     * Returns a random quest type for quests
     * @return a randomly selected {@link QuestType} value
     */
    public static QuestType getRandomQuest() {
        QuestType[] roles = QuestType.values();
        return roles[random.nextInt(roles.length)];
    }
}
