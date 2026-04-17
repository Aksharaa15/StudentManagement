import java.util.*;

class Booking {
    String name;
    int seatNo;

    Booking(String name, int seatNo) {
        this.name = name;
        this.seatNo = seatNo;
    }
}

public class TheatreBooking {

    static boolean[] seats = new boolean[10];
    static ArrayList<Booking> bookings = new ArrayList<>();
    static int pricePerSeat = 150;

    static Scanner sc = new Scanner(System.in);

    static void showSeats() {
        System.out.println("\nSeat Status:");
        for (int i = 0; i < seats.length; i++) {
            System.out.println("Seat " + (i + 1) + ": " + (seats[i] ? "Booked" : "Available"));
        }
    }

    static void bookTicket() {
        System.out.print("Enter your name: ");
        String name = sc.next();

        System.out.print("Enter seat number (1-10): ");
        int seat = sc.nextInt();

        if (seat < 1 || seat > 10) {
            System.out.println("Invalid seat!");
            return;
        }

        if (!seats[seat - 1]) {
            seats[seat - 1] = true;
            bookings.add(new Booking(name, seat));
            System.out.println("Ticket booked! Price: ₹" + pricePerSeat);
        } else {
            System.out.println("Seat already booked!");
        }
    }

    static void cancelTicket() {
        System.out.print("Enter seat number to cancel: ");
        int seat = sc.nextInt();

        if (seats[seat - 1]) {
            seats[seat - 1] = false;

            bookings.removeIf(b -> b.seatNo == seat);

            System.out.println("Booking cancelled!");
        } else {
            System.out.println("Seat already free");
        }
    }

    static void showBookings() {
        System.out.println("\n--- Booking Details ---");
        for (Booking b : bookings) {
            System.out.println("Name: " + b.name + " | Seat: " + b.seatNo);
        }
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- Theatre Booking ---");
            System.out.println("1. Show Seats");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. View Bookings");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: showSeats(); break;
                case 2: bookTicket(); break;
                case 3: cancelTicket(); break;
                case 4: showBookings(); break;
                case 5: return;
                default: System.out.println("Invalid choice");
            }
        }
    }
}
