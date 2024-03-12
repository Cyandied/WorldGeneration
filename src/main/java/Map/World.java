package Map;

import Generators.GenerationWithNoise;
import Generators.RandomHeightControlled;
import Util.Tile;

public class World {

    Layer current_layer;
    Layer[] world_map;
    int current_depth;

    GenerationWithNoise generator;

    int size_x, size_y,size_z;
    public World(int size_x, int size_y, int size_z){
        world_map = new Layer[size_z];
        this.size_x = size_x;
        this.size_y = size_y;
        this.size_z = size_z;
        generator = new GenerationWithNoise(size_x,size_y,size_z);
        populate_world();
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

    public void populate_world(){
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

    public Layer get_current_layer(){
        return current_layer;
    }

    public Layer get_above(){
        if(current_depth+1 < size_z){
            return world_map[current_depth+1];
        }
        return null;
    }
    public Layer get_above(int x){
        if(current_depth+x < size_z){
            return world_map[current_depth+x];
        }
        return null;
    }

    public Layer get_below(){
        if(current_depth-1 >= 0){
            return world_map[current_depth-1];
        }
        return null;
    }
    public Layer get_below(int x){
        if(current_depth-x >= 0){
            return world_map[current_depth-x];
        }
        return null;
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
