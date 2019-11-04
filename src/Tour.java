
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LENOVO
 */
public class Tour {
    
    // Array yang menyimpan urutan index kota yang akan dikunjungi
    private ArrayList tour = new ArrayList<City>();
    
    // Nilai fitness
    private double fitness = 0;
    
    // Total jarak dari tour
    private int distance = 0;
    
    // Constructor tour kosong
    public Tour(){
        for (int i = 0; i < TourManager.numberOfCities(); i++) {
            this.tour.add(null);
        }
    }

    // Membuat urutan tour
    public void generateTour() {
        // Memasukkan semua kota ke dalam tour
        for (int cityIndex = 0; cityIndex < TourManager.numberOfCities(); cityIndex++) {
            setCity(cityIndex, TourManager.getCity(cityIndex));
        }
        // Mengacak urutan tour
        Collections.shuffle(this.tour);
    }

    // Mengambil kota dari tour di posisi tertentu
    public City getCity(int tourPosition) {
        return (City)this.tour.get(tourPosition);
    }

    // Menempatkan suatu kota ke dalam tour di posisi tertentu
    public void setCity(int tourPosition, City city) {
        tour.set(tourPosition, city);
        // Me-reset nilai fitness dan jarak
        this.fitness = 0;
        this.distance = 0;
    }
    
    // Getter nilai fitness
    public double getFitness() {
        if (this.fitness == 0) {
            this.fitness = 1/(double)getDistance();
        }
        return this.fitness;
    }
    
    // Menghitung jarak total tour
    public int getDistance(){
        if (this.distance == 0) {
            int tourDistance = 0;
            for (int i = 0; i < tourSize(); i++) {
                City start = getCity(i);
                City target;
                if(i + 1 < this.tourSize()){
                    target = getCity(i + 1);
                }
                else{
                    target = getCity(0);
                }
                // Get the distance between the two cities
                tourDistance += start.distanceTo(target);
            }
            this.distance = tourDistance;
        }
        return this.distance;
    }

    // Mengambil jumlah kota dalam tour
    public int tourSize() {
        return tour.size();
    }
    
    // Memeriksa apakah suatu kota terdapat di dalam tour
    public boolean containsCity(City city){
        return tour.contains(city);
    }
    
    @Override
    public String toString() {
        String geneString = "| ";
        for (int i = 0; i < tourSize(); i++) {
            geneString += getCity(i).getIndex() + " | ";
        }
        return geneString;
    }
}
