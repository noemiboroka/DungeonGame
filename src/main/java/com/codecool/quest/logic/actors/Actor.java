package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.CellType;
import com.codecool.quest.logic.Drawable;
import com.codecool.quest.logic.Inventory;

public abstract class Actor implements Drawable {
    private Cell cell;
    private int health = 10;
    private Inventory inventory;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
        this.inventory = new Inventory();
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
            if(!nextCell.getType().equals(CellType.WALL)){
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
    }

    public int getHealth() {
        return health;
    }

    public Cell getCell() {
        return cell;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }
}
