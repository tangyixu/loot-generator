package edu.grinnell.csc207.lootgenerator;

/**
 * A pair class.
 *
 * @author Tiffany Tang
 */
public class Pair {

    /**
     * The lower bound.
     */
    private int min;
    /**
     * The upper bound.
     */
    private int max;

    /**
     * Constructing a pair based on given range.
     *
     * @param min
     * @param max
     */
    public Pair(int min, int max) {
        this.min = min;
        this.max = max;
    }

    /**
     * Get the lower bound.
     *
     * @return minimum
     */
    public int getMin() {
        return this.min;
    }

    /**
     * Get the upper bound.
     *
     * @return maximum
     */
    public int getMax() {
        return this.max;
    }

}
