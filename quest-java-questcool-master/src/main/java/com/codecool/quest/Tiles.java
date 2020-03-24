package com.codecool.quest;

import com.codecool.quest.logic.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;


public class Tiles {
    public static int TILE_WIDTH = 32;

    private static Image tileset = new Image("/tiles.png", 543 * 2, 543 * 2, true, false);
    private static Map<String, Tile> tileMap = new HashMap<>();

    public static class Tile {
        public final int x, y, w, h;
        Tile(int i, int j) {
            x = i * (TILE_WIDTH + 2);
            y = j * (TILE_WIDTH + 2);
            w = TILE_WIDTH;
            h = TILE_WIDTH;
        }
    }

    static {
        tileMap.put("empty", new Tile(0, 0));
        tileMap.put("wall", new Tile(10, 17));
        tileMap.put("floor", new Tile(2, 0));
        tileMap.put("player", new Tile(27, 0));
        tileMap.put("skeleton", new Tile(29, 6));

        tileMap.put("sword", new Tile(2, 29 ));
        tileMap.put("key", new Tile(14, 29));
        tileMap.put("opendoor", new Tile(3, 10));
        tileMap.put("closeddoor", new Tile(1, 10));
        tileMap.put("health", new Tile(23, 22));
        tileMap.put("police", new Tile(28, 4));

        tileMap.put("next", new Tile(4,13));
        tileMap.put("manBearPig", new Tile(30,8));
        tileMap.put("pudingMonster", new Tile(18,9));
        tileMap.put("closedroom", new Tile(4, 11));
        tileMap.put("grass", new Tile(7,1));
        tileMap.put("chest", new Tile(5,15));
        tileMap.put("openroom", new Tile(2, 9));
        tileMap.put("tree", new Tile(4, 2));
        tileMap.put("crown", new Tile(11, 24));



    }

    public static void drawTile(GraphicsContext context, Drawable d, int x, int y) {
        Tile tile = tileMap.get(d.getTileName());
        context.drawImage(tileset, tile.x, tile.y, tile.w, tile.h,
                x * TILE_WIDTH, y * TILE_WIDTH, TILE_WIDTH, TILE_WIDTH);
    }
}
