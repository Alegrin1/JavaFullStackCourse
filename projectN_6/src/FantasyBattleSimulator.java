public class FantasyBattleSimulator {

    public static void main(String[] args) {
        CharacterInterface hero = new Warrior("Me");
        CharacterInterface villain = new Mage("CPU");

        Battle currentBattle = new Battle(hero, villain);
        currentBattle.startBattle();
    }
}