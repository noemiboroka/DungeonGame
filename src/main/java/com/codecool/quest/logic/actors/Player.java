package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.CellType;
import com.codecool.quest.logic.GameInventory;
import com.codecool.quest.logic.actors.Actor;

public class Player extends Actor {
    public Player(Cell cell) {
        super(cell);
    }

    public void collectItem(GameInventory gameInventory, Cell cell) {
        if (cell.getItem() != null) {
            gameInventory.storeItem(cell.getItem());
            cell.setItem(null);
            cell.setType(CellType.FLOOR);

        }
    }

    public String getTileName() {
        return "player";
    }
}
