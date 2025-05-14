package edu.grinnell.csc207.lootgenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Monsters from the given file.
 *
 * @author Tiffany Tang
 */
public class Monsters {

    /**
     * An array of all possible monster.
     */
    private ArrayList<Monster> arr = new ArrayList<>();

    /**
     * Construct monsters from the given file.
     *
     * @param file
     * @param allT
     * @throws FileNotFoundException
     */
    public Monsters(String file, Treasures allT) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(file));
        while (scan.hasNext()) {
            String wholeS = scan.nextLine();
            String[] eachS = wholeS.split("\t");
            this.arr.add(new Monster(eachS[0], eachS[1],
                    Integer.parseInt(eachS[2]), allT.getT(eachS[3])));
        }
        scan.close();
    }

    /**
     * Return the list of all monsters.
     *
     * @return arr
     */
    public ArrayList<Monster> getList() {
        return this.arr;
    }

}
