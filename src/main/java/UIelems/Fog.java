package UIelems;

import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Fog extends Pane implements MapElements {

    public Fog(int x, int y){
        this.relocate(tile_margin,tile_margin);
        this.resize(tile_size*x + (x-1)*tile_margin,tile_size*y + (y-1)*tile_margin);
        this.setBackground(Background.fill(new Color(0.7, 0.9, 1,0.1)));
    }

}
