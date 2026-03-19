package com.soup.game.enums;

import java.util.Random;

/**
 * Represents the different job roles an NPC can have in the game.
 * <p>
 * Each NPC can be assigned a role, which might affect their behavior,
 * dialogue, or services they provide on the farm.
 * </p>
 */
public enum Role {
    FARMER,
    BLACKSMITH,
    MERCHANT,
    FISHERMAN,
    HERBALIST,
    BAKER,
    CARPENTER,
    HUNTER,
    GUARD,
    ALCHEMIST;

    private static final Random random = new Random();

    /**
     * Returns a random job role for an NPC
     * @return a randomly selected {@link Role} value
     */
    public static Role getRandomRole() {
        Role[] roles = Role.values();
        return roles[random.nextInt(roles.length)];
    }
}
