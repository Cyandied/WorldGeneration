package Generators;

import Tiles.*;
import Util.Tile;

import java.util.Random;

public class RandomHeightControlled{

    Random rand;
    public RandomHeightControlled(){
        rand = new Random();
    }
    public Tile make_tile(int height){
        int num = rand.nextInt(0,5);

        return switch (num) {
            case 1 -> new Stone();
            case 2 -> new Dirt();
            case 3 -> new Water();
            case 4 -> new Sand();
            default -> new Air();
        };
    }

}
