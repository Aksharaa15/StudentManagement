import java.util.*;
class ATM {
    int balance = 1000;
    Scanner sc = new Scanner(System.in);

    void deposit() {
        System.out.print("Enter amount: ");
        int amt = sc.nextInt();
        balance += amt;
    }

    void withdraw() {
        System.out.print("Enter amount: ");
        int amt = sc.nextInt();

        if (amt <= balance) {
            balance -= amt;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    void checkBalance() {
        System.out.println("Balance: " + balance);
    }
}
