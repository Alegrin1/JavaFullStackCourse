import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Adopter implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private static final AtomicInteger idCounter = new AtomicInteger(0);

    private int adopterId;
    private String name;
    private String contactInfo;
    private List<Pet> adoptedPets;

    public Adopter(String name, String contactInfo) {
        this.adopterId = idCounter.incrementAndGet();
        this.name = name;
        this.contactInfo = contactInfo;
        this.adoptedPets = new ArrayList<>();
    }

    public int getAdopterId() { return adopterId; }
    public String getName() { return name; }
    public String getContactInfo() { return contactInfo; }
    public List<Pet> getAdoptedPets() { return Collections.unmodifiableList(adoptedPets); } // Return immutable view


    public void addAdoptedPet(Pet pet) {
        if (pet != null && !adoptedPets.contains(pet)) {
            this.adoptedPets.add(pet);
        }
    }

    @Override
    public String toString() {
        String adoptedPetNames = adoptedPets.stream()
                .map(Pet::getName)
                .collect(Collectors.joining(", "));
        if (adoptedPetNames.isEmpty()) {
            adoptedPetNames = "None";
        }
        return String.format("Adopter ID: %d, Name: %s, Contact: %s, Adopted Pets: [%s]",
                adopterId, name, contactInfo, adoptedPetNames);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adopter adopter = (Adopter) o;
        return adopterId == adopter.adopterId;
    }

    public static void updateIdCounter(int maxId) {
        idCounter.set(Math.max(idCounter.get(), maxId));
    }
}