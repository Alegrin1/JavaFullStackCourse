public class Mage implements CharacterInterface {
    private String name;
    private int maxHp;
    private int currentHp;
    private int attackPower;
    private int defense;
    private boolean isDefending = false;

    public Mage(String name) {
        this.name = name;
        this.maxHp = 80;
        this.currentHp = 80;
        this.attackPower = 20;
        this.defense = 5;
    }

    @Override
    public void attack(CharacterInterface target) {
        System.out.println(this.name + " attacks " + target.getName() + "!");
        int damage = calculateDamage(this.attackPower, target);
        target.takeDamage(damage);
    }

    @Override
    public void defend() {
        System.out.println(this.name + " raises a magical barrier");
        this.isDefending = true;
    }

    @Override
    public void useSpecialAbility(CharacterInterface target) {
        System.out.println(this.name + " casts Fireball at " + target.getName() + "!");
        target.takeDamage(calculateDamage(this.attackPower + 5, target) * 2); // Double damage
    }

    @Override
    public void takeDamage(int damage) {
        int actualDamage = damage;
        if (this.isDefending) {
            System.out.println(this.name + "'s barrier absorbs some impact");
            actualDamage = Math.max(0, damage / 2);
        }
        this.currentHp -= actualDamage;
        if (this.currentHp < 0) this.currentHp = 0;
        System.out.println(this.name + " takes " + actualDamage + " damage. Current HP: " + this.currentHp + "/" + this.maxHp);
        if (!isAlive()) System.out.println(this.name + " has been defeated!");
    }

    private int calculateDamage(int attackerPower, CharacterInterface target) {
        int effectiveDefense = target.getDefense();
        return Math.max(1, attackerPower - effectiveDefense);
    }

    @Override
    public boolean isAlive() { return this.currentHp > 0; }

    @Override
    public void resetDefense() {
        if (this.isDefending) {
            System.out.println(this.name + " lowers their barrier");
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