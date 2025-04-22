public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean availability;

    public Book(String title, String author, String isbn, boolean availability) {
        setTitle(title);
        setAuthor(author);
        setIsbn(isbn);
        this.availability = availability;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title != null && !title.trim().isEmpty()) {
            this.title = title;
        } else {
            System.out.println("Error: Title cannot be null or empty.");
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author != null && !author.trim().isEmpty()) {
            this.author = author;
        } else {
            System.out.println("Error: Author cannot be null or empty.");
        }
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        if (isbn != null && !isbn.trim().isEmpty()) {
            this.isbn = isbn;
        } else {
            System.out.println("Error: ISBN cannot be null or empty.");
        }
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Book: " + title + " by " + author + " (ISBN: " + isbn + ")";
    }
}
