package edu.grinnell.csc207.lootgenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Storing all armors from the file.
 *
 * @author Tiffany Tang
 */
public class Armors {

    /**
     * An array of armors.
     */
    private ArrayList<Armor> arr = new ArrayList<>();

    /**
     * Construct Armors from a given file.
     *
     * @param file
     * @throws FileNotFoundException
     */
    public Armors(String file) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(file));
        while (scan.hasNext()) {
            String wholeS = scan.nextLine();
            String[] eachS = wholeS.split("\t");
            this.arr.add(new Armor(eachS[0], new Pair(Integer.parseInt(eachS[1]),
                    Integer.parseInt(eachS[2]))));
        }
        scan.close();
    }

    /**
     * Get the list of armors.
     *
     * @return an list of armor.
     */
    public ArrayList<Armor> getList() {
        return this.arr;
    }

    /**
     * Get the specific armor with the given name from the list.
     *
     * @param name
     * @return the Armor with the specific name
     */
    public Armor getArmor(String name) {
        for (Armor a : this.arr) {
            if (a.getName().toLowerCase().equals(name.toLowerCase())) {
                return a;
            }
        }
        return null;
    }
}
