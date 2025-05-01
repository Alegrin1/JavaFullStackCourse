import java.util.List;

public class AdoptionApp {
    public static void main(String[] args) {
        PetAdoptionCenter center = new PetAdoptionCenter();

        //Initial Setup & Adding Pets
        if (center.listAllPets().isEmpty()) {
            center.addPet(new Dog("Brillos", 3, "Golden Retriever", "Large"));
            center.addPet(new Cat("Negro", 2, "Siamese", true));
            center.addPet(new Dog("Salchichon", 5, "Beagle", "Medium"));
            center.addPet(new Bird("Pollo", 1, "Parrot", true));
            center.addPet(new Cat("Noche", 4, "Domestic Shorthair", false));
        }

        // Display available pets
        List<Pet> availablePets = center.listAvailablePets();
        if (availablePets.isEmpty()) {
            System.out.println("No pets available for adoption currently.");
        } else {
            availablePets.forEach(System.out::println);
        }

        //Registering Adopters
        try {
            center.findAdopterById(1);
            System.out.println("Adopter Juan already exists (loaded).");
        } catch (AdopterNotFoundException e) {
            center.addAdopter(new Adopter("Juan Angeles", "juan@email.com"));
        }
        try {
            center.findAdopterById(2); // Check if adopter 2 exists
            System.out.println("Adopter Carmen already exists (loaded).");
        } catch (AdopterNotFoundException e) {
            center.addAdopter(new Adopter("Carmen", "555-1234"));
        }

        center.listAllAdopters().forEach(System.out::println);


        // Adoption Process
        try {
            int adopterAliceId = 1;
            int petBuddyId = 1;
            int adopterBobId = 2;
            int petWhiskersId = 2;

            center.processAdoption(adopterAliceId, petBuddyId);
            center.processAdoption(adopterBobId, petWhiskersId);

        } catch (PetNotFoundException | AdopterNotFoundException | AdoptionException e) {
            System.err.println("Adoption Error: " + e.getMessage());
        }

        center.listAvailablePets().forEach(System.out::println);
        center.listAllAdopters().forEach(System.out::println);


        // Handling Errors
        try {
            center.processAdoption(2, 1);
        } catch (PetNotFoundException | AdopterNotFoundException | AdoptionException e) {
            System.err.println("Caught Expected Error: " + e.getMessage());
        }

        try {
            center.processAdoption(1, 999);
        } catch (PetNotFoundException | AdopterNotFoundException | AdoptionException e) {
            System.err.println("Caught Expected Error: " + e.getMessage());
        }

        try {
            System.out.println("\nAttempting to find non-existent adopter (ID 99):");
            center.findAdopterById(99);
        } catch (AdopterNotFoundException e) {
            System.err.println("Caught Expected Error: " + e.getMessage());
        }


        center.searchPetsBySpecies("Dog").forEach(System.out::println);
        center.searchPetsByAge(1, 3).forEach(System.out::println);

        System.out.println("\nSearching for pets with breed 'Siamese':");
        center.searchPetsByBreed("Siamese").forEach(System.out::println);


        //Saving Data
        center.saveData();
    }
}