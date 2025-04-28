public class Warrior implements CharacterInterface {
    private String name;
    private int maxHp;
    private int currentHp;
    private int attackPower;
    private int defense;
    private boolean isDefending = false;

    public Warrior(String name) {
        this.name = name;
        this.maxHp = 120;
        this.currentHp = 120;
        this.attackPower = 15;
        this.defense = 10;
    }

    @Override
    public void attack(CharacterInterface target) {
        System.out.println(this.name + " attacks " + target.getName() + "!");
        target.takeDamage(calculateDamage(this.attackPower, target));
    }

    @Override
    public void defend() {
        System.out.println(this.name + " takes a defensive stance");
        this.isDefending = true;
    }

    @Override
    public void useSpecialAbility(CharacterInterface target) {
        System.out.println(this.name + " uses Power Strike on " + target.getName() + "!");
        target.takeDamage(calculateDamage(this.attackPower + 10, target));
    }

    @Override
    public void takeDamage(int damage) {
        int actualDamage = damage;
        if (this.isDefending) {
            System.out.println(this.name + " defends, reducing incoming damage");
            actualDamage = Math.max(0, damage / 2);
        }

        this.currentHp -= actualDamage;
        if (this.currentHp < 0) {
            this.currentHp = 0;
        }
        System.out.println(this.name + " takes " + actualDamage + " damage. Current HP: " + this.currentHp + "/" + this.maxHp);
        if (!isAlive()) {
            System.out.println(this.name + " has been defeated!");
        }
    }

    private int calculateDamage(int attackerPower, CharacterInterface target) {
        return Math.max(1, attackerPower - target.getDefense());
    }

    @Override
    public boolean isAlive() {
        return this.currentHp > 0;
    }

    @Override
    public void resetDefense() {
        if (this.isDefending) {
            System.out.println(this.name + " lowers their guard");
            this.isDefending = false;
        }
    }

    @Override public String getName() { return name; }
    @Override public int getCurrentHp() { return currentHp; }
    @Override public int getMaxHp() { return maxHp; }
    @Override public int getAttackPower() { return attackPower; }
    @Override public int getDefense() { return defense; }

    @Override
    public String getStatus() {
        return String.format("%s (HP: %d/%d, ATK: %d, DEF: %d)%s",
                name, currentHp, maxHp, attackPower, defense, (isDefending ? " [Defending]" : ""));
    }
}