/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LENOVO
 */
public class Algorithm {
    // Parameter Genetic Algorithm
    private static final double mutationRate = 0.015;
    private static final int tournamentSize = 5;
    private static final boolean elitism = true;

    // Mengevolusikan populasi untuk 1 generasi
    public static Population evolvePopulation(Population pop) {
        Population newPopulation = new Population(pop.populationSize());
        // Jika elitism bernilai true, maka tour terakhirsebelumnya dianggap yang terbaik
        int elitismOffset = 0;
        if (elitism) {
            newPopulation.saveTour(0, pop.getFittest());
            elitismOffset = 1;
        }
        // Crossover
        for (int i = elitismOffset; i < newPopulation.populationSize(); i++) {
            Tour parent1 = tournamentSelection(pop);
            Tour parent2 = tournamentSelection(pop);
            Tour child = crossover(parent1, parent2);
            // Memasukkan child ke populasi baru
            newPopulation.saveTour(i, child);
        }
        // Mutation
        for (int i = elitismOffset; i < newPopulation.populationSize(); i++) {
            mutate(newPopulation.getTour(i));
        }
        return newPopulation;
    }

    // Method crossover
    public static Tour crossover(Tour parent1, Tour parent2) {
        // Tour baru hasil crossover
        Tour child = new Tour();
        // Mengambil posisi awal dan akhir untuk memotong tour parent1
        int startPos = (int) (Math.random() * parent1.tourSize());
        int endPos = (int) (Math.random() * parent1.tourSize());
        // Memasukkan potongan tour dari parent1 ke child
        for (int i = 0; i < child.tourSize(); i++) {
            // Jika start lebih kecil dari end
            if (startPos < endPos && i > startPos && i < endPos) {
                child.setCity(i, parent1.getCity(i));
            } // Jika start lebih besar dari end
            else if (startPos > endPos) {
                if (!(i < startPos && i > endPos)) {
                    child.setCity(i, parent1.getCity(i));
                }
            }
        }
        // Memasukkan sisa kota di parent2 yang belum termasuk ke child
        for (int i = 0; i < parent2.tourSize(); i++) {
            if (!child.containsCity(parent2.getCity(i))) {
                // Mencari posisi yang masih kosong untuk memasukkan kota
                for (int j = 0; j < child.tourSize(); j++) {
                    if (child.getCity(j) == null) {
                        child.setCity(j, parent2.getCity(i));
                        break;
                    }
                }
            }
        }
        return child;
    }

    // Method mutation
    private static void mutate(Tour tour) {
        for(int i = 0; i < tour.tourSize(); i++){
            // Mengaplikasikan mutation rate
            if(Math.random() < mutationRate){
                // Mengambil angka acak sebagai index kota kedua
                int j = (int) (tour.tourSize() * Math.random());
                City city1 = tour.getCity(i);
                City city2 = tour.getCity(j);
                // Menukar posisi kota ke-i dengan kota ke-j
                tour.setCity(j, city1);
                tour.setCity(i, city2);
            }
        }
    }

    // Memilih kandidat untuk crossover
    private static Tour tournamentSelection(Population pop) {
        // Membuat populasi turnamen
        Population tournament = new Population(tournamentSize);
        // Memasukkan tour acak ke populasi turnamen
        for (int i = 0; i < tournamentSize; i++) {
            int randomId = (int) (Math.random() * pop.populationSize());
            tournament.saveTour(i, pop.getTour(randomId));
        }
        // Mengambil tour dengan nilai fitness terbaik
        Tour fittest = tournament.getFittest();
        return fittest;
    }
}