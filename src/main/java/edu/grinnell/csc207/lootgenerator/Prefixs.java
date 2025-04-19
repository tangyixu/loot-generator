package edu.grinnell.csc207.lootgenerator;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Tiffany
 */
public class Prefixs {

    private ArrayList<String> prefixL = new ArrayList<>();
    private ArrayList<String> modCode = new ArrayList<>();
    private ArrayList<Pair> modRange = new ArrayList<>();

    public Prefixs(String file) {
        Scanner scan = new Scanner(file);
        while (scan.hasNext()) {
            String wholeS = scan.nextLine();
            String[] eachS = wholeS.split("\t");
            this.prefixL.add(eachS[0]);
            this.modCode.add(eachS[1]);
            this.modRange.add(new Pair(Integer.parseInt(eachS[2]),
                    Integer.parseInt(eachS[3])));
        }
        scan.close();
    }

    public ArrayList<String> getPrefixL() {
        return this.prefixL;
    }

    public ArrayList<String> getModCode() {
        return this.modCode;
    }

    public ArrayList<Pair> getModRange() {
        return this.modRange;
    }

    public String[] getPrefix(int index) {
        Random r = new Random();
        String[] results = {"", "", ""};
        Pair p = this.modRange.get(index);
        results[0] = this.prefixL.get(index);
        results[1] = "" + r.nextInt(p.getMax() - p.getMin() + 1) + p.getMin();
        results[2] = this.modCode.get(index);
        return results;
    }

}
