package edu.grinnell.csc207.lootgenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Treasures from the given file.
 *
 * @author Tiffany Tang
 */
public class Treasures {

    /**
     * All treasure.
     */
    private ArrayList<Treasure> allTreasure = new ArrayList<>();

    /**
     * Construct treasures from the given file.
     *
     * @param file
     * @throws FileNotFoundException
     */
    public Treasures(String file) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(file));
        while (scan.hasNext()) {
            String wholeS = scan.nextLine();
            String[] eachS = wholeS.split("\t");
            String[] items = Arrays.copyOfRange(eachS, 1, 4);
            String treasureC = eachS[0];
            Treasure p = new Treasure(treasureC, items);
            this.allTreasure.add(p);
        }
        scan.close();
    }

    /**
     * Determine if a treasure is a treasure class.
     *
     * @param t
     * @return true if it is, false otherwise.
     */
    public boolean isTC(Treasure t) {
        return isTC(t.getName());
    }

    /**
     * Determine if a treasure is a treasure class.
     *
     * @param treasureClass
     * @return true if it is, false otherwise.
     */
    public boolean isTC(String treasureClass) {
        for (Treasure t : this.allTreasure) {
            if (t.getName().equals(treasureClass)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return all the treasures of the file.
     *
     * @return allTreasure
     */
    public ArrayList<Treasure> getAll() {
        return this.allTreasure;
    }

    /**
     * Return the treasure with the same name.
     *
     * @param name
     * @return a specific treasure given by the name.
     */
    public Treasure getT(String name) {
        for (Treasure t : this.allTreasure) {
            if (t.getName().equals(name)) {
                return t;
            }
        }
        return null;
    }
}
