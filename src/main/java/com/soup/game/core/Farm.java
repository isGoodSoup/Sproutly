package com.soup.game.core;

import com.soup.game.ent.Crop;
import com.soup.game.enums.CropID;
import com.soup.game.service.Localization;

import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Farm {
    private final Crop[][] crops;
    private final Map<CropID, Integer> harvest;
    private final String user;
    private final String title;
    private final Scanner scan;

    private final static int MAX_SIZE = 256;
    private static int SIZE = 16;
    private static int coin;
    private static int days;

    public Farm() {
        this.crops = new Crop[MAX_SIZE][MAX_SIZE];
        Localization.lang.setLocale(Locale.forLanguageTag("en"));
        final String NAME = Localization.lang.t("game.farm");
        this.user = Paths.get(System.getProperty("user.home")).getFileName().toString();
        this.title = Localization.lang.t("game.farm.title", user, NAME);
        print(Localization.lang.t("game.welcome", title));
        this.harvest = new LinkedHashMap<>();
        this.scan = new Scanner(System.in);
        start();
    }

    private void start() {
        days = 0;
        coin = 0;

        plant();
        String cmd = "";
        String day = Localization.lang.t("game.day");

        do {
            print(day + " " + days);
            update();
            if(!cmd.equalsIgnoreCase("skip")) {
                harvest();
            }

            do {
                cmd = reply(Localization.lang.t("game.cmd"));
                switch (cmd.toLowerCase()) {
                    case "replant" -> plant();
                    case "stats" -> showStats();
                    case "sell" -> sellCrops();
                    case "buy" -> buyPlot();
                    case "skip" -> days++;
                    case "sleep" -> sleep();
                    case "end" -> {}
                    default -> print("Unknown command!");
                }
            } while (!cmd.equalsIgnoreCase("skip") && !cmd.equalsIgnoreCase("end"));
        } while (!cmd.equalsIgnoreCase("end"));
        showStats();
    }

    private void plant() {
        for(int[] pos : index()) {
            crops[pos[0]][pos[1]] = new Crop(CropID.random());
        }
    }

    private void update() {
        for(int row = 0; row < SIZE; row++) {
            for(int col = 0; col < SIZE; col++) {
                Crop crop = crops[row][col];
                if (crop == null) {
                    System.out.print("[ ] ");
                } else {
                    System.out.print(crop.canHarvest() ? "[H] " :
                            "[" + crop.getId().getName().charAt(0) + "] ");
                    crop.grow();
                }
            }
            println();
        }
    }

    private void harvest() {
        Map<CropID, Integer> todayHarvest = new LinkedHashMap<>();

        for(int[] pos : index()) {
            Crop crop = crops[pos[0]][pos[1]];
            if(crop != null && crop.canHarvest()) {
                todayHarvest.merge(crop.getId(), crop.getId().getYield(), Integer::sum);
                harvest.merge(crop.getId(), crop.getId().getYield(), Integer::sum);
                crops[pos[0]][pos[1]] = null;
            }
        }

        for(Map.Entry<CropID, Integer> entry : todayHarvest.entrySet()) {
            print(Localization.lang.t("game.yields",
                    entry.getKey().getName(), entry.getValue()));
        }
    }

    private void sleep() {
        print(Localization.lang.t("game.sleep"));
        days++;
    }

    private void sellCrops() {
        for(Map.Entry<CropID, Integer> entries : harvest.entrySet()) {
            coin += entries.getKey().getValue() * entries.getValue();
        }
        print(Localization.lang.t("game.sold", coin));
    }

    private void buyPlot() {
        int plotCost = 128;
        int increase = 2;

        if (coin < plotCost) {
            return;
        }

        if (SIZE + increase > MAX_SIZE) {
            print(Localization.lang.t("game.plot.size"));
            return;
        }

        int oldSize = SIZE;
        SIZE += increase;
        coin -= plotCost;
        int newPlots = SIZE * SIZE - oldSize * oldSize;
        print(Localization.lang.t("game.plot", coin, newPlots));
    }
    
    private void showStats() {
        print(Localization.lang.t("game.stats"));
        int totalCrops = 0;
        for(Map.Entry<CropID, Integer> entries : harvest.entrySet()) {
            totalCrops += entries.getValue();
        }
        print(Localization.lang.t("game.stats.crops", totalCrops));
        print(Localization.lang.t("game.stats.days",days));
    }

    private static int[][] index() {
        int[][] indices = new int[SIZE * SIZE][2];
        int k = 0;
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                indices[k][0] = row;
                indices[k][1] = col;
                k++;
            }
        }
        return indices;
    }

    private String reply(String q) {
        print(q);
        return scan.nextLine();
    }

    private void print(String str) {
        System.out.println(str);
    }

    private void println() {
        System.out.println();
    }
}
