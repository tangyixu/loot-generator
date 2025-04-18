package edu.grinnell.csc207.lootgenerator;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tiffany Tang
 */
public class Monsters {

    private ArrayList<Monster> arr = new ArrayList<>();

    public Monsters(String file) {
        Scanner scan = new Scanner(file);
        while (scan.hasNext()) {
            String wholeS = scan.nextLine();
            String[] eachS = wholeS.split("\\s+");
            this.arr.add(new Monster(eachS[0], eachS[1],
                    Integer.parseInt(eachS[2]), new Treasure(eachS[3])));
        }
        scan.close();
    }

    public ArrayList<Monster> getList() {
        return this.arr;
    }

}
