package WorldParts.Biomes;

import Tiles.*;
import Util.Tile;

public abstract class Biome {

    public double min_height;
    public double min_moisture;
    public double min_heat;

    public Biome(double min_height, double min_moisture,double min_heat){
        this.min_height = min_height;
        this.min_moisture = min_moisture;
        this.min_heat = min_heat;
    }

    public abstract Tile get_tile();

    public boolean match_condition(int height, double moisture, double heat){
        return height >= min_height && moisture >= min_moisture && heat >= min_heat;
    }

}
