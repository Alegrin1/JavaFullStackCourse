import java.util.Scanner;

public class HumanVsGoblin {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Welcome to the game of Human Vs Goblin!" +
                "\n\nWhats the player name?");
        Land field = new Land(new Human(s.nextLine()));

        System.out.println("\nLets start the adventure!");

        while(field.getPlayer().getHealth() > 0 && !field.getEnemies().isEmpty()) {
            System.out.println(field.toString());
            System.out.println("Where do you wanna move? n/s/e/w");
            field.playerMovement(s.nextLine());
            System.out.println(field.getPlayer().toString());
        }

        if (field.getPlayer().getHealth() > 0) {
            System.out.println("Congratuluations! You beat all the goblins");
        }
        else {
            System.out.println("You lost... GAME OVER");
        }
    }
}
