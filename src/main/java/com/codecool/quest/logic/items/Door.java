package com.codecool.quest.logic.items;

import com.codecool.quest.logic.Cell;

public class Door extends Item {
    public Door(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "door";
    }
}
