package edu.grinnell.csc207.lootgenerator;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tiffany
 */
public class Suffixs {

    private ArrayList<String> suffixL = new ArrayList<>();
    private ArrayList<String> modCode = new ArrayList<>();
    private ArrayList<Pair> modRange = new ArrayList<>();

    public Suffixs(String file) {
        Scanner scan = new Scanner(file);
        while (scan.hasNext()) {
            String wholeS = scan.nextLine();
            String[] eachS = wholeS.split("\t");
            this.suffixL.add(eachS[0]);
            this.modCode.add(eachS[1]);
            this.modRange.add(new Pair(Integer.parseInt(eachS[2]),
                    Integer.parseInt(eachS[3])));
        }
        scan.close();
    }

    public ArrayList<String> getPrefixL() {
        return this.suffixL;
    }

    public ArrayList<String> getModCode() {
        return this.modCode;
    }

    public ArrayList<Pair> getModRange() {
        return this.modRange;
    }

}
