package Map;

import Generators.GenerationWithNoise;
import Generators.TwoStageGenerationWithNoise;
import Tiles.Water;
import Util.Tile;

public class World {

    Layer current_layer;
    Layer[] world_map;
    int current_depth;

    TwoStageGenerationWithNoise generator;

    int size_x, size_y,size_z;
    public World(int size_x, int size_y, int size_z){
        world_map = new Layer[size_z];
        this.size_x = size_x;
        this.size_y = size_y;
        this.size_z = size_z;
        generator = new TwoStageGenerationWithNoise(size_x,size_y,size_z);
        create_land();
        create_water(13);
    }

    public Tile get_tile(int x, int y, int z){
        if(x < 0 || y < 0 || z < 0 || x >= size_x || y >= size_y || z >= size_z){
            return null;
        }
        else return world_map[z].get_tile(x,y);
    }

    public Tile get_tile(int x, int y){
        if(x < 0 || y < 0 || x >= size_x || y >= size_y){
            return null;
        }
        else return current_layer.get_tile(x,y);
    }

    public void create_land(){
        for(int z = 0; z <size_z;z++){
            world_map[z] = new Layer(size_x,size_y);
            for(int x = 0; x<size_x;x++){
                for(int y = 0; y<size_y;y++){
                    world_map[z].set_tile(generator.get_tile(x,y,z),x,y);
                }
            }
        }
        current_depth = 3*size_z/4;
        current_layer = world_map[current_depth];
    }

    public void create_water(int water_level){
        for(int z = 0; z < water_level; z++){
            Layer layer = world_map[z];
            for(int x = 0; x<size_x; x++){
                for(int y = 0; y<size_y;y++){
                    if(layer.get_tile(x,y).get_type() == 0){
                        layer.set_tile(new Water(),x,y);
                    }
                }
            }
        }
    }

    public void populate_world(){

    }

    public int get_current_depth(){
        return current_depth;
    }

    public Layer get_current_layer(){
        return current_layer;
    }
    public Layer get_layer(int layer){
        if(layer >= 0 && layer < size_z){
            return world_map[layer];
        }
        return null;
    }

    public Layer get_above(){
        if(current_depth+1 < size_z){
            return world_map[current_depth+1];
        }
        return null;
    }
    public int get_size_x(){
        return size_x;
    }
    public int get_size_y(){
        return size_y;
    }
    public int get_size_z(){
        return size_z;
    }

    public void go_up(){
        if(current_depth+1 < size_z){
            current_depth++;
            current_layer = world_map[current_depth];
        }
        System.out.println("Layer " + (current_depth+1) + "/" + size_z);
    }
    public void go_down(){
        if(current_depth-1 >= 0 ){
            current_depth--;
            current_layer = world_map[current_depth];
        }
        System.out.println("Layer " + (current_depth+1) + "/" + size_z);
    }

}
