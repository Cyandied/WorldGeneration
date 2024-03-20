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
        int width = 250;
        int height = 100;
        World world = new World(width,height,30);
        LayerDisplay layers = new LayerDisplay(world,width,height);
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