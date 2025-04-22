import java.util.ArrayList;

public class Member {
    private final int memberId;
    private final ArrayList<Book> borrowedBooks;
    private String name;

    private static int lastId;

    public Member(String name) {
        this.memberId = ++lastId;
        this.borrowedBooks = new ArrayList<Book>();
        setName(name);
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Error: Member name cannot be null or empty.");
        }
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public boolean addBorrowedBook(Book b){
        if (this.borrowedBooks.size() > 3) {
            return false;
        }
        else {
            this.borrowedBooks.add(b);
            return true;
        }

    }

    public void removedBorrowedBook(Book b) {
        this.borrowedBooks.remove(b);
    }
}
