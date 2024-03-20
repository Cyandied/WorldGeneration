package WorldParts.Biomes;

import Tiles.Alge;
import Tiles.OceanGravel;
import Tiles.Sand;
import Tiles.Water;
import Util.Biome;
import Util.Tile;

import java.util.Random;

public class Ocean extends Biome {

    public Ocean() {
        super(0,0,0,0);
        set_max(0.4f,1,1);
    }

    @Override
    public Tile get_tile() {
        Tile[] tiles = {new Sand(), new OceanGravel(), new Alge()};
        return tiles[new Random().nextInt(0,3)];
    }
}
