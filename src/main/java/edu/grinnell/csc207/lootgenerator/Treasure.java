package edu.grinnell.csc207.lootgenerator;

/**
 * A single treasure.
 *
 * @author Tiffany Tang
 */
public class Treasure {

    /**
     * The name of the treasure.
     */
    private String treasureClass;
    /**
     * The items it has.
     */
    private String[] items;

    /**
     * Construct a treasure from the given string and items.
     *
     * @param treasureC
     * @param items
     */
    public Treasure(String treasureC, String[] items) {
        this.treasureClass = treasureC;
        this.items = items;
    }

    /**
     * Construct a teasure from the given name.
     *
     * @param treasureC
     */
    public Treasure(String treasureC) {
        this.treasureClass = treasureC;
        this.items = new String[0];
    }

    /**
     * Return the name of the treasure.
     *
     * @return the name of the treasure.
     */
    public String getName() {
        return this.treasureClass;
    }

    /**
     * Get the items of the treasure.
     *
     * @return the items .
     */
    public String[] getItems() {
        return this.items;
    }

}
