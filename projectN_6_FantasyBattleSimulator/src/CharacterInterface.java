public interface CharacterInterface {

    void attack(CharacterInterface target);
    void defend();
    void useSpecialAbility(CharacterInterface target);
    void takeDamage(int damage);

    boolean isAlive();
    String getName();
    int getCurrentHp();
    int getMaxHp();
    int getAttackPower();
    int getDefense();
    String getStatus();

    void resetDefense();
}