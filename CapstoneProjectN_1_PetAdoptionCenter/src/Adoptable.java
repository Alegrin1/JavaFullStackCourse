public interface Adoptable {
    boolean isAdoptable();
    void markAdopted();
    void markAvailable();
}