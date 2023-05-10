package Encoder.PakudexProject;
import java.util.Arrays;
import java.util.Comparator;

public class Pakudex {
    private Pakuri[] pakudex;

    public Pakudex() {
        pakudex = new Pakuri[20];
        
    }

    public Pakudex(int capacity) {
        pakudex = new Pakuri[capacity];
        
    }

    public int getSize() {
        int size = 0;
        for (int i = 0; i < pakudex.length; i++) {
            if (pakudex[i] != null) {
                size++;
            }
        }

        return size;
    }

    public int getCapacity() {
        return pakudex.length;
        
    }

    public String[] getSpeciesArray() {
        if (pakudex == null) {
            return null;
        }
        String[] speciesList = new String[pakudex.length];
        for (int i = 0; i < pakudex.length; i++) {
            if (pakudex[i] != null) {
                speciesList[i] = pakudex[i].getSpecies();
            }
        }
        return speciesList;
    }
    

     public int[] getStats(String species) {
        int[] stats = {0,0,0};

        for (int i = 0; i < pakudex.length; i++) {
            if (pakudex[i] != null && pakudex[i].getSpecies().equals(species)){
                stats[0] = pakudex[i].getAttack();
                stats[1] = pakudex[i].getDefense();
                stats[2] = pakudex[i].getSpeed();
                return stats;
            }
        }
        System.out.println("Error: No such Pakuri!");
        return null;
    }

    public void sortPakuri() {
        Arrays.sort(pakudex, 0, getSize(), new Comparator<Pakuri>() {
                public int compare(Pakuri p1, Pakuri p2) {
                return p1.getSpecies().compareToIgnoreCase(p2.getSpecies());
            }
        });
        System.out.println("Pakuri have been sorted!");
    }

    public boolean addPakuri(String species) {
        if (species == null || species.isEmpty()) {
            System.out.println("No species was entered, please enter a species.");
            return false;
        }
        for (Pakuri pakuri : pakudex) {
            if (pakuri != null && pakuri.getSpecies().equals(species)) {
                System.out.println("Error: Pakudex already contains this species!");
                return false;
            }
        }

        for (int i = 0; i < pakudex.length;i++) {
            if(pakudex[i] == null) {
                pakudex[i] = new Pakuri(species);
                System.out.println("Pakuri species " + species + " successfully added!");
                System.out.println();
                return true;
            }
        }
        System.out.println("Error: Pakudex is full!");
        return false;
    }
    
    public boolean evolveSpecies(String species) {
        for (int i = 0; i < pakudex.length; i++) {
            if (pakudex[i].getSpecies().equals(species)) {
                if(pakudex[i].getLevel() >= 25) {
                    pakudex[i].evolve();
                    System.out.println(species + " has evolved!");
                    System.out.println();
                    return true;
                } else {
                    System.out.println("Pakuri is unable to evolve, it must reach level 25 or greater.");
                    System.out.println(pakudex[i].getSpecies() + "'s level is currently " + pakudex[i].getLevel());
                    System.out.println();
                    return false;
                }  
            }
        }
        System.out.println("Error: No such Pakuri!");
        return false;
    }

    public void duel(String speciesName1, String speciesName2) {
        Pakuri pakuri1 = null;
        Pakuri pakuri2 = null;
    
        // find the Pakuri objects with the given species names
        for (int i = 0; i < pakudex.length; i++) {
            if (pakudex[i] != null && pakudex[i].getSpecies().equals(speciesName1)) {
                pakuri1 = pakudex[i];
            }
            if (pakudex[i] != null && pakudex[i].getSpecies().equals(speciesName2)) {
                pakuri2 = pakudex[i];
            }
        }
    
        // check if both Pakuri objects were found
        if (pakuri1 == null || pakuri2 == null) {
            System.out.println("Error: Could not find Pakuri with given species names.");
            return;
        }
    
        System.out.println("DUEL STARTED!");
        System.out.println(pakuri1.getSpecies() + " vs " + pakuri2.getSpecies());
        System.out.println();
    
        int hp1 = 100;
        int hp2 = 100;
    
        // loop until one Pakuri's HP reaches 0 or below
        while (hp1 > 0 && hp2 > 0) {
            // Pakuri 1 attacks Pakuri 2
            int damage1 = pakuri1.getAttack();
            int defense2 = pakuri2.getDefense();
            int damageDealt1 = damage1 - defense2;
            hp2 -= damageDealt1;
            if (damageDealt1 < 0) {
                damageDealt1 = 0;
            }
            if (hp2 <= 0) {
                System.out.println(pakuri2.getSpecies() + " fainted.");
                System.out.println();
                pakuri1.setLevel();
                break;
            }
    
            // Pakuri 2 attacks Pakuri 1
            int damage2 = pakuri2.getAttack();
            int defense1 = pakuri1.getDefense();
            int damageDealt2 = damage2 - defense1;
            hp1 -= damageDealt2;
            if (damageDealt2 < 0) {
                damageDealt2 = 0;
            }
            if (hp1 <= 0) {
                System.out.println(pakuri1.getSpecies() + " fainted.");
                System.out.println();
                pakuri2.setLevel();
                break;
            }
        }
        System.out.println("DUEL FINISHED!");
        System.out.println();
    }
    
}
