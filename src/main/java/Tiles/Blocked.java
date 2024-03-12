package Tiles;

import Util.Tile;

public class Blocked extends Tile {

    public Blocked(){
        set_color(0,0,0);
    }

    @Override
    public String toString(){
        return "B";
    }

}
