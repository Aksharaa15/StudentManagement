import java.util.*;

class Passenger {
    String name;
    int seatNo;

    Passenger(String name, int seatNo) {
        this.name = name;
        this.seatNo = seatNo;
    }
}

public class BusBooking {

    static int totalSeats = 10;
    static boolean[] seats = new boolean[totalSeats];
    static ArrayList<Passenger> passengers = new ArrayList<>();
    static int price = 300;

    static Scanner sc = new Scanner(System.in);

    static void showSeats() {
        System.out.println("\nSeat Status:");
        for (int i = 0; i < totalSeats; i++) {
            System.out.println("Seat " + (i + 1) + ": " + (seats[i] ? "Booked" : "Available"));
        }
    }

    static void bookSeat() {
        System.out.print("Enter your name: ");
        String name = sc.next();

        System.out.print("Enter seat number: ");
        int seat = sc.nextInt();

        if (seat < 1 || seat > totalSeats) {
            System.out.println("Invalid seat!");
            return;
        }

        if (!seats[seat - 1]) {
            seats[seat - 1] = true;
            passengers.add(new Passenger(name, seat));
            System.out.println("Seat booked! Ticket Price: ₹" + price);
        } else {
            System.out.println("Seat already booked!");
        }
    }

    static void cancelSeat() {
        System.out.print("Enter seat number to cancel: ");
        int seat = sc.nextInt();

        if (seats[seat - 1]) {
            seats[seat - 1] = false;

            passengers.removeIf(p -> p.seatNo == seat);

            System.out.println("Booking cancelled!");
        } else {
            System.out.println("Seat already empty");
        }
    }

    static void showPassengers() {
        System.out.println("\n--- Passenger List ---");
        for (Passenger p : passengers) {
            System.out.println("Name: " + p.name + " | Seat: " + p.seatNo);
        }
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- Bus Booking ---");
            System.out.println("1. Show Seats");
            System.out.println("2. Book Seat");
            System.out.println("3. Cancel Seat");
            System.out.println("4. View Passengers");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: showSeats(); break;
                case 2: bookSeat(); break;
                case 3: cancelSeat(); break;
                case 4: showPassengers(); break;
                case 5: return;
                default: System.out.println("Invalid choice");
            }
        }
    }
}
