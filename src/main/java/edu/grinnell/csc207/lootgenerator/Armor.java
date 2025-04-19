package edu.grinnell.csc207.lootgenerator;

import java.util.Random;

/**
 *
 * @author Tiffany tang
 */
public class Armor {

    private String name;
    private int min;
    private int max;

    public Armor(String name, Pair p) {
        this.name = name;
        this.min = p.getMin();
        this.max = p.getMax();

    }

    public int baseStats() {
        Random r = new Random();
        return r.nextInt(max + 1) + min;
    }

}
