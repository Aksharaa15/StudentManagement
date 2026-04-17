import java.util.*;
class Room {
    int roomNo;
    boolean booked;

    Room(int roomNo) {
        this.roomNo = roomNo;
        this.booked = false;
    }
}

class Hotel {
    ArrayList<Room> rooms = new ArrayList<>();

    Hotel() {
        for (int i = 1; i <= 5; i++) {
            rooms.add(new Room(i));
        }
    }

    void bookRoom(int no) {
        for (Room r : rooms) {
            if (r.roomNo == no && !r.booked) {
                r.booked = true;
                System.out.println("Room booked");
                return;
            }
        }
        System.out.println("Not available");
    }

    void display() {
        for (Room r : rooms) {
            System.out.println("Room " + r.roomNo + " Booked: " + r.booked);
        }
    }
}
