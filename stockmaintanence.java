import java.util.*;

class Item {
    int id;
    String name;
    int quantity;

    Item(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }
}

class Stock {
    ArrayList<Item> items = new ArrayList<>();

    void addItem(int id, String name, int qty) {
        items.add(new Item(id, name, qty));
    }

    void updateStock(int id, int qty) {
        for (Item i : items) {
            if (i.id == id) {
                i.quantity += qty;
            }
        }
    }

    void display() {
        for (Item i : items) {
            System.out.println(i.id + " " + i.name + " Qty: " + i.quantity);
        }
    }
}
