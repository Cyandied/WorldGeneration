package WorldParts.Biomes;

import Tiles.Dirt;
import Tiles.Grass;
import Util.Biome;
import Util.Tile;

public class Grassland extends Biome {
    public Grassland() {
        super(0.2F, 0.5F,0.3F,3);
    }

    @Override
    public Tile get_tile() {
        return new Dirt();
    }

    public Tile get_special(){
        return new Grass();
    }
}
