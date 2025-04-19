package edu.grinnell.csc207.lootgenerator;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Tiffany Tang
 */
public class Armors {

    private ArrayList<Armor> arr = new ArrayList<>();

    public Armors(String file) {
        Scanner scan = new Scanner(file);
        while (scan.hasNext()) {
            String wholeS = scan.nextLine();
            String[] eachS = wholeS.split("\t");
            this.arr.add(new Armor(eachS[0], new Pair(Integer.parseInt(eachS[1]),
                    Integer.parseInt(eachS[2]))));
        }
        scan.close();
    }

    public ArrayList<Armor> getList() {
        return this.arr;
    }

    public Armor getArmor(String name) {
        for (Armor a : this.arr) {
            if (a.getName().equals(name)) {
                return a;
            }
        }
        throw new NoSuchElementException("Armor not found.");
    }
}
