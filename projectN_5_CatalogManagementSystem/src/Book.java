public class Book {
    private final int bookID;
    private String title;
    private String author;
    private String genre;
    private boolean availability;
    
    private static int lastID = 0;

    public Book(String title, String author, String genre, boolean availability) {
        this.bookID = ++lastID;
        
        setTitle(title);
        setAuthor(author);
        setGenre(genre);
        
        this.availability = availability;
    }

    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: Title cannot be null or empty.");
        }
        this.title = title.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: Author cannot be null or empty.");
        }
        this.author = author.trim();
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        if (genre == null || genre.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: Genre cannot be null or empty.");
        }
        this.genre = genre.trim();
    }


    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "ID: " + bookID +
                ", Title: '" + title + '\'' +
                ", Author: '" + author + '\'' +
                ", Genre: '" + genre + '\'' +
                ", Available: " + (availability ? "Yes" : "No");
    }
}
