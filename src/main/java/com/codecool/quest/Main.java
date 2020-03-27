package com.codecool.quest;

import com.codecool.quest.logic.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    GameMap map = MapLoader.loadMap();
    Canvas canvas = new Canvas(
            map.getWidth() * Tiles.TILE_WIDTH,
            map.getHeight() * Tiles.TILE_WIDTH);
    GraphicsContext context = canvas.getGraphicsContext2D();

    GameInventory gameInventory = InventoryLoader.loadInventory();
    Canvas inventoryCanvas = new Canvas(
            gameInventory.getWidth() * Tiles.TILE_WIDTH,
            gameInventory.getHeight() * Tiles.TILE_WIDTH);
    GraphicsContext inventoryContext = inventoryCanvas.getGraphicsContext2D();
    Label healthLabel = new Label();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setResizable(false);

        Image thumbnail = new Image("/tiles.png");
        primaryStage.getIcons().add(thumbnail);

        GridPane ui = new GridPane();
        ui.setPrefWidth(200);
        ui.setPadding(new Insets(10));

        ui.add(new Label("Health: "), 0, 0);
        ui.add(healthLabel, 1, 0);

        ui.add(new Label("Inventory: "), 0, 2);
        ui.add(inventoryCanvas, 0,3);

        BorderPane borderPane = new BorderPane();

        borderPane.setCenter(canvas);
        borderPane.setRight(ui);
        

        Button collectButton = new Button("Collect item");
        collectButton.setOnAction(actionEvent ->  {
            map.getPlayer().collectItem(gameInventory, map.getPlayer().getCell());

            refresh();

            borderPane.requestFocus();

        });


        ui.add(collectButton, 0, 50);

        Scene scene = new Scene(borderPane);

        borderPane.requestFocus();

        primaryStage.setScene(scene);
        refresh();
        scene.setOnKeyPressed(this::onKeyPressed);

        primaryStage.setTitle("Codecool Quest");
        primaryStage.show();
    }

    private void onKeyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case UP:
                map.getPlayer().move(0, -1);
                refresh();
                break;
            case DOWN:
                map.getPlayer().move(0, 1);
                refresh();
                break;
            case LEFT:
                map.getPlayer().move(-1, 0);
                refresh();
                break;
            case RIGHT:
                map.getPlayer().move(1,0);
                refresh();
                break;
        }
    }

    private void refresh() {
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (int x = 0; x < map.getWidth(); x++) {
            for (int y = 0; y < map.getHeight(); y++) {
                Cell cell = map.getCell(x, y);
                if (cell.getActor() != null) {
                    Tiles.drawTile(context, cell.getActor(), x, y);
                } else if (cell.getItem() != null) {
                    Tiles.drawTile(context, cell.getItem(), x, y);
                } else {
                    Tiles.drawTile(context, cell, x, y);
                }
            }
        }
        inventoryContext.setFill(Color.BLACK);
        inventoryContext.fillRect(0, 0, inventoryCanvas.getWidth(), inventoryCanvas.getHeight());
        for (int x = 0; x < gameInventory.getWidth(); x++) {
            for (int y = 0; y < gameInventory.getHeight(); y++) {
                Cell cell = gameInventory.getCell(x, y);
                if (cell.getItem() != null) {
                    Tiles.drawTile(inventoryContext, cell.getItem(), x, y);
                } else {
                    Tiles.drawTile(inventoryContext, cell, x, y);
                }
            }
        }

        healthLabel.setText("" + map.getPlayer().getHealth());
    }
}
