package com.soup.game.world;

import com.soup.game.service.Console;
import com.soup.game.service.Stats;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a player's collection of quests in the game world.
 * <p>
 * The {@code QuestLog} stores all quests assigned to a player, allowing
 * addition, removal, retrieval, and display of quests. It is primarily
 * used in the TUI to show the player's active or completed quests.
 * </p>
 *
 * <p>Example usage:</p>
 * <pre>{@code
 * QuestLog log = new QuestLog();
 * log.add(new Quest(...));
 * log.show();  // prints all quests to the console
 * }</pre>
 */
public class QuestLog {
    private final List<Quest> quests;

    /**
     * Constructs a new, empty {@code QuestLog}.
     */
    public QuestLog() {
        this.quests = new ArrayList<>();
    }

    /**
     * Returns the list of quests currently in the log.
     * @return a {@link List} of {@link Quest} objects
     */
    public List<Quest> quests() {
        return quests;
    }

    /**
     * Adds a quest to the log.
     * @param q the {@link Quest} to add
     */
    public void add(Quest q) {
        quests.add(q);
    }

    /**
     * Retrieves a quest by its index in the log.
     *
     * @param i the index of the quest
     * @return the {@link Quest} at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public Quest get(int i) {
        return quests.get(i);
    }

    /**
     * Displays all quests in the log to the console.
     * <p>
     * Each quest is printed with its name and required count.
     * Uses {@link Console} with purple color formatting for readability.
     * </p>
     */
    public void show() {
        for (Quest q : quests) {
            Console.cli.println(q.name() + " " + q.required(), Console.PURPLE);
        }
    }

    /**
     * Removes a quest from the log.
     * @param q the {@link Quest} to remove
     */
    public void remove(Quest q) {
        quests.remove(q);
        Stats.stat.totalQuests++;
    }
}