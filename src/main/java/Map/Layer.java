package Map;

import Util.Tile;

import java.util.Arrays;

public class Layer {

    private final Tile[][] layer;
    int size_x, size_y;
    public Layer(int size_x, int size_y){
        this.size_x = size_x;
        this.size_y = size_y;
        layer = new Tile[size_x][size_y];
    }

    public void set_tile(Tile tile, int x,int y){
        if(x >= 0 && x < size_x && y >= 0 && y < size_y){
            layer[x][y] = tile;
        }
    }

    public Tile get_tile(int x, int y){
        if(x >= 0 && x < size_x && y >= 0 && y < size_y){
            return layer[x][y];
        }
        return null;
    }

    public int[] neighbour_types(int x, int y){
        int[] neighbours = new int[4];
        neighbours[0] = x+1 < size_x ? layer[x+1][y].get_type() : -1;
        neighbours[1] = x-1 > 0 ? layer[x-1][y].get_type() : -1;
        neighbours[2] = y+1 < size_x ? layer[x][y+1].get_type() : -1;
        neighbours[3] = y-1 > 0 ? layer[x][y-1].get_type() : -1;
        return neighbours;
    }

    public String toString(){
        String string = "";
        for(Tile[] row : layer){
            string += Arrays.toString(row);
            string += "\n";
        }
        return string;
    }


}
