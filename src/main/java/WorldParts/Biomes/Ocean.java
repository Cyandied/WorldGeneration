package WorldParts.Biomes;

import Tiles.Water;
import Util.Biome;
import Util.Tile;

public class Ocean extends Biome {

    public Ocean() {
        super(0,0,0);
    }

    @Override
    public Tile get_tile() {
        return new Water();
    }
}
