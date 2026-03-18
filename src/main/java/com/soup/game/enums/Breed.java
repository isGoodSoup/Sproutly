package com.soup.game.enums;

import com.soup.game.ent.Animal;

import java.util.Random;

/**
 * Represents dog breeds with breed-specific traits.
 * <p>
 * Useful for assigning size, average weight, and other breed-specific
 * attributes to {@link Animal} instances of type dog.
 * </p>
 */
public enum Breed {
    AUSTRALIAN_SHEPHERD(50, 20),
    GERMAN_SHEPHERD(60, 30),
    GOLDEN_RETRIEVER(58, 32),
    BEAGLE(38, 12);

    private final int height;
    private final int weight;
    private static final Random RANDOM = new Random();

    Breed(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public int height() {
        return height;
    }

    public int weight() {
        return weight;
    }

    /**
     * Returns a randomly selected {@link Breed}.
     * @return a random dog breed
     */
    public static Breed random() {
        Breed[] breeds = Breed.values();
        return breeds[RANDOM.nextInt(breeds.length)];
    }
}