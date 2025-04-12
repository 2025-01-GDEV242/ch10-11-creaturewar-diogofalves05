public class Elf extends Creature {

    public Elf() {
        super(
            5 + Randomizer.nextInt(14),  // 5 to 18 → range is 14 steps (18 - 5 + 1)
            8 + Randomizer.nextInt(18)   // 8 to 25 → range is 18 steps (25 - 8 + 1)
        );
    }

    @Override
    public int attack() {
        int baseDamage = super.attack();
        if (Randomizer.nextInt(100) < 10) { // 0–99, so <10 is 10% chance
            return baseDamage * 2;
        }
        return baseDamage;
    }
}