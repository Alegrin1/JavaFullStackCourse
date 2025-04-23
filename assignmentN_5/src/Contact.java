public class Contact {
    private final int contactId;
    private String name;
    private String phoneNumber;
    private String contactType;
    private String email;

    private static int lastId;

    public Contact(String name, String phoneNumber, String contactType, String email) {
        this.contactId = ++lastId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.contactType = contactType;
        this.email = email;
    }

    public int getContactId() {
        return contactId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getContactType() {
        return contactType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getLastId() {
        return lastId;
    }

    public static void setLastId(int lastId) {
        Contact.lastId = lastId;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }
}
