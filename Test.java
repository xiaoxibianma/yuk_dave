public class Test {
    public static void main(String[] args) {

        //create a manager, also associate with create a dealership.
        Manager dave = new Manager("Dave","Yang");


        //create 7 salesperson objects
        SalesPerson p1 = new SalesPerson("p1FirstName","p1LastName");
        SalesPerson p2 = new SalesPerson("p2FirstName","p2LastName");
        SalesPerson p3 = new SalesPerson("p3FirstName","p3LastName");
        SalesPerson p4 = new SalesPerson("p4FirstName","p4LastName");
        SalesPerson p5 = new SalesPerson("p5FirstName","p5LastName");
        SalesPerson p6 = new SalesPerson("p6FirstName","p6LastName");
        SalesPerson p7 = new SalesPerson("p7FirstName","p7LastName");

        //Create 13 new Car object
        Car c1 = new Car("Acura", 25000,2017,"2324232342r");
        Car c2 = new Car("Acura", 25400,2017,"2324432342r");
        Car c3 = new Car("Benz", 35000,2017,"275442r");
        Car c4 = new Car("Benz", 45000,2017,"2324134342r");
        Car c5 = new Car("Toyota", 25000,2017,"2555532342r");
        Car c6 = new Car("Toyota", 27800,2017,"123432342r");
        Car c7 = new Car("Honda", 25000,2017,"6666232342r");
        Car c8 = new Car("Honda", 21000,2017,"2999932342r");
        Car c9 = new Car("Jeep", 45000,2017,"23123412342r");
        Car c10 = new Car("Jeep", 55000,2017,"13413333332342r");
        Car c11 = new Car("Jeep", 65000,2017,"23u83432342r");
        Car c12 = new Car("Ford", 35400,2017,"2fudhf38232342r");
        Car c13 = new Car("Ford", 30000,2017,"2323413h342r");

        //Create one Dealership and associates manager with it
        Dealership dp = new Dealership(dave);

        // Use Dealership to add SalesPerson and Cars
        dp.addCar(c1);
        dp.addCar(c2);
        dp.addCar(c3);
        dp.addCar(c4);
        dp.addCar(c5);
        dp.addCar(c6);
        dp.addCar(c7);
        dp.addCar(c8);
        dp.addCar(c9);
        dp.addCar(c10);
        dp.addCar(c11);
        dp.addCar(c12);
        dp.addCar(c13);

        dp.addSalesPerson(p1);
        dp.addSalesPerson(p2);
        dp.addSalesPerson(p3);
        dp.addSalesPerson(p4);
        dp.addSalesPerson(p5);
        dp.addSalesPerson(p6);
        dp.addSalesPerson(p7);

        //now test your program for all the method that was given in Dealership

        p1.sold(dp,c1);
        p2.sold(dp,c1);
        p4.sold(dp,c8);
        p2.sold(dp,c6);
        p2.sold(dp,c3);
        p1.sold(dp,c4);
        p2.sold(dp,c7);
        p3.sold(dp,c9);
        p3.sold(dp,c12);


        System.out.println(dp.getPersonOfTheMonth());

        dp.carSold(p1);
        dp.getTotleSold();

        System.out.println(dp.toString());

        ;
    }
}
