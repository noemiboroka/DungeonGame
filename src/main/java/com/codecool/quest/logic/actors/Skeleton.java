package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;


public class Skeleton extends Actor {


    public Skeleton(Cell cell) {
        super(cell);
        setType("monster");
    }


    @Override
    public String getTileName() {
        return "skeleton";
    }


}
