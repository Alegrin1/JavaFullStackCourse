import java.util.ArrayList;

public class LibraryManagementSystem {
    private static final Library library = new Library();

    public static void main(String[] args) {
        // Adding books and eBooks
        System.out.println("--- Adding Books ---");
        Book book1 = new Book("The Lord of the Rings", "J.R.R. Tolkien", "978-0618260274", true);
        EBook ebook1 = new EBook("Pride and Prejudice", "Jane Austen", "978-0141439518", true, "EPUB", 1.2);
        library.addBook(book1);
        library.addBook(ebook1);
        System.out.println("Book added: " + book1.getTitle());
        System.out.println("EBook added: " + ebook1.getTitle());
        displayAvailableBooks();
        System.out.println();

        // Registering members
        System.out.println("--- Registering Members ---");
        Member member1 = new Member("Juan Angeles");
        PremiumMember member2 = new PremiumMember("Carmen Santos");
        library.addMember(member1);
        library.addMember(member2);
        System.out.println("Member registered: " + member1.getName() + " (ID: " + member1.getMemberId() + ")");
        System.out.println("Premium member registered: " + member2.getName() + " (ID: " + member2.getMemberId() + ")");
        displayRegisteredMembers();
        System.out.println();

        // Borrowing books
        System.out.println("--- Borrowing Books ---");
        library.borrowingABook("The Lord of the Rings", member1.getMemberId());
        library.borrowingABook("Pride and Prejudice", member2.getMemberId());
        displayAvailableBooks();
        System.out.println();

        // Displaying member details with borrowed books
        System.out.println("--- Member Details ---");
        displayMemberDetails(member1.getMemberId());
        displayMemberDetails(member2.getMemberId());
        System.out.println();

        // Attempting to borrow an unavailable book
        System.out.println("--- Attempting to Borrow Unavailable Book ---");
        library.borrowingABook("The Lord of the Rings", member2.getMemberId());
        System.out.println();

        // Returning a book
        System.out.println("--- Returning a Book ---");
        library.returnBook("The Lord of the Rings", member1.getMemberId());
        displayAvailableBooks();
        displayMemberDetails(member1.getMemberId());
        System.out.println();
    }

    public static void displayAvailableBooks() {
        System.out.println("\n--- Available Books ---");
        boolean found = false;
        for (Book book : library.getBooks()) {
            if (book.isAvailability()) {
                System.out.println(book); // Assuming toString() is implemented in Book and EBook
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books currently available.");
        }
    }

    public static void displayRegisteredMembers() {
        System.out.println("\n--- Registered Members ---");
        if (library.getMembers().isEmpty()) {
            System.out.println("No members registered yet.");
            return;
        }
        for (Member member : library.getMembers()) {
            System.out.println(member.getName() + " (ID: " + member.getMemberId() + ")");
        }
    }

    public static void displayMemberDetails(int memberId) {
        Member member = null;
        for (Member m : library.getMembers()) {
            if (m.getMemberId() == memberId) {
                member = m;
                break;
            }
        }

        if (member != null) {
            System.out.println("Member ID: " + member.getMemberId());
            System.out.println("Name: " + member.getName());
            ArrayList<Book> borrowedBooks = member.getBorrowedBooks();
            if (!borrowedBooks.isEmpty()) {
                System.out.println("Borrowed Books:");
                for (Book book : borrowedBooks) {
                    System.out.println("- " + book.getTitle());
                }
            } else {
                System.out.println("No books currently borrowed.");
            }
        } else {
            System.out.println("Member with ID " + memberId + " not found.");
        }
    }
}