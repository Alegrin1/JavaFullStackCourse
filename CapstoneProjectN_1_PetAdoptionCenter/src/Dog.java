import java.io.Serial;

class Dog extends Pet {
    @Serial
    private static final long serialVersionUID = 1L;
    private String size;

    public Dog(String name, int age, String breed, String size) {
        super(name, "Dog", age, breed);
        this.size = size;
    }

    public String getSize() { return size; }

    @Override
    public String displayDetails() {
        return super.displayDetails() + String.format(", Size: %s", size);
    }
}