package com.soup.game.enums;

import com.soup.game.intf.Data;
import com.soup.game.service.Localization;

import java.util.Random;

@Data
public enum CropID {
    WHEAT("crop.wheat", 8, 2),
    CORN("crop.corn", 16, 4),
    CARROT("crop.carrot", 8, 8),
    POTATO("crop.potato", 16, 16),
    TOMATO("crop.tomato", 16, 8),
    STRAWBERRY("crop.strawberry", 24, 16),
    APPLE("crop.apple", 32, 16),
    GRAPE("crop.grape", 16, 16),
    PUMPKIN("crop.pumpkin", 32, 24),
    CABBAGE("crop.cabbage", 8, 24);

    private static final Random random = new Random();
    private final String name;
    private final int yield;
    private final int days;

    CropID(String name, int yield, int days) {
        this.name = name;
        this.yield = yield;
        this.days = days;
    }

    public static CropID random() {
        return CropID.values()[random.nextInt(0, CropID.values().length - 1)];
    }
    public String getName() {
        return Localization.lang.t(name);
    }
    public int getYield() {
        return yield;
    }
    public int getDays() {
        return days;
    }
}