import java.util.Random;
import java.util.Scanner;

public class Battle {
    private CharacterInterface player1;
    private CharacterInterface player2;
    private CharacterInterface currentPlayer;
    private int turnCount = 1;
    private Random random = new Random();
    private Scanner scanner;

    public Battle(CharacterInterface player1, CharacterInterface player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = (random.nextBoolean()) ? player1 : player2;
        System.out.println("Battle starting between " + player1.getName() + " and " + player2.getName() + "!");
        System.out.println(currentPlayer.getName() + " goes first");
        this.scanner = new Scanner(System.in);
    }

    public void startBattle() {
        while (player1.isAlive() && player2.isAlive()) {
            System.out.println("\nTurn: " + turnCount);
            System.out.println(player1.getStatus());
            System.out.println(player2.getStatus());
            System.out.println("Current Player: " + currentPlayer.getName());

            CharacterInterface target = (currentPlayer == player1) ? player2 : player1;
            String action = chooseAction(scanner, currentPlayer);

            CharacterInterface attacker = currentPlayer;

            try {
                performAction(attacker, target, action);
                if (!target.isAlive()) {
                    break;
                }
            } catch (TargetDefeatedException e) {
                System.err.println("Action Failed: " + e.getMessage());
            } catch (InvalidActionException e) {
                System.err.println("Action Failed: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("An unexpected error occurred during the turn: " + e.getMessage());
            } finally {
                System.out.println(attacker.getName() + "'s action phase concluded");
                target.resetDefense();
            }

            if (!player1.isAlive() || !player2.isAlive()) {
                break;
            }

            currentPlayer = (currentPlayer == player1) ? player2 : player1;
            turnCount++;
        }

        System.out.println("\nBattle Over!");
        if (player1.isAlive() && !player2.isAlive()) {
            System.out.println(player1.getName() + " is victorious!");
        } else if (!player1.isAlive() && player2.isAlive()) {
            System.out.println(player2.getName() + " is victorious!");
        } else if (!player1.isAlive() && !player2.isAlive()) {
            System.out.println("Both combatants have fallen! It's a draw!");
        } else {
            System.out.println("The battle ended unexpectedly.");
        }
        System.out.println("Final Status:");
        System.out.println(player1.getStatus());
        System.out.println(player2.getStatus());

        if (scanner != null) {
            scanner.close();
        }
    }

    private void performAction(CharacterInterface attacker, CharacterInterface target, String action)
            throws InvalidActionException, TargetDefeatedException {

        if (!attacker.isAlive()) {
            throw new InvalidActionException(attacker.getName() + " cannot act, they are defeated!");
        }
        if (!target.isAlive()) {
            throw new TargetDefeatedException("Cannot target " + target.getName() + ", they are already defeated!");
        }

        System.out.println("\n" + attacker.getName() + " chooses to " + action + "!");
        switch (action.toLowerCase()) {
            case "attack":
                attacker.attack(target);
                break;
            case "defend":
                attacker.defend();
                break;
            case "special":
                attacker.useSpecialAbility(target);
                break;
            default:
                throw new InvalidActionException("Unknown action: " + action);
        }
    }

    private String chooseAction(Scanner scanner, CharacterInterface player) {
        while (true) {
            System.out.print(player.getName() + ", choose action (attack/defend/special): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("attack") || input.equals("defend") || input.equals("special")) {
                return input;
            } else {
                System.out.println("Please type 'attack', 'defend', or 'special'");
            }
        }
    }
}