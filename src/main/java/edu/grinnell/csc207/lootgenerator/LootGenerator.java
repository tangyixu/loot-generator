package edu.grinnell.csc207.lootgenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class LootGenerator {

    /**
     * The path to the dataset (either the small or large set).
     */
    private static final String DATA_SET = "data/small";
    private Monster monster;
    private Treasure generatedDrop;
    private String suffix;
    private String prefix;

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

    public LootGenerator(Monster m, Treasure t) {
        this.monster = pickMonster();
        this.generatedDrop = generateBaseItem(fetchTreasureClass());
    }

    public static void main(String[] args) {
        System.out.println("This program kills monsters and generates loot!");

    }
}
