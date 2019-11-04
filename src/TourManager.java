/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LENOVO
 */
import java.util.ArrayList;

public class TourManager {

    // Array kota
    private static ArrayList destinationCities = new ArrayList<City>();

    // Menambah kota ke array
    public static void addCity(City city) {
        destinationCities.add(city);
    }
    
    // Mengambil kota di index tertentu
    public static City getCity(int index){
        return (City)destinationCities.get(index);
    }
    
    // Mengambil jumlah kota di array
    public static int numberOfCities(){
        return destinationCities.size();
    }
}
