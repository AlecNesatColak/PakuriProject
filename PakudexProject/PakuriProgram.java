package Encoder.PakudexProject;

import java.util.Scanner;

public class PakuriProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
        System.out.print("Enter max capacity of the Pakudex: ");
        int maxCapacity = scanner.nextInt();
        System.out.println("The Pakudex can hold " + maxCapacity + " species of Pakuri.");
        System.out.println();
        Pakudex pakudex = new Pakudex(maxCapacity);
        boolean program = true;

        while(program) {
            System.out.println("Pakudex Main Menu");
            System.out.println("-----------------");
            System.out.println("1. List Pakuri");
            System.out.println("2. Show Pakuri");
            System.out.println("3. Add Pakuri");
            System.out.println("4. Evolve Pakuri");
            System.out.println("5. Sort Pakuri");
            System.out.println("6. Exit");
            System.out.println("7. Duel");
            System.out.println("");
            System.out.print("What would you like to do? ");
            int menuOption = scanner.nextInt();

            if(menuOption == 1) {
                String[] speciesList = pakudex.getSpeciesArray();
                if (speciesList == null) {
                    System.out.println("There are no Pakudex entries.");
                } else {
                    System.out.println("Pakuri species:");
                    for (String species : speciesList) {
                        if (species != null) {
                            System.out.println(species);
                        }
                    }
                    System.out.println();
                }
                
            } else if (menuOption == 2) {
                System.out.print("Enter the name of the species to display: ");
                String speciesName = scanner.next();
        
                // Get the statistics for the species
                int[] stats = pakudex.getStats(speciesName);
                System.out.println();
        
                if (stats == null) {
                    // If no stats are found, display an error message
                    System.out.println("Error: No such Pakuri in Pakudex!");
                    System.out.println();
                } else {
                    // If stats are found, display them
                    System.out.println("Attack: " + stats[0]);
                    System.out.println("Defense: " + stats[1]);
                    System.out.println("Speed: " + stats[2]);
                    System.out.println();
                }
            } else if (menuOption == 3) {
                System.out.print("Enter the name of the species to add: ");
                String speciesName = scanner.next();
                pakudex.addPakuri(speciesName);
                System.out.println();
            } else if (menuOption == 4) {
                System.out.print("Enter the name of the species to evolve: ");
                String evolvedSpecies = scanner.next();
                pakudex.evolveSpecies(evolvedSpecies);
                System.out.println();
            } else if (menuOption == 5) {
                pakudex.sortPakuri();
            } else if (menuOption == 6) {
                System.out.println("Thanks for using Pakudex! Bye!");
                program = false;
            } else if (menuOption == 7) {
                System.out.print("Choose first pakuri for battle: ");
                String species1 = scanner.next();
                System.out.print("Choose second pakuri for battle: ");
                String species2 = scanner.next();
                pakudex.duel(species1, species2);
            } 
        }
        scanner.close();
    }
}
