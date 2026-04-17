import java.util.*;
class Book {
    int id;
    String name;
    boolean issued;

    Book(int id, String name) {
        this.id = id;
        this.name = name;
        this.issued = false;
    }
}

class Library {
    ArrayList<Book> books = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    void addBook() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Book Name: ");
        String name = sc.nextLine();

        books.add(new Book(id, name));
    }

    void issueBook() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id && !b.issued) {
                b.issued = true;
                System.out.println("Book Issued");
                return;
            }
        }
        System.out.println("Not Available");
    }

    void display() {
        for (Book b : books) {
            System.out.println(b.id + " " + b.name + " Issued: " + b.issued);
        }
    }
}
