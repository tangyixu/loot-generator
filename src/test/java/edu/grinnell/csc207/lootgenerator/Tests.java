package edu.grinnell.csc207.lootgenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class Tests {

    @Test
    public void extractSuffix() {
        String path = "data/small/MagicSuffix.txt";
        Suffixs suf = new Suffixs(path);
        assertEquals(5, suf.getSuffixL().size());
    }

    @Test
    public void extractPrefix() {
        String path = "data/small/MagicPrefix.txt";
        Prefixs suf = new Prefixs(path);
        assertEquals(5, suf.getPrefixL().size());
    }

    @Test
    public void armorStats() {
        String path = "data/small/monstats.txt";
        Armors armors = new Armors(path);
        int val = armors.getList().get(0).baseStats();
        assertEquals(val >= 8 && val <= 10, "Invalid range for armor stats.");
    }

    @Test
    public void isTC() {
        Treasure t = new Treasure("armo3", new String[]{"Quilted Armor",
            "Buckler", "Leather Armor"});
        Treasures allT = new Treasures("data/small/TreasureClass.txt");
        assertTrue(allT.isTC(t));
    }

}
