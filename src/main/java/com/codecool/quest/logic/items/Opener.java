package com.codecool.quest.logic.items;

import com.codecool.quest.logic.Cell;

public class Opener extends Item {
    public Opener(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "opener";
    }
}
