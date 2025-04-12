/**
 * Abstract class Creature - 
 * The creature is the main class from which all other battling creatures derive.
 * It is the creature's job to maintain current health values in response to 
 * requests to takeDamage. It also must report if
 * the creature is alive or knocked out. The creature is also responsible for calculating
 * damage delivered based on the creature's strength (1 to str) 
 * 
 * @author Crosbie
 * @version 2025-04 v1.0
 */
public abstract class Creature {
    private int str;        // The strength of this creature
    private int max_hp;     // The maximum hit points the creature can have (used if healing enabled)
    private int hp;         // the current number of hit points the creature has

    /**
     * Create a creature with a given strength and hit point level. 
     * @param str the strength of the creature, used to calculate damage
     * @param hp the health of the creature at the start of the simulation
     */
    public Creature(int str, int hp) {
        this.str = str;
        this.hp = hp;
        this.max_hp = hp;
    }

    /**
     * Allows a creature to determine how much damage it is causing in this round of battle
     * @return a value between 1 and str (inclusive)
     */
    public int attack() {
        return 1 + Randomizer.nextInt(str);
    }

    /**
     * Check if this creature is still alive
     * @return true when current hit point level is greater than zero
     */
    public boolean isAlive() {
        return hp > 0;
    }

    /**
     * Check if this creature is knocked out
     * @return true when current hit point level is less than or equal to zero
     */
    public boolean isKnockedOut() {
        return hp <= 0;
    }

    /**
     * Reduce current HP by the amount of damage taken
     * @param damage value to remove from hit point count
     */
    public void takeDamage(int damage) {
        hp -= damage;
    }

    /**
     * Get current health for reporting purposes only
     * @return the current number of hit points
     */
    public int getHealth() {
        return hp;
    }
}