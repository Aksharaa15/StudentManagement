import java.util.*;

class BillingSystem {
    String[] items = {"Rice", "Milk", "Bread", "Eggs"};
    int[] prices = {50, 30, 25, 10};

    Scanner sc = new Scanner(System.in);
    int total = 0;

    void showItems() {
        System.out.println("\n--- Items ---");
        for (int i = 0; i < items.length; i++) {
            System.out.println((i + 1) + ". " + items[i] + " - ₹" + prices[i]);
        }
    }

    void buyItem() {
        System.out.print("Enter item number: ");
        int choice = sc.nextInt();

        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();

        if (choice >= 1 && choice <= items.length) {
            int cost = prices[choice - 1] * qty;
            total += cost;
            System.out.println(items[choice - 1] + " added. Cost: ₹" + cost);
        } else {
            System.out.println("Invalid item!");
        }
    }

    void showBill() {
        System.out.println("Total Bill: ₹" + total);
    }

    public static void main(String[] args) {
        BillingSystem b = new BillingSystem();

        while (true) {
            System.out.println("\n--- BILLING SYSTEM ---");
            System.out.println("1. Show Items");
            System.out.println("2. Buy Item");
            System.out.println("3. Show Bill");
            System.out.println("4. Exit");

            int ch = b.sc.nextInt();

            switch (ch) {
                case 1: b.showItems(); break;
                case 2: b.buyItem(); break;
                case 3: b.showBill(); break;
                case 4: return;
                default: System.out.println("Invalid choice");
            }
        }
    }
}
