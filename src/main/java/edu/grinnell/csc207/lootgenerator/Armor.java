package edu.grinnell.csc207.lootgenerator;

import java.util.Random;

/**
 * A single armor.
 *
 * @author Tiffany tang
 */
public class Armor {

    /**
     * The name of the armor.
     */
    private String name;
    /**
     * Minimum range of stats.
     */
    private int min;
    /**
     * Maximum range of stats.
     */
    private int max;

    /**
     * Construct an armor with the given name and a pair of range for stats.
     *
     * @param name
     * @param p
     */
    public Armor(String name, Pair p) {
        this.name = name;
        this.min = p.getMin();
        this.max = p.getMax();

    }

    /**
     * Return the name of the armor.
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Calculate the value of base stats from the range.
     *
     * @return a integer as the value of base stats.
     */
    public int baseStats() {
        Random r = new Random();
        return r.nextInt(max + 1) + min;
    }

}
