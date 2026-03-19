package com.soup.game.world;

/**
 * Tracks the progress of a {@link Quest} for a player.
 * <p>
 * This record stores the associated quest and the current progress count
 * toward completing it. It provides a helper method to determine if
 * the quest is complete.
 * </p>
 */
public record QuestProgress(Quest quest, int progress) {

    /**
     * Returns true if the quest has been completed.
     * @return {@code true} if {@code progress >= quest.required()}, {@code false} otherwise
     */
    public boolean isComplete() {
        return progress >= quest.required();
    }
}