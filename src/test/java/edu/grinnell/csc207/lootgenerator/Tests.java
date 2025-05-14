package edu.grinnell.csc207.lootgenerator;

import java.io.FileNotFoundException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class Tests {

    @Test
    public void extractSuffix() throws FileNotFoundException {
        String path = "data/small/MagicSuffix.txt";
        Suffixs suf = new Suffixs(path);
        assertEquals(5, suf.getSuffixL().size());
    }

    @Test
    public void extractPrefix() throws FileNotFoundException {
        String path = "data/small/MagicPrefix.txt";
        Prefixs suf = new Prefixs(path);
        assertEquals(5, suf.getPrefixL().size());
    }

    @Test
    public void isTC() throws FileNotFoundException {
        Treasure t = new Treasure("armo3", new String[]{"Quilted Armor",
            "Buckler", "Leather Armor"});
        Treasures allT = new Treasures("data/small/TreasureClassEx.txt");
        assertTrue(allT.isTC(t));
    }

}
