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
                pakudex[i].evolve();
                System.out.println(species + " has evolved!");
                System.out.println();
                return true;
            }
        }
        System.out.println("Error: No such Pakuri!");
        return false;
    }

}
