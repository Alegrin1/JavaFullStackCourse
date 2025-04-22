public class EBook extends Book{

    private String fileFormat;
    private double fileSize;

    public EBook(String title, String author, String isbn, boolean availability, String fileFormat, double fileSize) {
        super(title, author, isbn, availability);
        setFileFormat(fileFormat);
        setFileSize(fileSize);
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        if (fileSize >= 0) {
            this.fileSize = fileSize;
        } else {
            System.out.println("Error: File size cannot be negative.");
        }
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        if (fileFormat != null && !fileFormat.trim().isEmpty()) {
            this.fileFormat = fileFormat;
        } else {
            System.out.println("Error: File format cannot be null or empty.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Format: " + fileFormat + ", Size: " + fileSize + "MB";
    }
}
