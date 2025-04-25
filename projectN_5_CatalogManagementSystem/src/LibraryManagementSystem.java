import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {

    private static final Scanner scanner = new Scanner(System.in);
    private static final LibraryCatalog catalog = new LibraryCatalog();

    public static void main(String[] args) {
        int choice, id;
        Book book;

        do {
            System.out.println("Library catalog management system");
            System.out.println("1. Add new book");
            System.out.println("2. View all books");
            System.out.println("3. Find book by ID");
            System.out.println("4. Update book details");
            System.out.println("5. Search books (by title/author/genre)");
            System.out.println("6. Check book availability by ID");
            System.out.println("0. Exit");
            choice = readIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    try {
                        String title = readStringInput("Enter title: ");
                        String author = readStringInput("Enter author: ");
                        String genre = readStringInput("Enter genre: ");
                        boolean available = readBooleanInput("Is the book available? (yes/no): ");

                        Book newBook = new Book(title, author, genre, available);
                        catalog.addBook(newBook);

                    } catch (IllegalArgumentException e) {
                        System.err.println("Error adding book: " + e.getMessage());
                        System.out.println("Please try again.");
                    } catch (Exception e) {
                        System.err.println("An unexpected error occurred: " + e.getMessage());
                    }
                    break;
                case 2:
                    Collection<Book> books = catalog.getAllBooks();
                    if (books.isEmpty()) {
                        System.out.println("The catalog is currently empty.");
                    } else {
                        for (Book b : books) {
                            System.out.println(b);
                        }
                    }
                    break;
                case 3:
                    id = readIntInput("Enter book ID to find: ");
                    book = catalog.findBookById(id);
                    if (book != null) {
                        System.out.println("Book found:");
                        System.out.println(book);
                    } else {
                        System.out.println("Book with ID " + id + " not found.");
                    }
                    break;
                case 4:
                    id = readIntInput("Enter book ID to update: ");
                    book = catalog.findBookById(id);

                    if (book == null) {
                        System.out.println("Book with ID " + id + " not found. Cannot update.");
                        return;
                    }

                    System.out.println("Found book: " + book);
                    System.out.println("Enter new details (leave blank to keep current value):");

                    try {
                        String newTitle = readOptionalStringInput("New Title: ");
                        String newAuthor = readOptionalStringInput("New Author: ");
                        String newGenre = readOptionalStringInput("New Genre: ");
                        Boolean newAvailability = readOptionalBooleanInput("New Availability (yes/no/leave blank): ");

                        catalog.updateBook(id,
                                newTitle.isEmpty() ? null : newTitle,
                                newAuthor.isEmpty() ? null : newAuthor,
                                newGenre.isEmpty() ? null : newGenre,
                                newAvailability);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Update aborted due to invalid input.");
                    } catch (Exception e) {
                        System.err.println("An unexpected error occurred during update: " + e.getMessage());
                    }
                    break;
                case 5:
                    String query = readStringInput("Enter search term (title/author/genre): ");
                    List<Book> results = catalog.searchBooks(query);

                    if (results.isEmpty()) {
                        System.out.println("No books found matching '" + query + "'.");
                    } else {
                        System.out.println("Found " + results.size() + " book(s) matching '" + query + "':");
                        for (Book b : results) {
                            System.out.println(b);
                        }
                    }
                    break;
                case 6:
                    id = readIntInput("Enter book ID to check: ");
                    book = catalog.findBookById(id);
                    if (book != null) {
                        System.out.println("Book: '" + book.getTitle() + "' by " + book.getAuthor());
                        System.out.println("Availability: " + (book.isAvailable() ? "Available" : "Not Available"));
                    } else {
                        System.out.println("Book with ID " + id + " not found.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();

        } while (choice != 0);
        scanner.close();
    }

    private static String readStringInput(String prompt) {
        String input;

        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println("Input cannot be empty. Please try again");
            }
        }
    }

    private static String readOptionalStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static int readIntInput(String prompt) {
        int input = -1; // Default invalid value
        boolean validInput = false;
        while (!validInput) {
            System.out.print(prompt);
            try {
                input = Integer.parseInt(scanner.nextLine()); // Read line and parse
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number");
            }
        }
        return input;
    }

    private static boolean readBooleanInput(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("yes") || input.equals("y")) {
                return true;
            } else if (input.equals("no") || input.equals("n")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'");
            }
        }
    }

    private static Boolean readOptionalBooleanInput(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim().toLowerCase();
        if (input.equals("yes") || input.equals("y")) {
            return Boolean.TRUE;
        } else if (input.equals("no") || input.equals("n")) {
            return Boolean.FALSE;
        } else if (input.isEmpty()) {
            return null;
        } else {
            System.out.println("Input not recognized as 'yes' or 'no'. Assuming no change");
            return null;
        }
    }
}