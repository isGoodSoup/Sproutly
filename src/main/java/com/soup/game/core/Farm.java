package com.soup.game.core;

import com.soup.game.ent.Crop;
import com.soup.game.enums.CropID;
import com.soup.game.service.Localization;

import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class Farm {
    private static final int SIZE = 16;
    private final Crop[][] crops = new Crop[SIZE][SIZE];
    private final Map<CropID, Integer> harvest;
    private final String user;
    private final String title;

    public Farm() {
        Localization.lang.setLocale(Locale.forLanguageTag("en"));
        final String NAME = Localization.lang.t("game.farm");
        this.user = Paths.get(System.getProperty("user.home")).getFileName().toString();
        this.title = Localization.lang.t("game.farm.title", user, NAME);
        System.out.println(Localization.lang.t("game.welcome", title));
        this.harvest = new LinkedHashMap<>();
        start();
    }

    private void start() {
        int days = 0;
        final int MAX_DAYS = 24;
        boolean isRunning = true;

        plant();

        while(isRunning) {
            String day = Localization.lang.t("game.day");
            System.out.println(day + " " + days);

            displayCrops();
            updateCrops();
            harvestCrops();

            days++;
            if(days > MAX_DAYS) isRunning = false;
        }
    }

    private void plant() {
        for(int row = 0; row < SIZE; row++) {
            for(int col = 0; col < SIZE; col++) {
                crops[row][col] = new Crop(CropID.random());
            }
        }
    }

    private void displayCrops() {
        for(int row = 0; row < SIZE; row++) {
            for(int col = 0; col < SIZE; col++) {
                Crop crop = crops[row][col];
                if (crop == null) {
                    System.out.print("[ ] ");
                } else {
                    System.out.print(crop.canHarvest() ? "[H] " :
                            "[" + crop.getId().getName().charAt(0) + "] ");
                }
            }
            System.out.println();
        }
    }

    private void updateCrops() {
        for(int row = 0; row < SIZE; row++) {
            for(int col = 0; col < SIZE; col++) {
                Crop crop = crops[row][col];
                if (crop != null) crop.grow();
            }
        }
    }

    private void harvestCrops() {
        for(int row = 0; row < SIZE; row++) {
            for(int col = 0; col < SIZE; col++) {
                Crop crop = crops[row][col];
                if(crop != null && crop.canHarvest()) {
                    harvest.merge(crop.getId(), crop.getId().getYield(), Integer::sum);
                    crops[row][col] = null;
                }
            }
        }

        for(Map.Entry<CropID, Integer> entries : harvest.entrySet()) {
            System.out.println(Localization.lang.t("game.yields",
                    entries.getKey().getName(),
                    String.valueOf(entries.getValue())));
        }
    }
}
