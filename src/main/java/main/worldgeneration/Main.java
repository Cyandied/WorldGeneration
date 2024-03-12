package main.worldgeneration;

import Map.World;
import UIelems.LayerDisplay;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primary_stage) throws IOException {
        primary_stage.setTitle("WorldGeneration");
        int size = 75;
        World world = new World(size,size,30);
        LayerDisplay layers = new LayerDisplay(world,size,size);
        layers.draw_layered_display();
        StackPane display = layers.get_stack();
        Scene scene = new Scene(display,display.getWidth(),display.getHeight());
        scene.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.UP){
                world.go_up();
            }
            else if(e.getCode() == KeyCode.DOWN){
                world.go_down();
            }
            layers.draw_layered_display();
        });
        primary_stage.setScene(scene);
        primary_stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}