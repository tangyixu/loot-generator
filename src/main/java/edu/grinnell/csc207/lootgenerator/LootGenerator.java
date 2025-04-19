package edu.grinnell.csc207.lootgenerator;

import java.util.Random;
import java.util.Scanner;

public class LootGenerator {

    /**
     * The path to the dataset (either the small or large set).
     */
    private static final String DATA_SET = "data/small";
    public Monster monster;
    public Treasure generatedDrop;
    public String suffix;
    public String prefix;

    private Treasures allTreasures = new Treasures(LootGenerator.DATA_SET + "/TreasureClass.txt");
    private Armors allArmors = new Armors(LootGenerator.DATA_SET + "/armor.txt");
    private Suffixs suffixs = new Suffixs(LootGenerator.DATA_SET + "/MagicSuffix.txt");
    private Prefixs prefixs = new Prefixs(LootGenerator.DATA_SET + "/MagicPrefix.txt");

    private Monster pickMonster() {
        Random r = new Random();
        Monsters monList = new Monsters(LootGenerator.DATA_SET + "/monstats.txt");
        int index = r.nextInt(monList.getList().size());
        return monList.getList().get(index);
    }

    private Treasure fetchTreasureClass() {
        return this.monster.getTC();
    }

    private Treasure generateBaseItem(Treasure t) {
        Random r = new Random();
        if (!this.allTreasures.isTC(t)) {
            return t;
        } else {
            return generateBaseItem(new Treasure(t.getItems()[r.nextInt(3)]));
        }
    }

    public int generateBaseStats() {
        Armor a = this.allArmors.getArmor(this.generatedDrop.getName());
        return a.baseStats();
    }

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

    public LootGenerator() {
        this.monster = pickMonster();
        this.generatedDrop = generateBaseItem(fetchTreasureClass());
    }

    public static void main(String[] args) {
        boolean again = true;
        while (again) {
            Scanner scan = new Scanner(System.in);
            LootGenerator lg = new LootGenerator();
            String monsterName = lg.monster.getName();
            System.out.println("Fighting" + monsterName + "...");
            System.out.println("You have slain" + monsterName + "!");
            System.out.println(monsterName + "dropped:");
            System.out.println(lg.generateAffix()[0] + lg.generatedDrop.getName()
                    + lg.generateAffix()[3]);
            System.out.println(lg.generatedDrop.getName());
            System.out.println("Defense:" + lg.generateBaseStats());
            System.out.println(lg.generateAffix()[1] + lg.generateAffix()[2]);
            System.out.println(lg.generateAffix()[4] + lg.generateAffix()[5]);

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
