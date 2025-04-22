public class Goblin {
    private int health;
    private int x;
    private int y;
    private int attack;

    public Goblin(int x, int y) {
        this.attack = 1;
        this.health = 5;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    @Override
    public String toString() {
        return "G";
    }
}
