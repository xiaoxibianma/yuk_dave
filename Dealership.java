/**
 * The Dealership class include car instances, salesPerson instances, and manager instances
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Dealership {

    private ArrayList <SalesPerson> sp;
    private ArrayList<Car> cars;
    private Manager mg;
    private static int numOfCarSold = 0;


    //Constructor
    public Dealership(Manager m)
    {
        this.cars= new ArrayList <> ();
        this.sp = new ArrayList <> ();
        this.mg = m;
    }

    // add a car to dealership
    public void addCar(Car another)
    {
        cars.add(another);
    }

    // add a sales person to dealership
    public void addSalesPerson(SalesPerson s)
    {
        sp.add(s);
    }

    // delete  a sales person
    public void removeSalesPerson(SalesPerson s)
    {
        sp.remove(s);
    }

    // print how many car sold by specific sales person
    public void carSold (SalesPerson s)
    {
        System.out.println(s.getNumOfSold());

    }

    // remove a car from dealer could be sold or remove
    // return true if the car in dealership
    // return false if the car not int dealership
    public boolean removeCar( Car aCar)
    {
        for(int i = 0; i < cars.size(); i++){
            if(aCar.equals(cars.get(i))){
                cars.remove(aCar);
                numOfCarSold++;
                return true;
            }
        }
        return false;
    }

    //count how many car total sold in this dealership
    public void getTotleSold(){
        System.out.println(numOfCarSold);
    }

    // check whose bonus is the most
    public  SalesPerson getPersonOfTheMonth() {
        int[] array = new int[sp.size()];
        for (int i = 0; i < sp.size(); i++) {
            array[i] = sp.get(i).getBonus();
        }
        Arrays.sort(array);
        int max = array[array.length - 1];

        for (int j = 0; j < sp.size(); j++) {
            if (sp.get(j).getBonus() == max) {
                return sp.get(j);
            }
        }
        return null;
    }

    //print dealership information
    public String toString()
    {
        return "Manager: " + mg.toString() + ". There are total " + sp.size() + " Sales person " +
                " ,and " + cars.size() + " cars in dealership." + " The employee who has best performance is " +
                getPersonOfTheMonth().getFirstName() + ".";
    }
}
