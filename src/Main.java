
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LENOVO
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int index, x, y;
        // Menerima 101 baris input sesuai dari eil101
        for (int i = 0; i < 101; i++) {
            index = sc.nextInt();
            x = sc.nextInt();
            y = sc.nextInt();
            City city = new City(index, x, y);
            TourManager.addCity(city);
        }
        // Masukan tambahan berupa jumlah generasi/iterasi
        int generation = sc.nextInt();
        Population pop = new Population(generation);
        // Jarak awal dari tour acak yang diciptakan pertama
        System.out.println("Initial distance: " + pop.getFittest().getDistance());
        // Populasi akan berevolusi sebanyak jumlah generasi
        for (int i = 0; i < generation; i++) {
            pop = Algorithm.evolvePopulation(pop);
        }
        System.out.println("Finished");
        // Jarak paling pendek yang ditemukan setelah berevolusi berkali-kali
        System.out.println("Final distance: " + pop.getFittest().getDistance());
        // Urutan kota yang menghasilkan total jarak tersebut
        System.out.println("Solution:");
        System.out.println(pop.getFittest());
    }
}