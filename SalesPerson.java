public class SalesPerson {
    private String firstName;
    private String lastName;
    private int bonus;
    private String address;
    private int dateOfHiring;
    private int numOfSold;

    public SalesPerson(String firstName, String lastName){
        this(firstName, lastName, 0, "Unknown", 00);
    }

    public SalesPerson(String firstName, String lastName, int bonus, String address, int dateOfHiring) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bonus = bonus;
        this.address = address;
        this.dateOfHiring = dateOfHiring;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBonus() {
        return bonus;
    }

    // as a sales person sold a car, his bonus will increase
    // could be see as commission
    public void setBonus(int bonus) {
        this.bonus += bonus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDateOfHiring() {
        return dateOfHiring;
    }

    public void setDateOfHiring(int dateOfHiring) {
        this.dateOfHiring = dateOfHiring;
    }

    // count how many car sold
    public int getNumOfSold(){
        return this.numOfSold;
    }

    // if the car not been sold remove the car
    public void sold (Dealership dp, Car c){
        if(dp.removeCar(c)){
            setBonus((int)(c.getPrice() * 0.05));
            dp.removeCar(c);
            numOfSold++;
        }
    }


    @Override
    public String toString() {
        return "Employee " + this.firstName + " " + this.lastName + "'s address: " + this.address +
                " and hiring by " + this.dateOfHiring + " and bonus is " + this.bonus;
    }
}
