import java.util.*;

class Car {
    String name;
    int price;
    boolean rented;

    Car(String name, int price) {
        this.name = name;
        this.price = price;
        this.rented = false;
    }
}

public class CarRental {

    static ArrayList<Car> cars = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static {
        cars.add(new Car("Swift", 1000));
        cars.add(new Car("i20", 1200));
        cars.add(new Car("Innova", 2000));
    }

    static void showCars() {
        System.out.println("\n--- Cars ---");
        for (int i = 0; i < cars.size(); i++) {
            Car c = cars.get(i);
            System.out.println((i + 1) + ". " + c.name + 
                " ₹" + c.price + "/day | " + (c.rented ? "Rented" : "Available"));
        }
    }

    static void rentCar() {
        showCars();
        System.out.print("Select car: ");
        int ch = sc.nextInt();

        if (ch >= 1 && ch <= cars.size()) {
            Car c = cars.get(ch - 1);

            if (!c.rented) {
                System.out.print("Enter days: ");
                int days = sc.nextInt();

                int total = days * c.price;
                c.rented = true;

                System.out.println("Car rented! Total cost: ₹" + total);
            } else {
                System.out.println("Car already rented");
            }
        }
    }

    static void returnCar() {
        showCars();
        System.out.print("Select car to return: ");
        int ch = sc.nextInt();

        if (ch >= 1 && ch <= cars.size()) {
            cars.get(ch - 1).rented = false;
            System.out.println("Car returned");
        }
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- CAR RENTAL ---");
            System.out.println("1. Show Cars");
            System.out.println("2. Rent Car");
            System.out.println("3. Return Car");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: showCars(); break;
                case 2: rentCar(); break;
                case 3: returnCar(); break;
                case 4: return;
                default: System.out.println("Invalid choice");
            }
        }
    }
}
