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
import java.util.Date;

public class LayerDisplay{

    World world;
    int x,y;
    StackPane display_stack;
    int layers_below = 4;

    public LayerDisplay(World world,int x, int y){
        this.world = world;
        this.x = x;
        this.y = y;
        display_stack = new StackPane();
    }

    public StackPane get_stack(){
        return display_stack;
    }

    public void draw_layered_display(){
        display_stack.getChildren().remove(0,display_stack.getChildren().size());
        MapDisplay[] below_maps = new MapDisplay[layers_below];
        Layer[] below_layers = new Layer[layers_below];

        for(int i = 1; i <= layers_below; i++){
            below_maps[i-1] = new MapDisplay(x,y);
            below_layers[i-1] = world.get_below(i);
        }

        MapDisplay map_layer_0 = new MapDisplay(x,y);
        MapDisplay map_layer_1 = new MapDisplay(x,y);

        Layer layer_0 = world.get_current_layer();
        Layer layer_1 = create_shadow_layer();

        for(int i = layers_below - 1; i >= 0; i--){
            set_fog_layer(below_maps[i],below_layers[i]);
        }

        set_layer(map_layer_0,layer_0);
        set_layer(map_layer_1,layer_1);

        display_stack.resize(map_layer_0.getWidth(),map_layer_0.getHeight());
        display_stack.setBackground(Background.fill(Paint.valueOf("white")));
    }
    Layer create_shadow_layer(){
        Layer layer_1 = world.get_above();
        if(layer_1 == null) {
            return null;
        }
        Layer shadow_layer = new Layer(x,y);
        for(int row = 0; row < x; row++){
            for(int col = 0; col < y; col++){
                if(layer_1.get_tile(row,col).get_type() != 0 && layer_1.get_tile(row,col).get_type() != 3){
                    int[] neighbours = layer_1.neighbour_types(row,col);
                    if(Arrays.stream(neighbours).anyMatch(num -> num == 0 || num == 3)){
                        shadow_layer.set_tile(new Shaded(),row,col);
                    }
                    else {
                        shadow_layer.set_tile(new Blocked(),row,col);
                    }
                }
                else {
                    shadow_layer.set_tile(new Air(),row,col);
                }
            }
        }
        return shadow_layer;
    }

    void set_fog_layer(MapDisplay map, Layer layer){
        if(layer != null){
            map.draw(layer);
            display_stack.getChildren().add(map);
            display_stack.getChildren().add(new Fog(x,y));
        }
    }

    void set_layer(MapDisplay map, Layer layer){
        if(layer != null){
            map.draw(layer);
            display_stack.getChildren().add(map);
        }
    }


}
