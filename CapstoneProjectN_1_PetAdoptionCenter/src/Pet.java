import java.io.Serial;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

class Pet implements Serializable, Adoptable {
    @Serial
    private static final long serialVersionUID = 1L;
    private static final AtomicInteger idCounter = new AtomicInteger(0);

    protected int petId;
    protected String name;
    protected String species;
    protected int age;
    protected String breed;
    protected String adoptionStatus;

    public Pet(String name, String species, int age, String breed) {
        this.petId = idCounter.incrementAndGet();
        this.name = name;
        this.species = species;
        this.age = age;
        this.breed = breed;
        this.adoptionStatus = "Available";
    }

    public int getPetId() { return petId; }
    public String getName() { return name; }
    public String getSpecies() { return species; }
    public int getAge() { return age; }
    public String getBreed() { return breed; }
    public String getAdoptionStatus() { return adoptionStatus; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }


    @Override
    public boolean isAdoptable() {
        return "Available".equalsIgnoreCase(this.adoptionStatus);
    }

    @Override
    public void markAdopted() {
        this.adoptionStatus = "Adopted";
    }

    @Override
    public void markAvailable() {
        this.adoptionStatus = "Available";
    }

    public String displayDetails() {
        return String.format("ID: %d, Name: %s, Species: %s, Age: %d, Breed: %s, Status: %s",
                petId, name, species, age, breed, adoptionStatus);
    }

    @Override
    public String toString() {
        return displayDetails();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return petId == pet.petId;
    }

    public static void updateIdCounter(int maxId) {
        idCounter.set(Math.max(idCounter.get(), maxId));
    }
}
