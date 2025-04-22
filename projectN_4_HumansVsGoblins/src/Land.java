import java.util.ArrayList;
import java.util.Random;

public class Land {
    private String[][] space;
    private Human player;
    private ArrayList<Goblin> enemies;

    public Land(Human player) {
        this.player = player;
        this.space  = new String[10][10];
        this.space[0][0] = "H";
        this.enemies = new ArrayList<Goblin>();

        Random r = new Random();
        int nEnemies = r.nextInt(10) + 1;

        for (int i = 0; i < nEnemies; i++) {
            this.enemies.add(new Goblin(r.nextInt(8)+ 2, r.nextInt(8)+ 2));
            this.space[enemies.getLast().getX()][enemies.getLast().getY()] = enemies.getLast().toString();
        }
    }

    public Human getPlayer() {
        return player;
    }

    public ArrayList<Goblin> getEnemies() {
        return enemies;
    }

    public void playerMovement(String s) {
        if (s.equalsIgnoreCase("n")) {
            if (this.player.moveUp()) {
                if (this.space[player.getX()][player.getY()] == "G") {
                    if (combat(this.player, findGoblin(player.getX(), player.getY()))) {
                        System.out.println("You won!");
                        this.space[player.getX()][player.getY()] = "H";
                        this.space[player.getX() + 1][player.getY()] = null;
                    }
                }
                else {
                    this.space[player.getX()][player.getY()] = "H";
                    this.space[player.getX() + 1][player.getY()] = null;
                }
            }
            else {
                System.out.println("Movement out of reach");
            }
        }
        if (s.equalsIgnoreCase("s")) {
            if (this.player.moveDown()) {
                if (this.space[player.getX()][player.getY()] == "G") {
                    if (combat(this.player, findGoblin(player.getX(), player.getY()))) {
                        System.out.println("You won!");
                        this.space[player.getX()][player.getY()] = "H";
                        this.space[player.getX() - 1][player.getY()] = null;
                    }
                }
                else {
                    this.space[player.getX()][player.getY()] = "H";
                    this.space[player.getX() - 1][player.getY()] = null;
                }
            }
            else {
                System.out.println("Movement out of reach");
            }
        }
        if (s.equalsIgnoreCase("w")) {
            if (this.player.moveLeft()) {
                if (this.space[player.getX()][player.getY()] == "G") {
                    if (combat(this.player, findGoblin(player.getX(), player.getY()))) {
                        System.out.println("You won!");
                        this.space[player.getX()][player.getY()] = "H";
                        this.space[player.getX()][player.getY() + 1] = null;
                    }
                }
                else {
                    this.space[player.getX()][player.getY()] = "H";
                    this.space[player.getX()][player.getY() + 1] = null;
                }
            }
            else {
                System.out.println("Movement out of reach");
            }
        }
        if (s.equalsIgnoreCase("e")) {
            if (this.player.moveRight()) {
                if (this.space[player.getX()][player.getY()] == "G") {
                    if (combat(this.player, findGoblin(player.getX(), player.getY()))) {
                        System.out.println("You won!");
                        this.space[player.getX()][player.getY()] = "H";
                        this.space[player.getX()][player.getY() - 1] = null;
                    }
                }
                else {
                    this.space[player.getX()][player.getY()] = "H";
                    this.space[player.getX()][player.getY() - 1] = null;
                }
            }
            else {
                System.out.println("Movement out of reach");
            }
        }
    }

    public boolean combat(Human p, Goblin g) {
        System.out.println("\n\nA combat has begun!");

        Random r = new Random();
        while(p.getHealth() > 0 && g.getHealth() > 0) {
            if (r.nextInt(5) == 0) {
                System.out.println("Goblin attacked and landed a hit!");
                p.setHealth(p.getHealth() - g.getAttack());
            }
            else {
                System.out.println( player.getName() + " attacked and landed a hit!");
                g.setHealth(g.getHealth() - p.getAttack());
            }
        }

        if (p.getHealth() > 0) {
            p.setMoney(p.getMoney() + (r.nextInt(100) + 50));
            enemies.remove(g);
            System.out.println("\nYou gain money!");
            return true;
        } else {
            return false;
        }
    }

    public Goblin findGoblin(int x, int y) {
        Goblin goblin = null;
        for (Goblin g : this.enemies) {
            if (g.getX() == x && g.getY() == y) {
                goblin = g;
                break;
            }
        }
        return goblin;
    }

    @Override
    public String toString() {
        String field = "";
        for (int i = 0; i < this.space.length; i++) {
            for (int j = 0; j < this.space[i].length; j++) {
                if (this.space[i][j] != null) {
                    field = field + "[ " + this.space[i][j] + " ]";
                }
                else {
                    field = field + "[ _ ]";
                }
            }
            field = field + "\n";
        }
        return field;
    }
}
