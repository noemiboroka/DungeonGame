package com.codecool.quest.logic;

public class InventoryLoader {
    public static GameInventory loadInventory() {
        int width = 3;
        int height = 3;

        GameInventory gameInventory = new GameInventory(width, height, CellType.EMPTY);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Cell cell = gameInventory.getCell(x, y);
            }
        }
        return gameInventory;
    }
}
