package UIelems;

import Map.Layer;
import Util.Tile;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class MapDisplay extends Pane implements MapElements {

    Rectangle[][] map;
    int max_x, max_y;

    public MapDisplay(int x, int y){
        max_x = x;
        max_y = y;
        map = new Rectangle[x][y];
        this.resize(tile_size*x + (x+1)*tile_margin,tile_size*x + (x+1)*tile_margin);
        for(int row = 0;row<x;row++){
            for(int col = 0;col<x;col++){
                Rectangle tile = new Rectangle();
                tile.setHeight(tile_size);
                tile.setWidth(tile_size);
                tile.setX((row + 1) * tile_margin + tile_size * row);
                tile.setY((col + 1) * tile_margin + tile_size * col);
                this.getChildren().add(tile);
                map[row][col] = tile;
            }
        }
    }

    public void draw(Layer tile_map){
        int row = 0;
        for(Rectangle[] rect_row : map){
            int col = 0;
            for(Rectangle tile : rect_row){
                tile.setFill(tile_map.get_tile(row,col).get_color());
                col++;
            }
            row++;
        }
    }

}
