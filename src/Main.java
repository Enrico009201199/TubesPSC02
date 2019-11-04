
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
        for (int i = 0; i < 101; i++) {
            index = sc.nextInt();
            x = sc.nextInt();
            y = sc.nextInt();
            City city = new City(index, x, y);
            TourManager.addCity(city);
        }
        int generation = sc.nextInt();
        Population pop = new Population(50, true);
        System.out.println("Initial distance: " + pop.getFittest().getDistance());
         pop = Algorithm.evolvePopulation(pop);
        for (int i = 0; i < generation; i++) {
            pop = Algorithm.evolvePopulation(pop);
        }
        System.out.println("Finished");
        System.out.println("Final distance: " + pop.getFittest().getDistance());
        System.out.println("Solution:");
        System.out.println(pop.getFittest());
    }
}