package edu.grinnell.csc207.lootgenerator;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * Generate a loot from the given files.
 *
 * @author Tiffany Tang
 */
public class LootGenerator {

    /**
     * The path to the dataset (either the small or large set).
     */
    private static final String DATA_SET = "data/large";
    /**
     * The monster.
     */
    public Monster monster;
    /**
     * The drop generated after slaining the monster.
     */
    public Armor generatedDrop;
    /**
     * Suffix of the drop.
     */
    public String suffix;
    /**
     * Prefix of the drop.
     */
    public String prefix;
    /**
     * All treasures from the given file.
     */
    private Treasures allTreasures = new Treasures(LootGenerator.DATA_SET + "/TreasureClassEx.txt");
    /**
     * All armors from the given file.
     */
    private Armors allArmors;
    /**
     * All suffixs of armors from the file.
     */
    private Suffixs suffixs = new Suffixs(LootGenerator.DATA_SET + "/MagicSuffix.txt");
    /**
     * All prefixs of armors from the file.
     */
    private Prefixs prefixs = new Prefixs(LootGenerator.DATA_SET + "/MagicPrefix.txt");

    /**
     * Pick the monster randomly.
     *
     * @return a monster.
     * @throws FileNotFoundException
     */
    private Monster pickMonster() throws FileNotFoundException {
        Random r = new Random();
        Monsters monList = new Monsters(LootGenerator.DATA_SET
                + "/monstats.txt", this.allTreasures);
        int index = r.nextInt(monList.getList().size());
        return monList.getList().get(index);
    }

    /**
     * Return the treasure class of the monster.
     *
     * @return the treasure.
     */
    private Treasure fetchTreasureClass() {
        return this.monster.getTC();
    }

    /**
     * Generate the name of the base item.
     *
     * @param t
     * @return a name of the item as a string.
     */
    private String generateBaseItem(Treasure t) {
        Random r = new Random();
        if (!this.allTreasures.isTC(t)) {
            return t.getName();
        } else {
            String name = t.getItems()[r.nextInt(3)];
            if (this.allTreasures.getT(name) == null) {
                return name;
            }
            return generateBaseItem(this.allTreasures.getT(name));
        }
    }

    /**
     * Generate a base stats.
     *
     * @return an integer as the base stats
     */
    public int generateBaseStats() {
        Armor a = this.allArmors.getArmor(this.generatedDrop.getName());
        if (a == null) {
            return 0;
        }
        return a.baseStats();
    }

    /**
     * Generate an affix.
     *
     * @return a string array of affix information.
     */
    public String[] generateAffix() {
        String[] affix = new String[6];
        Random r = new Random();
        int probPrefix = r.nextInt(2);
        int probSuffix = r.nextInt(2);
        if (probPrefix == 0) {
            int bound = this.prefixs.getPrefixL().size();
            int index = r.nextInt(bound);
            String[] prefixInfo = this.prefixs.getPrefix(index);
            System.arraycopy(prefixInfo, 0, affix, 0, 3);
        }
        if (probSuffix == 0) {
            int bound = this.suffixs.getSuffixL().size();
            int index = r.nextInt(bound);
            String[] suffixInfo = this.suffixs.getSuffix(index);
            System.arraycopy(suffixInfo, 0, affix, 3, 3);
        }
        return affix;
    }

    /**
     * Construct a loot generator based on the given file.
     *
     * @throws FileNotFoundException
     */
    public LootGenerator() throws FileNotFoundException {
        this.allArmors = new Armors(LootGenerator.DATA_SET + "/armor.txt");
        this.monster = pickMonster();
        this.generatedDrop = this.allArmors.getArmor(generateBaseItem(fetchTreasureClass()));
    }

    /**
     * The main engine of the loot generator game.
     *
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        boolean again = true;
        while (again) {
            Scanner scan = new Scanner(System.in);
            LootGenerator lg = new LootGenerator();
            String monsterName = lg.monster.getName();
            System.out.println("Fighting " + monsterName + "...");
            System.out.println("You have slain " + monsterName + "!");
            System.out.println(monsterName + " dropped: \n");
            String[] affix = lg.generateAffix();
            String prefix = affix[0];
            String suffix = affix[3];
            String valP = affix[1];
            String textP = affix[2];
            String valS = affix[4];
            String textS = affix[5];

            if (prefix == null && suffix == null) {
                System.out.println(lg.generatedDrop.getName());
            } else if (prefix == null) {
                System.out.println(lg.generatedDrop.getName() + " " + suffix);
            } else if (suffix == null) {
                System.out.println(prefix + " " + lg.generatedDrop.getName());
            } else {
                System.out.println(prefix + " " + lg.generatedDrop.getName()
                        + " " + suffix);
            }

            System.out.println("Defense: " + lg.generateBaseStats());

            if (textP != null) {
                System.out.println(valP + " " + textP);
            }
            if (textS != null) {
                System.out.println(valS + " " + textS);
            }

            System.out.println("Fight again [y/n]?");
            String input = scan.nextLine().toLowerCase();
            switch (input) {
                case "y" ->
                    again = true;
                case "n" ->
                    again = false;
                default -> {
                    System.out.println("Invalid input. Only y or n is accepatble.");
                    System.exit(1);
                }
            }
        }

    }
}
