import java.util.Scanner;

public class Cave {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("You are in a land full of dragons. In front of you," +
                "\nYou see two caves. In one cave, the dragon is friendly" +
                "\nand will share his treasure with you. The other dragon" +
                "\nis greedy and hungry and will eat you on sight." +
                "\nWhich cave will you go into? (1 or 2)");

        int decision = s.nextInt();

        if(decision == 1) {
            System.out.println("\nYou approach the cave…" +
                    "\nIt is dark and spooky…" +
                    "\nHe opens his jaws and…" +
                    "\nGobbles you down in one bite!");
        } else {
            System.out.println("\nYou approach the cave…" +
                    "\nSuddenly, can see a light at the end of the tunnel…" +
                    "\nLots of gold above a peaceful dragon!" +
                    "\nHe gives you some diamonds and go back to sleep again…");
        }
    }
}
