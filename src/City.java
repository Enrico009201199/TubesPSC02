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
    int index;
    int x;
    int y;
    
    // Constructs a city at chosen x, y location
    public City(int index, int x, int y){
        this.index = index;
        this.x = x;
        this.y = y;
    }
    
    // Gets city's x coordinate
    public int getX(){
        return this.x;
    }
    
    // Gets city's y coordinate
    public int getY(){
        return this.y;
    }
    
    // Gets the distance to given city
    public double distanceTo(City city){
        int xDistance = this.x - city.getX();
        int yDistance = this.y - city.getY();
        double distance = Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));        
        return distance;
    }
    
    @Override
    public String toString(){
        return this.index + "";
    }
}
