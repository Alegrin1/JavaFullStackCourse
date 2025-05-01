import java.io.Serial;

public class Cat extends Pet {
    @Serial
    private static final long serialVersionUID = 1L;
    private boolean isIndoor;

    public Cat(String name, int age, String breed, boolean isIndoor) {
        super(name, "Cat", age, breed);
        this.isIndoor = isIndoor;
    }

    public boolean isIndoor() { return isIndoor; }

    @Override
    public String displayDetails() {
        return super.displayDetails() + String.format(", Indoor: %b", isIndoor);
    }
}
