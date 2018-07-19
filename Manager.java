public class Manager {
    private String firstName;
    private String lastName;
    private String address;
    private int dateOfHiring;

    public Manager(String firstName, String lastName) {
        this(firstName, lastName, "Unknown", 00);

    }
    public Manager(String firstName, String lastName, String address,  int dateOfHiring) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.dateOfHiring = dateOfHiring;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDateOfHiring(int dateOfHiring) {
        this.dateOfHiring = dateOfHiring;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public int getDateOfHiring() {
        return dateOfHiring;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + "'s address: " + this.address +
                " and hiring by " + this.dateOfHiring;

    }
}
