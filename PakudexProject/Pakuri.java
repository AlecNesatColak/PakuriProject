package Encoder.PakudexProject;

public class Pakuri {
    
    private String species = null;
    private int attack;
    private int level;
    private int defense;
    private int speed;
    private int hp;

    public Pakuri(String species) {
        this.species = species;
        this.attack = (species.length() * 7) + 9;
        this.defense = (species.length() * 5) + 17;
        this.speed = (species.length() * 6) + 13;
        this.level = 1;
        this.hp = 100;
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

    public int getLevel() {
        return level;
    }

    public void setLevel() {
        this.level+= 1;
    }

    public int getHp() {
        return hp;
    }

    public void setAttack(int newAttack) {
        this.attack = newAttack;
    }

    public void evolve() {
        if (level >= 25) {
            this.attack = 2*attack;
            this.defense = 4*defense;
            this.speed = 3*speed;
        }
    }


    
}
