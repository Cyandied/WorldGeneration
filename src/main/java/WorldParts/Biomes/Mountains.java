package WorldParts.Biomes;

import Tiles.Stone;
import Util.Biome;
import Util.Tile;

public class Mountains extends Biome {
    public Mountains() {
        super(0.5F,0,0,2);
    }

    @Override
    public Tile get_tile() {
        return new Stone();
    }
}
