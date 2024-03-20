package WorldParts.Biomes;

import Tiles.Sand;
import Util.Biome;
import Util.Tile;

public class Desert extends Biome {
    public Desert() {
        super(0.2F,0,0.5F,1);
    }

    @Override
    public Tile get_tile() {
        return new Sand();
    }
}
