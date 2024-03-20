package UIelems;

import Map.World;
import Map.WorldOld;

public class LayerPanes implements MapElements {

    World world;
    MapDisplay[] map_panes;

    public LayerPanes(World world){
        this.world = world;
        map_panes = new MapDisplay[world.get_size_z()];
        generate_map();
    }

    void generate_map(){
        for(int i = 0; i < world.get_size_z(); i++){
            map_panes[i] = new MapDisplay(world.get_size_x(),world.get_size_y());
            map_panes[i].draw(world.get_layer(i));
        }
    }

    public MapDisplay get_layer(int layer){
        if(layer >= 0 && layer < world.get_size_z()){
            return map_panes[layer];
        }
        return null;
    }

}
