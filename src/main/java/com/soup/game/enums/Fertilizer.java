package com.soup.game.enums;

/**
 * Represents fertilizer types that can be applied to a farm tile.
 * <p>
 * Fertilizers provide temporary or permanent bonuses to crop growth,
 * hydration efficiency, or harvest yield.
 * </p>
 *
 * <ul>
 *   <li>{@link #NONE} – no fertilizer applied.</li>
 *   <li>{@link #SPEED} – increases crop growth speed.</li>
 *   <li>{@link #YIELD} – improves the amount or value of harvested crops.</li>
 *   <li>{@link #WATER_RETENTION} – improves the soil's ability to retain moisture.</li>
 * </ul>
 *
 * <p>
 * Fertilizers are typically applied to a {@code Tile} and influence crop
 * behavior during the growth cycle.
 * </p>
 */
public enum Fertilizer {
    NONE, SPEED, YIELD, WATER_RETENTION
}