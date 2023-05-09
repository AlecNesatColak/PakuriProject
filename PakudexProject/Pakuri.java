package Encoder.PakudexProject;

public class Pakuri {
    
    private String species = null;
    private int attack;
    private int defense;
    private int speed;

    public Pakuri(String species) {
        this.species = species;
        this.attack = (species.length() * 7) + 9;
        this.defense = (species.length() * 5) + 17;
        this.speed = (species.length() * 6) + 13;
    }

    public String getSpecies() {
        return species;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setAttack(int newAttack) {
        this.attack = newAttack;
    }

    public void evolve() {
        this.attack = 2*attack;
        this.defense = 4*defense;
        this.speed = 3*speed;
    }


    
}
