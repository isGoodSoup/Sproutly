package com.soup.game.world;

import com.soup.game.enums.Fertilizer;
import com.soup.game.enums.Soil;
import com.soup.game.intf.Data;
import com.soup.game.intf.World;

/**
 * Represents a single tile on the farm grid.
 * <p>
 * A tile is the fundamental unit of the farming world and may contain:
 * </p>
 *
 * <ul>
 *   <li>A {@link Crop} currently planted on the tile</li>
 *   <li>A {@link Soil} type that influences crop growth and hydration</li>
 *   <li>A {@link Fertilizer} that modifies farming behavior</li>
 * </ul>
 *
 * <p>
 * Tiles are typically arranged in a 2D grid within the farm world and
 * are used to simulate planting, watering, harvesting, and soil
 * management mechanics.
 * </p>
 *
 * <p>
 * Because this class is implemented as a {@code record}, it is immutable
 * and primarily used as a lightweight data container within the game
 * world.
 * </p>
 *
 * @param crop the crop planted on the tile, or {@code null} if empty
 * @param soil the soil type affecting crop behavior
 * @param fertilizer the fertilizer applied to the tile
 */
@Data
@World
public record Tile(Crop crop, Soil soil, Fertilizer fertilizer) {
    /**
     * Replaces the old tile with a new crop, since records are immutable my design
     * @param crop accepts the new {@link Crop}
     * @return the new {@link Tile} instance
     */
    public Tile withCrop(Crop crop) {
        return new Tile(crop, soil, fertilizer);
    }

    /**
     * Replaces the old tile with a new soil type, since records are immutable my design
     * @param soil accepts the new {@link Soil}
     * @return the new {@link Tile} instance
     */
    public Tile withSoil(Soil soil) {
        return new Tile(crop, soil, fertilizer);
    }

    /**
     * Replaces the old tile with a new fertilizer, since records are immutable my design
     * @param fertilizer accepts the new {@link Fertilizer}
     * @return the new {@link Tile} instance
     */
    public Tile withFertilizer(Fertilizer fertilizer) {
        return new Tile(crop, soil, fertilizer);
    }
}