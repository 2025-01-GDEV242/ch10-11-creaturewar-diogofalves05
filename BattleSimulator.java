import java.util.ArrayList;

public class BattleSimulator {

    public static void main(String[] args) {
        ArrayList<Creature> goodArmy = new ArrayList<>();
        ArrayList<Creature> evilArmy = new ArrayList<>();

        // Populate good army: Humans, Elves, Dwarves
        for (int i = 0; i < 100; i++) {
            int roll = Randomizer.nextInt(10);
            if (roll < 5) {
                goodArmy.add(new Human());
            } else if (roll < 8) {
                goodArmy.add(new Elf());
            } else {
                goodArmy.add(new Dwarf());
            }
        }

        // Populate evil army: Humans, CyberDemons, Orcs, Balrogs
        for (int i = 0; i < 40; i++) {
            int roll = Randomizer.nextInt(25);
            if (roll < 15) {
                evilArmy.add(new Human());
            } else if (roll < 21) {
                evilArmy.add(new CyberDemon());
            } else if (roll < 24) {
                evilArmy.add(new Orc());
            } else {
                evilArmy.add(new Balrog());
            }
        }

        System.out.println("Good army size: " + goodArmy.size());
        System.out.println("Evil army size: " + evilArmy.size());

        int goodIndex = 0;
        int evilIndex = 0;
        int totalFights = 0;
        int goodKOs = 0;
        int evilKOs = 0;

        while (goodIndex < goodArmy.size() && evilIndex < evilArmy.size()) {
            Creature good = goodArmy.get(goodIndex);
            Creature evil = evilArmy.get(evilIndex);

            System.out.println("⚔️ New Duel: Good[" + good.getClass().getSimpleName() +
                               "] vs Evil[" + evil.getClass().getSimpleName() + "]");

            // One-on-one combat loop
            while (good.isAlive() && evil.isAlive()) {
                int damageToEvil = good.attack();
                int damageToGood = evil.attack();

                evil.takeDamage(damageToEvil);
                good.takeDamage(damageToGood);

                System.out.println("Good dealt " + damageToEvil + ", Evil has " + evil.getHealth());
                System.out.println("Evil dealt " + damageToGood + ", Good has " + good.getHealth());
            }

            if (!good.isAlive()) {
                System.out.println("💀 Good " + good.getClass().getSimpleName() + " is knocked out!");
                goodIndex++;
                goodKOs++;
            }

            if (!evil.isAlive()) {
                System.out.println("💀 Evil " + evil.getClass().getSimpleName() + " is knocked out!");
                evilIndex++;
                evilKOs++;
            }

            System.out.println("---------------");
            totalFights++;
        }

        // Final result
        if (goodIndex >= goodArmy.size() && evilIndex >= evilArmy.size()) {
            System.out.println("⚖️ It's a tie! Both armies are wiped out.");
        } else if (goodIndex >= goodArmy.size()) {
            System.out.println("😈 Evil Army wins the war!");
        } else {
            System.out.println("🛡️ Good Army wins the war!");
        }

        // Final Stats Summary
        System.out.println("\n===== Final Battle Stats =====");
        System.out.println("Total Duels Fought: " + totalFights);
        System.out.println("Good Creatures Knocked Out: " + goodKOs);
        System.out.println("Evil Creatures Knocked Out: " + evilKOs);
        System.out.println("Good Survivors: " + (goodArmy.size() - goodKOs));
        System.out.println("Evil Survivors: " + (evilArmy.size() - evilKOs));
        System.out.println("================================");
    }
}