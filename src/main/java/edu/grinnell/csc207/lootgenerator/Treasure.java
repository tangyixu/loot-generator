package edu.grinnell.csc207.lootgenerator;

/**
 *
 * @author Tiffany Tang
 */
public class Treasure {

    public String TC;
    public String[] items;

    public Treasure(String TC, String[] items) {
        this.TC = TC;
        this.items = items;
    }

    public Treasure(String TC) {
        this.TC = TC;
        this.items = new String[0];
    }

    public String getTC() {
        return this.TC;
    }

}
