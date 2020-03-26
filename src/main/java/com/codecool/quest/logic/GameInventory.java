package com.codecool.quest.logic;

import com.codecool.quest.logic.items.Item;

public class GameInventory {
    private int width;
    private int height;
    private Cell[][] cells;

    private Item item;

    public GameInventory(int width, int height, CellType defaultCellType) {
        this.width = width;
        this.height = height;
        cells = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell(this, x, y, defaultCellType);
            }
        }
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void storeItem(Item item) {
        for (int y = 0; y < width; y++) {
            for (int x = 0; x < height; x++) {
                if (cells[x][y].getItem() == null) {
                    cells[x][y].setItem(item);
                    return;
                }
            }
        }
    }
}
