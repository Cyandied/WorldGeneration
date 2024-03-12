package Util;

import Tiles.*;
import Util.Tile;

public abstract class Biome {

    public float min_height;
    public float min_moisture;
    public float min_heat;
    public float max_height = 1;
    public float max_moisture = 1;
    public float max_heat = 1;

    public Biome(float min_height, float min_moisture,float min_heat){
        this.min_height = min_height;
        this.min_moisture = min_moisture;
        this.min_heat = min_heat;
    }

    public void set_max(float max_height,float max_moisture,float max_heat){
        this.max_height = max_height;
        this.max_moisture = max_moisture;
        this.max_heat = max_heat;
    }

    public abstract Tile get_tile();

    boolean match_min_condition(float height, float moisture, float heat){
        return height >= min_height && moisture >= min_moisture && heat >= min_heat;
    }

    boolean match_max_condition(float height, float moisture, float heat){
        return height <= max_height && moisture <= max_moisture && heat <= max_heat;
    }

    public boolean match_condition(float height, float moisture, float heat){
        return match_min_condition(height,moisture,heat) && match_max_condition(height,moisture,heat);
    }

    public float get_diff_value(float height, float moisture, float heat) {
        return (height - min_height) + (moisture - min_moisture) + (heat - min_heat);
    }

}
