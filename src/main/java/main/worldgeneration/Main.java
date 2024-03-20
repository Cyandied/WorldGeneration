package main.worldgeneration;

import Map.World;
import Map.WorldOld;
import UIelems.LayerDisplay;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    int width = 0;
    int height = 0;
    @Override
    public void start(Stage primary_stage) throws IOException {
        primary_stage.setTitle("WorldGeneration");
        width = 250;
        height = 100;
        primary_stage.setScene(make_scene(primary_stage));
        primary_stage.show();
    }

    Scene make_scene(Stage stage){
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
            else if(e.getCode() == KeyCode.R){
                stage.close();
                stage.setScene(make_scene(stage));
                stage.show();
            }
            layers.draw_layered_display();
        });
        return scene;
    }

    public static void main(String[] args) {
        launch();
    }
}