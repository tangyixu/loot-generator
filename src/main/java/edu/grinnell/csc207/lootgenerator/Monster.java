package edu.grinnell.csc207.lootgenerator;

/**
 *
 * @author Tiffany Tang
 */
public class Monster {

    private String name;
    private String type;
    private int level;
    private Treasure treasureClass;

    public Monster(String name, String type, int level, Treasure treasure) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.treasureClass = treasure;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public int getLevel() {
        return this.level;
    }

    public Treasure getTreasure() {
        return this.treasureClass;
    }
}
