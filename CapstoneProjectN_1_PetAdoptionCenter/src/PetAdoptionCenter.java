import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PetAdoptionCenter {
    private Map<Integer, Pet> pets;
    private Map<Integer, Adopter> adopters;
    private String petsFile = "pets.dat";
    private String adoptersFile = "adopters.dat";

    public PetAdoptionCenter() {
        pets = new HashMap<>();
        adopters = new HashMap<>();
        loadData();
    }

    public void addPet(Pet pet) {
        if (pet != null && !pets.containsKey(pet.getPetId())) {
            pets.put(pet.getPetId(), pet);
            System.out.println("Pet added: " + pet.getName());
        } else if (pet != null) {
            System.out.println("Error: Pet with ID " + pet.getPetId() + " already exists.");
        }
    }

    public Pet findPetById(int petId) throws PetNotFoundException {
        Pet pet = pets.get(petId);
        if (pet == null) {
            throw new PetNotFoundException("Pet with ID " + petId + " not found.");
        }
        return pet;
    }

    public void updatePetInfo(int petId, String name, int age) throws PetNotFoundException {
        Pet pet = findPetById(petId);
        pet.setName(name);
        pet.setAge(age);
        System.out.println("Pet info updated: " + pet.getName());
    }

    public void removePet(int petId) throws PetNotFoundException {
        if (pets.remove(petId) == null) {
            throw new PetNotFoundException("Could not remove. Pet with ID " + petId + " not found.");
        }
        System.out.println("Pet with ID " + petId + " removed.");
    }

    public List<Pet> listAvailablePets() {
        return pets.values().stream()
                .filter(Pet::isAdoptable)
                .collect(Collectors.toList());
    }

    public List<Pet> listAllPets() {
        return new ArrayList<>(pets.values());
    }

    public void addAdopter(Adopter adopter) {
        if (adopter != null && !adopters.containsKey(adopter.getAdopterId())) {
            adopters.put(adopter.getAdopterId(), adopter);
            System.out.println("Adopter added: " + adopter.getName());
        } else if (adopter != null) {
            System.out.println("Error: Adopter with ID " + adopter.getAdopterId() + " already exists.");
        }
    }

    public Adopter findAdopterById(int adopterId) throws AdopterNotFoundException {
        Adopter adopter = adopters.get(adopterId);
        if (adopter == null) {
            throw new AdopterNotFoundException("Adopter with ID " + adopterId + " not found.");
        }
        return adopter;
    }

    public List<Adopter> listAllAdopters() {
        return new ArrayList<>(adopters.values());
    }

    public void processAdoption(int adopterId, int petId) throws PetNotFoundException, AdopterNotFoundException, AdoptionException {
        Adopter adopter = findAdopterById(adopterId);
        Pet pet = findPetById(petId);

        if (!pet.isAdoptable()) {
            throw new AdoptionException("Adoption failed: Pet '" + pet.getName() + "' (ID: " + petId + ") is not available for adoption (Status: " + pet.getAdoptionStatus() + ").");
        }

        pet.markAdopted();

        adopter.addAdoptedPet(pet);

        System.out.println("Success: " + adopter.getName() + " adopted " + pet.getName() + "!");
    }

    public List<Pet> searchPetsBySpecies(String species) {
        return pets.values().stream()
                .filter(pet -> pet.getSpecies().equalsIgnoreCase(species))
                .collect(Collectors.toList());
    }

    public List<Pet> searchPetsByAge(int minAge, int maxAge) {
        return pets.values().stream()
                .filter(pet -> pet.getAge() >= minAge && pet.getAge() <= maxAge)
                .collect(Collectors.toList());
    }

    public List<Pet> searchPetsByBreed(String breed) {
        return pets.values().stream()
                .filter(pet -> pet.getBreed().equalsIgnoreCase(breed))
                .collect(Collectors.toList());
    }

    public void saveData() {
        saveMapToFile(pets, petsFile);
        saveMapToFile(adopters, adoptersFile);
        System.out.println("Data saved successfully.");
    }

    private <K, V extends Serializable> void saveMapToFile(Map<K, V> map, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(map);
        } catch (IOException e) {
            System.err.println("Error saving data to " + filename + ": " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadData() {
        pets = loadMapFromFile(petsFile);
        adopters = loadMapFromFile(adoptersFile);

        int maxPetId = pets.keySet().stream().max(Integer::compare).orElse(0);
        int maxAdopterId = adopters.keySet().stream().max(Integer::compare).orElse(0);
        Pet.updateIdCounter(maxPetId);
        Adopter.updateIdCounter(maxAdopterId);

        System.out.println("Data loaded successfully.");
    }

    private <K, V extends Serializable> Map<K, V> loadMapFromFile(String filename) {
        Map<K, V> map = new HashMap<>();
        File file = new File(filename);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                Object readObject = ois.readObject();
                if (readObject instanceof Map) {
                    map = (Map<K, V>) readObject;
                } else {
                    System.err.println("Error loading data from " + filename + ": Unexpected object type found.");
                }
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error loading data from " + filename + ": " + e.getMessage());
                return new HashMap<>();
            }
        } else {
            System.out.println("Data file " + filename + " not found. Starting with empty data.");
        }
        return map;
    }
}
