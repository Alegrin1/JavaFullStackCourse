import java.util.ArrayList;

public class Library {
    private final ArrayList<Member> members;
    private final ArrayList<Book> books;

    public Library(){
        this.books = new ArrayList<Book>();
        this.members = new ArrayList<Member>();
    }

    public void addBook(Book b) {
        this.books.add(b);
    }

    public void addMember(Member m) {
        this.members.add(m);
    }

    public void borrowingABook(String bookName, int idUser) {
        Book bookToBorrow = null;
        Member personWhoBorrows = null;

        for(Book book : books) {
            if(book.getTitle().equalsIgnoreCase(bookName)) {
                if (book.isAvailability()) {
                    bookToBorrow = book;
                    break;
                } else {
                    System.out.println("\nBook in the library, but not available");
                    return;
                }
            }
        }

        if (bookToBorrow == null) {
            System.out.println("\nBook not found");
            return;
        }

        for (Member member : members) {
            if (member.getMemberId() == idUser) {
                personWhoBorrows = member;
                break;
            }
        }

        if (personWhoBorrows == null) {
            System.out.println("\nMember not found");
            return;
        }

        if(personWhoBorrows.addBorrowedBook(bookToBorrow)){
            bookToBorrow.setAvailability(false);
        }
        else {
            System.out.println("El usuario excede el numero de libros a prestar");
        }

    }

    public void returnBook(String bookName, int idUser) {
        Book bookToReturn = null;
        Member personWhoReturns = null;

        for(Book book : books) {
            if(book.getTitle().equalsIgnoreCase(bookName)) {
                if (!book.isAvailability()) {
                    bookToReturn = book;
                    break;
                } else {
                    System.out.println("\nBook in the library, but it was not borrowed");
                    return;
                }
            }
        }

        if (bookToReturn == null) {
            System.out.println("\nBook not found");
            return;
        }

        for (Member member : members) {
            if (member.getMemberId() == idUser) {
                personWhoReturns = member;
                break;
            }
        }

        if (personWhoReturns == null) {
            System.out.println("\nMember not found");
            return;
        }

        if (personWhoReturns.getBorrowedBooks().contains(bookToReturn)) {
            personWhoReturns.removedBorrowedBook(bookToReturn);
            bookToReturn.setAvailability(true);
        }
        else {
            System.out.println("\nMember and book exist, but user do not borrowed the book");
        }

    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }
}
