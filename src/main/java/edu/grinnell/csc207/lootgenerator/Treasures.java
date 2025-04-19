package edu.grinnell.csc207.lootgenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Tiffany Tang
 */
public class Treasures {

    private ArrayList<Treasure> allTreasure = new ArrayList<>();

    public Treasures(String file) {
        Scanner scan = new Scanner(file);
        while (scan.hasNext()) {
            String wholeS = scan.nextLine();
            String[] eachS = wholeS.split("     ");
            String[] items = Arrays.copyOfRange(eachS, 1, 4);
            String TC = eachS[0];
            Treasure p = new Treasure(TC, items);
            this.allTreasure.add(p);
        }
        scan.close();
    }

    public boolean isTC(Treasure t) {
        return allTreasure.contains(t);
    }

    public boolean isTC(String TC) {
        for (Treasure t : this.allTreasure) {
            if (t.TC.equals(TC)) {
                return true;
            }
        }
        return false;
    }
}
