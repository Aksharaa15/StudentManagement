import java.util.*;
class Student {
    int id;
    String name;
    int age;
    String course;
    int marks1, marks2, marks3;
    int total;
    double average;
    String grade;
    Student(int id, String name, int age, String course,
            int m1, int m2, int m3) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.marks1 = m1;
        this.marks2 = m2;
        this.marks3 = m3;
        calculateResult();
    }
    void calculateResult() {
        total = marks1 + marks2 + marks3;
        average = total / 3.0;
        if (average >= 90) grade = "A+";
        else if (average >= 75) grade = "A";
        else if (average >= 60) grade = "B";
        else if (average >= 50) grade = "C";
        else grade = "Fail";
    }
    void display() {
        System.out.println("\nID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks1 + ", " + marks2 + ", " + marks3);
        System.out.println("Total: " + total);
        System.out.println("Average: " + average);
        System.out.println("Grade: " + grade);
        System.out.println("-----------------------------");
    }
}
public class StudentManagementSystem {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: searchStudent(); break;
                case 4: deleteStudent(); break;
                case 5: return;
                default: System.out.println("Invalid choice!");
            }
        }
    }
    static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Course: ");
        String course = sc.nextLine();
        System.out.print("Enter Marks for 3 Subjects:\n");
        System.out.print("Subject 1: ");
        int m1 = sc.nextInt();
        System.out.print("Subject 2: ");
        int m2 = sc.nextInt();
        System.out.print("Subject 3: ");
        int m3 = sc.nextInt();
        students.add(new Student(id, name, age, course, m1, m2, m3));
        System.out.println("Student added successfully!");
    }
    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No records found!");
            return;
        }
        for (Student s : students) {
            s.display();
        }
    }
    static void searchStudent() {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.id == id) {
                s.display();
                return;
            }
        }
        System.out.println("Student not found!");
    }

    static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        Iterator<Student> it = students.iterator();

        while (it.hasNext()) {
            Student s = it.next();
            if (s.id == id) {
                it.remove();
                System.out.println("Student deleted!");
                return;
            }
        }
        System.out.println("Student not found!");
    }
}
