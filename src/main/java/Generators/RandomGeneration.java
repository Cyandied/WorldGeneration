package Generators;

import Tiles.Air;
import Tiles.Dirt;
import Tiles.Stone;
import Tiles.Water;
import Util.Tile;

import java.util.Random;

public class RandomGeneration {

    Random rand;
    public RandomGeneration(){
        rand = new Random();
    }
    public Tile make_tile(){
        int num = rand.nextInt(0,4);
        return switch (num) {
            case 1 -> new Stone();
            case 2 -> new Dirt();
            case 3 -> new Water();
            default -> new Air();
        };
    }

}
