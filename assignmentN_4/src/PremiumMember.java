public class PremiumMember extends Member{

    public PremiumMember(String name) {
        super(name);
    }

    @Override
    public boolean addBorrowedBook(Book b) {
        this.getBorrowedBooks().add(b);
        return true;
    }
}
