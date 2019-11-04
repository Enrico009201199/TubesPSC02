/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LENOVO
 */
public class City {
    // Index kota dan koordinat x dan y
    int index;
    int x;
    int y;
    
    // Constructor
    public City(int index, int x, int y){
        this.index = index;
        this.x = x;
        this.y = y;
    }
    
    // Getter index kota
    public int getIndex() {
        return this.index;
    }
    
    // Getter koordinat x
    public int getX(){
        return this.x;
    }
    
    // Getter koordinat y
    public int getY(){
        return this.y;
    }
    
    // Menghitung jarak dengan kota lain
    public double distanceTo(City city){
        int xDistance = this.x - city.getX();
        int yDistance = this.y - city.getY();
        double distance = Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));        
        return distance;
    }
}
