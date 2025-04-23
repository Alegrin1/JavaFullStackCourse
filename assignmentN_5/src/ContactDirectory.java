import java.util.*;

public class ContactDirectory {
    private final ArrayList<Contact> allContacts;
    private final HashSet<String> uniqueContactTypes;
    private final HashMap<String,Contact> contactsByName;

    public ContactDirectory() {
        this.allContacts = new ArrayList<>();
        this.contactsByName = new HashMap<>();
        this.uniqueContactTypes = new HashSet<>();
    }

    public void addContact(Contact c) {
        if (c != null && this.uniqueContactTypes.contains(c.getContactType())) {
            this.allContacts.add(c);
            this.contactsByName.put(c.getName(), c);
            this.uniqueContactTypes.add(c.getContactType());
        } else {
            System.out.println("Contact type '" + c.getContactType() + "' does not exist");
        }
    }

    public void updateContact(String name, String newPhoneNumber, String newEmail) {
        if (this.contactsByName.containsKey(name)) {
            Contact contact = this.contactsByName.get(name);
            contact.setPhoneNumber(newPhoneNumber);
            contact.setEmail(newEmail);

            this.contactsByName.put(name, contact);

            for (int i = 0; i < this.allContacts.size(); i++) {
                if (this.allContacts.get(i).getContactId() == contact.getContactId()) {
                    this.allContacts.set(i, contact);
                    break;
                }
            }
        } else {
            System.out.println("Contact with name '" + name + "' not found");
        }
    }

    public void displayContactsById() {
        ArrayList<Contact> sortedList = new ArrayList<>(allContacts);
        Collections.sort(sortedList, Comparator.comparingInt(Contact::getContactId));

        for (Contact contact : sortedList) {
            printContact(contact);
        }
    }

    public void displayContactsByName() {
        List<Contact> sortedList = new ArrayList<>(allContacts);
        Collections.sort(sortedList, Comparator.comparing(Contact::getName));

        for (Contact contact : sortedList) {
            printContact(contact);
        }
    }

    public void createContactType(String newType) {
        if (!uniqueContactTypes.contains(newType)) {
            uniqueContactTypes.add(newType);
            System.out.println("Contact type '" + newType + "' added");
        } else {
            System.out.println("Contact type '" + newType + "' already exists");
        }
    }

    public void displayContactTypes() {
        System.out.println("Unique contact types:");
        for (String type : uniqueContactTypes) {
            System.out.println("- " + type);
        }
    }

    public void getContactInfoByName(String name) {
        Contact contact = contactsByName.get(name);
        if (contact != null) {
            printContact(contact);
        } else {
            System.out.println("No contact found with name: " + name);
        }
    }

    private void printContact(Contact contact) {
        System.out.println("ID: " + contact.getContactId());
        System.out.println("Name: " + contact.getName());
        System.out.println("Phone: " + contact.getPhoneNumber());
        System.out.println("Email: " + contact.getEmail());
        System.out.println("Type: " + contact.getContactType());
    }
}
