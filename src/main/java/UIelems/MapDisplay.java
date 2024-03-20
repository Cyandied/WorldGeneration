package UIelems;

import Map.Layer;
import Util.Tile;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class MapDisplay extends Pane implements MapElements {

    Rectangle[][] map;
    int max_x, max_y;

    public MapDisplay(int max_x, int max_y){
        this.max_x = max_x;
        this.max_y = max_y;
        map = new Rectangle[max_x][max_y];
        this.resize(tile_size*max_x + (max_x+1)*tile_margin,tile_size*max_y + (max_y+1)*tile_margin);
        for(int x = 0;x<max_x;x++){
            for(int y = 0;y<max_y;y++){
                Rectangle tile = new Rectangle();
                tile.setHeight(tile_size);
                tile.setWidth(tile_size);
                tile.setX((x + 1) * tile_margin + tile_size * x);
                tile.setY((y + 1) * tile_margin + tile_size * y);
                this.getChildren().add(tile);
                map[x][y] = tile;
            }
        }
    }

    public void draw(Layer tile_map){
        if(tile_map == null){
            return;
        }
        int x = 0;
        for(Rectangle[] rect_row : map){
            int y = 0;
            for(Rectangle tile : rect_row){
                Tile tile_from_layer = tile_map.get_tile(x,y);
                if(tile_from_layer != null){
                    tile.setFill(tile_from_layer.get_color());
                }
                y++;
            }
            x++;
        }
    }

}
