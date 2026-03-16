package com.soup.game.enums;

/**
 * Represents the different soil types that can occur on a farm tile.
 * <p>
 * Each soil type influences crop behavior through three modifiers:
 * </p>
 * <ul>
 *   <li><b>Growth modifier</b> – affects the speed at which crops grow.</li>
 *   <li><b>Water modifier</b> – determines how well the soil retains moisture.</li>
 *   <li><b>Yield modifier</b> – influences the quantity or quality of harvested crops.</li>
 * </ul>
 *
 * <p>
 * These modifiers are applied by the farming system when calculating crop
 * growth progression, hydration decay, and harvest rewards.
 * A value of {@code 1.0f} represents a neutral effect.
 * Values above {@code 1.0f} increase the effect, while values below
 * {@code 1.0f} decrease it.
 * </p>
 *
 * <p>Example:</p>
 * <ul>
 *   <li>{@link #SANDY} dries quickly but allows slightly faster root growth.</li>
 *   <li>{@link #CLAY} retains water well but slows crop development.</li>
 *   <li>{@link #FERTILE} improves both growth and yield.</li>
 * </ul>
 */
public enum Soil {
    LOAM(1.0f, 1.0f, 1.0f),
    SANDY(1.3f, 0.6f, 0.8f),
    CLAY(0.7f, 1.4f, 0.9f),
    SILT(1.0f, 1.1f, 1.0f),
    FERTILE(1.2f, 1.1f, 1.3f),
    ROCKY(0.6f, 0.9f, 0.6f),
    DRY(0.7f, 0.5f, 0.7f),
    SWAMP(0.8f, 1.5f, 0.9f);

    private final float growth;
    private final float water;
    private final float yield;

    /**
     * Constructs a soil type with specific farming modifiers.
     * @param growth multiplier applied to crop growth speed
     * @param water multiplier applied to water retention
     * @param yield multiplier applied to harvest yield
     */
    Soil(float growth, float water, float yield) {
        this.growth = growth;
        this.water = water;
        this.yield = yield;
    }

    /**
     * Returns the growth modifier of the soil.
     * @return growth multiplier affecting crop development speed
     */
    public float getGrowthModifier() {
        return growth;
    }

    /**
     * Returns the water retention modifier of the soil.
     * @return multiplier affecting hydration retention
     */
    public float getWaterModifier() {
        return water;
    }

    /**
     * Returns the yield modifier of the soil.
     * @return multiplier affecting the amount or quality of harvested crops
     */
    public float getYieldModifier() {
        return yield;
    }
}