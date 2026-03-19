package com.soup.game.enums;

/**
 * Enum representing configurable game rules in the engine.
 * <p>
 * Each {@code Gamerule} instance defines a specific gameplay mechanic or system
 * that can be toggled on or off at runtime. These rules control core engine behaviors
 * such as cheat permissions, market interactions, entity breeding, leveling,
 * experience gain, weather cycles, and tutorial availability.
 * </p>
 * <p>
 * This enum also provides utility methods for accessing the rule's key,
 * retrieving its current value, and modifying it dynamically.
 * </p>
 * <h2>Usage Example:</h2>
 * <pre>{@code
 * // Check if experience gain is enabled
 * if (Gamerule.ENABLE_EXPERIENCE.value()) {
 *     player.addExperience(100);
 * }
 *
 * // Dynamically disable weather cycle
 * Gamerule.ENABLE_WEATHER_CYCLE.setValue(false);
 * }</pre>
 *
 * @author isGoodSoup
 * @version 1.0
 */
public enum Gamerule {
    /** Allows the use of cheats in the game. Default: false */
    ENABLE_CHEATS("doEnableCheats", false),

    /** Enables market interactions for players. Default: true */
    ENABLE_MARKET("doEnableMarket", true),

    /** Allows entities to breed. Default: true */
    ENABLE_BREEDING("doEnableBreeding", true),

    /** Enables leveling system for players or entities. Default: true */
    ENABLE_LEVEL_UP("doEnableLevelUp", true),

    /** Allows entities or players to gain experience points. Default: true */
    ENABLE_EXPERIENCE("doEnableExperienceGain", true),

    /** Enables weather cycles such as rain and day-night changes. Default: true */
    ENABLE_WEATHER_CYCLE("doEnableWeatherCycle", true),

    /** Allows stopping time in the game. Default: false */
    ENABLE_STOP_TIME("doEnableStopTime", false),

    /** Enables the in-game tutorial system. Default: true */
    ENABLE_TUTORIAL("doEnableTutorial", true);

    public final static Gamerule rule = Gamerule.ENABLE_TUTORIAL;
    private final String key;
    private boolean value;

    /**
     * Constructs a {@code Gamerule} with a key and default value.
     *
     * @param key   the unique string identifier for this game rule
     * @param value the default state of the rule
     */
    Gamerule(String key, boolean value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Returns the {@code Gamerule} corresponding to a given key.
     * <p>
     * Performs a case-insensitive match against the internal key.
     * </p>
     *
     * @param str the key string to search for
     * @return the {@code Gamerule} matching the key, or {@code null} if not found
     */
    public Gamerule keyOf(String str) {
        if(str.equalsIgnoreCase(key)) {
            return this;
        }
        return null;
    }

    public String key() {
        return key;
    }

    public boolean value() {
        return value;
    }

    /**
     * Sets the current value of this rule.
     * <p>
     * This method allows dynamic toggling of game mechanics at runtime.
     * </p>
     * @param value the new state of the rule
     */
    public void setValue(boolean value) {
        this.value = value;
    }
}
