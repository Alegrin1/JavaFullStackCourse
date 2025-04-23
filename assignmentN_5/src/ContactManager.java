import java.util.Scanner;

public class ContactManager {
    public static void main(String[] args) {
        ContactDirectory directory = new ContactDirectory();
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add new contact");
            System.out.println("2. Register a new contact type");
            System.out.println("3. Display all contact types");
            System.out.println("4. Search contact by name");
            System.out.println("5. Update contact information");
            System.out.println("6. Display all contacts sorted by name");
            System.out.println("7. Display all contacts sorted by ID");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            switch (Integer.parseInt(s.nextLine())) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = s.nextLine();

                    System.out.print("Enter phone number: ");
                    String phone = s.nextLine();

                    System.out.print("Enter contact type: ");
                    String type = s.nextLine();

                    System.out.print("Enter email: ");
                    String email = s.nextLine();

                    directory.addContact(new Contact(name, phone, type, email));
                    break;

                case 2:
                    System.out.print("Enter new contact type to register: ");
                    directory.createContactType(s.nextLine());
                    break;

                case 3:
                    directory.displayContactTypes();
                    break;

                case 4:
                    System.out.print("Enter name to search: ");
                    directory.getContactInfoByName(s.nextLine());
                    break;

                case 5:
                    System.out.print("Enter the name of the contact to update: ");
                    String updateName = s.nextLine();

                    System.out.print("Enter new phone number: ");
                    String newPhone = s.nextLine();

                    System.out.print("Enter new email: ");
                    String newEmail = s.nextLine();

                    directory.updateContact(updateName, newPhone, newEmail);
                    break;

                case 6:
                    directory.displayContactsByName();
                    break;

                case 7:
                    directory.displayContactsById();
                    break;

                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid");
            }
        }
    }
}
