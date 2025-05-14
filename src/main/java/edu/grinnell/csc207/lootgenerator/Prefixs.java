package edu.grinnell.csc207.lootgenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 * Processing Prefixs from a given file.
 *
 * @author Tiffany
 */
public class Prefixs {

    /**
     * The list of all prefixs.
     */
    private ArrayList<String> prefixL = new ArrayList<>();
    /**
     * The list of strings for code.
     */
    private ArrayList<String> modCode = new ArrayList<>();
    /**
     * The ranges of the code.
     */
    private ArrayList<Pair> modRange = new ArrayList<>();

    /**
     * Construct Prefixs from a given file.
     *
     * @param file
     * @throws FileNotFoundException
     */
    public Prefixs(String file) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(file));
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

    /**
     * Return the list of prefixs.
     *
     * @return prefixL
     */
    public ArrayList<String> getPrefixL() {
        return this.prefixL;
    }

    /**
     * All codes as a list for prefixs.
     *
     * @return modCode
     */
    public ArrayList<String> getModCode() {
        return this.modCode;
    }

    /**
     * Return the range of codes.
     *
     * @return modRange
     */
    public ArrayList<Pair> getModRange() {
        return this.modRange;
    }

    /**
     * Return a specific prefix based on the index with its code and value.
     *
     * @param index
     * @return a prefix as an array of string.
     */
    public String[] getPrefix(int index) {
        Random r = new Random();
        String[] results = {"", "", ""};
        Pair p = this.modRange.get(index);
        results[0] = this.prefixL.get(index) + "";
        results[1] = Integer.toString(r.nextInt(p.getMax() - p.getMin() + 1) + p.getMin());
        results[2] = this.modCode.get(index);
        return results;
    }

}
