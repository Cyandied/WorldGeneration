package Tiles;

import Util.Tile;

public class Shaded extends Tile {
    public Shaded(){
        set_color(0,0,0);
        set_alpha(0.4);
    }

    @Override
    public String toString(){
        return "S";
    }
}
