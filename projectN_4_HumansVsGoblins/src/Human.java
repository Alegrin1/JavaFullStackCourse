public class Human {
    private final String name;
    private int health;
    private int x;
    private int y;
    private float money;
    private int attack;

    public Human(String name) {
        this.name = name;
        this.attack = 2;
        this.health = 20;
        this.money = 0F;
        this.x = 0;
        this.y = 0;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public float getMoney() {
        return money;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public int getAttack() {
        return attack;
    }

    public boolean moveUp() {
        if (x == 0) {
            return false;
        }
        else  {
            x--;
            return true;
        }
    }

    public boolean moveLeft() {
        if (y == 0) {
            return false;
        }
        else  {
            y--;
            return true;
        }
    }

    public boolean moveDown() {
        if (x == 9) {
            return false;
        }
        else  {
            x++;
            return true;
        }
    }

    public boolean moveRight() {
        if (y == 9) {
            return false;
        }
        else  {
            y++;
            return true;
        }
    }

    @Override
    public String toString() {
        return "Your stats:" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", money=" + money;
    }
}
