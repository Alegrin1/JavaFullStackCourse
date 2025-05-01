import java.io.Serial;

public class Bird extends Pet {
    @Serial
    private static final long serialVersionUID = 1L;
    private boolean canSpeak;

    public Bird(String name, int age, String breed, boolean canSpeak) {
        super(name, "Bird", age, breed);
        this.canSpeak = canSpeak;
    }

    public boolean CanSpeak() { return canSpeak; }

    @Override
    public String displayDetails() {
        return super.displayDetails() + String.format(", Speaks: %b", canSpeak);
    }
}