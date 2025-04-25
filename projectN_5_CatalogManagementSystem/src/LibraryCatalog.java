import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

class LibraryCatalog {
    private final HashMap<Integer, Book> catalog;

    public LibraryCatalog() {
        this.catalog = new HashMap<>();
    }

    public void addBook(Book book) {
        if (book != null) {
            catalog.put(book.getBookID(), book);
            System.out.println("Book added successfully: " + book.getTitle());
        } else {
            System.out.println("Error: Cannot add a null book.");
        }
    }

    public Book findBookById(int bookID) {
        return catalog.get(bookID);
    }

    public boolean updateBook(int bookID, String title, String author, String genre, Boolean availability) {
        Book bookToUpdate = findBookById(bookID);
        if (bookToUpdate != null) {
            try {
                if (title != null) {
                    bookToUpdate.setTitle(title);
                }
                if (author != null) {
                    bookToUpdate.setAuthor(author);
                }
                if (genre != null) {
                    bookToUpdate.setGenre(genre);
                }
                if (availability != null) {
                    bookToUpdate.setAvailability(availability);
                }
                System.out.println("Book ID " + bookID + " updated successfully.");
                return true;
            } catch (IllegalArgumentException e) {
                System.err.println("Update failed: " + e.getMessage());
                return false;
            }
        } else {
            System.out.println("Error: Book with ID " + bookID + " not found.");
            return false;
        }
    }

    public ArrayList<Book> searchBooks(String query) {
        ArrayList<Book> results = new ArrayList<>();
        if (query == null || query.trim().isEmpty()) {
            System.out.println("Search query cannot be empty.");
            return results;
        }
        String lowerCaseQuery = query.toLowerCase().trim();
        // Iterate through the values (Book objects) in the HashMap
        for (Book book : catalog.values()) {
            if (book.getTitle().toLowerCase().contains(lowerCaseQuery) ||
                    book.getAuthor().toLowerCase().contains(lowerCaseQuery) ||
                    book.getGenre().toLowerCase().contains(lowerCaseQuery)) {
                results.add(book);
            }
        }
        return results;
    }

    public Collection<Book> getAllBooks() {
        if (catalog.isEmpty()) {
            return new ArrayList<>();
        }
        return catalog.values();
    }
}