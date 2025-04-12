import java.util.ArrayList;

public class BattleSimulator {

    public static void main(String[] args) {
        ArrayList<Creature> goodArmy = new ArrayList<>();
        ArrayList<Creature> evilArmy = new ArrayList<>();

        // Populate good army: mostly Humans & Elves
        for (int i = 0; i < 100; i++) {
            int roll = Randomizer.nextInt(10);
            if (roll < 6) {
                goodArmy.add(new Human());
            } else {
                goodArmy.add(new Elf());
            }
        }

        // Populate evil army: fewer but more powerful
        for (int i = 0; i < 40; i++) {
            int roll = Randomizer.nextInt(25);
            if (roll < 18) {
                evilArmy.add(new Human());
            } else if (roll < 24) {
                evilArmy.add(new CyberDemon());
            } else {
                evilArmy.add(new Balrog());
            }
        }

        // You can print size info here if you want
        System.out.println("Good army size: " + goodArmy.size());
        System.out.println("Evil army size: " + evilArmy.size());
    }
}