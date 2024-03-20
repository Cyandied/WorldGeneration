package Generators;

import Generators.Noise.PerlinNoise;
import Tiles.Air;
import Tiles.Stone;
import Util.Biome;
import Util.Tile;
import WorldParts.Biomes.Desert;
import WorldParts.Biomes.Grassland;
import WorldParts.Biomes.Mountains;
import WorldParts.Biomes.Ocean;

import java.util.ArrayList;
import java.util.Random;

public class GenerationWithNoise {

    int x,y,z;
    int ocean_level;

    Biome[] biomes = {new Desert(), new Grassland(),new Mountains(), new Ocean()};

    float[][] height_map;
    float[][] moisture_map;
    float[][] heat_map;

    Random rand = new Random();

    public GenerationWithNoise(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
        height_map = PerlinNoise.generatePerlinNoise(x,y,8, 0.5F,rand.nextLong());
        moisture_map = PerlinNoise.generatePerlinNoise(x,y,5, 0.2F,rand.nextLong());
        heat_map = PerlinNoise.generatePerlinNoise(x,y,5, 0.7F,rand.nextLong());
    }

    public Tile get_tile(int x, int y, int z) {
        float height = height_map[x][y];
        float moisture = moisture_map[x][y];
        float heat = heat_map[x][y];
        if(z > (int) (height * this.z)){
            return new Air();
        }
        else if(z < 5){
            return new Stone();
        }
        return get_biome(height,moisture,heat).get_tile();
    }

    Biome get_biome(float height, float moisture, float heat){
        ArrayList<Biome> accepted_biomes = new ArrayList<Biome>();

        for(Biome biome : biomes){
            if(biome.match_condition(height,moisture,heat)){
                accepted_biomes.add(biome);
            }
        }

        Biome best_match = null;
        float best_val = Float.MAX_VALUE;
        for(Biome biome : accepted_biomes){
            if(biome.get_diff_value(height,moisture,heat) < best_val){
                best_match = biome;
                best_val = biome.get_diff_value(height,moisture,heat);
            }
        }
        if(best_match == null) {
            return biomes[0];
        }
        return best_match;

    }

}
