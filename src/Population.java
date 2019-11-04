/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LENOVO
 */
public class Population {
    // Array berisi permutasi urutan kota (tour)
    Tour[] tours;

    // Constructor
    public Population(int populationSize) {
        this.tours = new Tour[populationSize];
        for (int i = 0; i < populationSize; i++) {
            Tour newTour = new Tour();
            newTour.generateTour();
            this.tours[i] = newTour;
        }
    }
    
    // Menyimpan tour
    public void saveTour(int index, Tour tour) {
        this.tours[index] = tour;
    }
    
    // Mengambil tour pada index tertentu
    public Tour getTour(int index) {
        return this.tours[index];
    }

    // Mengambil tour terbaik dari populasi
    public Tour getFittest() {
        Tour fittest = this.tours[0];
        for (int i = 1; i < populationSize(); i++) {
            if (fittest.getFitness() <= this.getTour(i).getFitness()) {
                fittest = this.getTour(i);
            }
        }
        return fittest;
    }

    // Mengambil ukuran populasi
    public int populationSize() {
        return this.tours.length;
    }
}
