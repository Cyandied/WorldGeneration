package Util;

import javafx.scene.paint.Color;

import java.util.Random;

public abstract class Tile {

    int type;

    int r;
    int g;
    int b;

    double tolerate_r_variance = 0;
    double tolerate_g_variance = 0;
    double tolerate_b_variance = 0;

    double a = 1;

    public void set_variance(double tolerate_r_variance, double tolerate_g_variance, double tolerate_b_variance){
        this.tolerate_r_variance = tolerate_r_variance;
        this.tolerate_g_variance = tolerate_g_variance;
        this.tolerate_b_variance = tolerate_b_variance;
    }

    public void set_color(int r, int g, int b){
        Random rand = new Random();
        if(tolerate_r_variance > 0){
            this.r = (int) (r * rand.nextDouble(1-tolerate_r_variance,1+tolerate_r_variance));
        }
        else {
            this.r = r;
        }
        if(this.r > 255){
            this.r = 255;
        }
        else if (this.r < 0){
            this.r = 0;
        }
        if(tolerate_g_variance > 0){
            this.g = (int) (g * rand.nextDouble(1-tolerate_g_variance,1+tolerate_g_variance));
        }
        else {
            this.g = g;
        }
        if(this.g > 255){
            this.g = 255;
        }
        else if (this.g < 0){
            this.g = 0;
        }
        if(tolerate_b_variance > 0){
            this.b = (int) (b * rand.nextDouble(1-tolerate_b_variance,1+tolerate_b_variance));
        }
        else {
            this.b = b;
        }
        if(this.b > 255){
            this.b = 255;
        }
        else if (this.b < 0){
            this.b = 0;
        }
    }

    public void set_alpha(double a){
        this.a = a;
    }

    public void set_type(int type){
        this.type = type;
    }

    public Color get_color(){
        return new Color((double) r /255, (double) g /255, (double) b /255,a);
    }

    public int get_type(){
        return type;
    }

    public String toString(){
        return String.valueOf(type);
    }

}
