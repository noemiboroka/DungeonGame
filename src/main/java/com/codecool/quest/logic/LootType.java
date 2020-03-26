package com.codecool.quest.logic;

public enum LootType {
    SWORD("sword"),
    KEY("key"),
    BONES("bones");

    public final String lootName;

    LootType(String lootName){this.lootName = lootName;}
}
