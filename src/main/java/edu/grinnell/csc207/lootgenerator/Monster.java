package edu.grinnell.csc207.lootgenerator;

/**
 * A single monster.
 *
 * @author Tiffany Tang
 */
public class Monster {

    /**
     * The name of the monster.
     */
    private String name;
    /**
     * The type of the monster.
     */
    private String type;
    /**
     * The level of the monster.
     */
    private int level;
    /**
     * The treasure class of the monster.
     */
    private Treasure treasureClass;

    /**
     * Construct a monster class.
     *
     * @param name
     * @param type
     * @param level
     * @param treasure
     */
    public Monster(String name, String type, int level, Treasure treasure) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.treasureClass = treasure;
    }

    /**
     * Return the name of the monster.
     *
     * @return the name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the type of the monster.
     *
     * @return the type of the monster.
     */
    public String getType() {
        return this.type;
    }

    /**
     * Return the level of the monster.
     *
     * @return the level of the monster.
     */
    public int getLevel() {
        return this.level;
    }

    /**
     * Return its treasure class.
     *
     * @return the treasureClass of the monster.
     */
    public Treasure getTC() {
        return this.treasureClass;
    }
}
