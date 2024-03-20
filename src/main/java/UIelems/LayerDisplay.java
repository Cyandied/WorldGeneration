package UIelems;

import Map.Layer;
import Map.World;
import Tiles.Air;
import Tiles.Blocked;
import Tiles.Shaded;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;

import java.util.Arrays;

public class LayerDisplay{

    World world;
    int x,y;
    StackPane display_stack;
    LayerPanes layer_panes;

    public LayerDisplay(World world, int x, int y){
        this.world = world;
        this.x = x;
        this.y = y;
        display_stack = new StackPane();
        layer_panes = new LayerPanes(world);
    }

    public StackPane get_stack(){
        return display_stack;
    }

    public void draw_layered_display(){
        display_stack.getChildren().remove(0,display_stack.getChildren().size());
        for(int i = 0; i < world.get_current_depth(); i++){
            set_fog_layer(layer_panes.get_layer(i));
        }
        MapDisplay layer_0 = layer_panes.get_layer(world.get_current_depth());
        set_layer(layer_0);
        set_layer(new MapDisplay(x,y),create_shadow_layer());

        display_stack.resize(layer_0.getWidth(),layer_0.getHeight());
        display_stack.setBackground(Background.fill(Paint.valueOf("white")));
    }
    Layer create_shadow_layer(){
        Layer layer_1 = world.get_above();
        if(layer_1 == null) {
            return null;
        }
        Layer shadow_layer = new Layer(x,y);
        for(int loop_x = 0; loop_x < x; loop_x++){
            for(int loop_y = 0; loop_y < y; loop_y++){
                if(layer_1.get_tile(loop_x,loop_y).get_type() != 0 && layer_1.get_tile(loop_x,loop_y).get_type() != 3){
                    int[] neighbours = layer_1.neighbour_types(loop_x,loop_y);
                    if(Arrays.stream(neighbours).anyMatch(num -> num == 0 || num == 3)){
                        shadow_layer.set_tile(new Shaded(),loop_x,loop_y);
                    }
                    else {
                        shadow_layer.set_tile(new Blocked(),loop_x,loop_y);
                    }
                }
                else {
                    shadow_layer.set_tile(new Air(),loop_x,loop_y);
                }
            }
        }
        return shadow_layer;
    }

    void set_fog_layer(MapDisplay map){
        if(map != null) {
            display_stack.getChildren().add(map);
            display_stack.getChildren().add(new Fog(x, y));
        }
    }

    void set_layer(MapDisplay map){
        if(map != null){
            display_stack.getChildren().add(map);
        }
    }

    void set_layer(MapDisplay map, Layer layer){
        if(layer != null){
            map.draw(layer);
            display_stack.getChildren().add(map);
        }
    }


}
