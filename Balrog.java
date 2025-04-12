public class Balrog extends Demon {

    public Balrog() {
        super(
            50 + Randomizer.nextInt(51),   // 50 to 100 → 51 steps
            80 + Randomizer.nextInt(121)   // 80 to 200 → 121 steps
        );
    }

    @Override
    public int attack() {
        int firstHit = super.attack();
        int secondHit = super.attack();
        return firstHit + secondHit;
    }
}