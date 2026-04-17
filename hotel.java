import java.util.*;

class Patient {
    int id;
    String name;
    int age;
    String disease;
    String doctor;

    Patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
        this.doctor = "Not Assigned";
    }
}

public class HospitalManagement {

    static ArrayList<Patient> patients = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void addPatient() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();

        patients.add(new Patient(id, name, age, disease));
        System.out.println("Patient added successfully!");
    }

    static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found!");
            return;
        }

        for (Patient p : patients) {
            System.out.println("ID: " + p.id + 
                               " | Name: " + p.name + 
                               " | Age: " + p.age + 
                               " | Disease: " + p.disease + 
                               " | Doctor: " + p.doctor);
        }
    }

    static void searchPatient() {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();

        for (Patient p : patients) {
            if (p.id == id) {
                System.out.println("Found: " + p.name + " - " + p.disease);
                return;
            }
        }
        System.out.println("Patient not found!");
    }

    static void assignDoctor() {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Patient p : patients) {
            if (p.id == id) {
                System.out.print("Enter Doctor Name: ");
                p.doctor = sc.nextLine();
                System.out.println("Doctor assigned!");
                return;
            }
        }
        System.out.println("Patient not found!");
    }

    static void dischargePatient() {
        System.out.print("Enter Patient ID to discharge: ");
        int id = sc.nextInt();

        Iterator<Patient> it = patients.iterator();

        while (it.hasNext()) {
            Patient p = it.next();
            if (p.id == id) {
                it.remove();
                System.out.println("Patient discharged!");
                return;
            }
        }
        System.out.println("Patient not found!");
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- HOSPITAL MANAGEMENT ---");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Assign Doctor");
            System.out.println("5. Discharge Patient");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: addPatient(); break;
                case 2: viewPatients(); break;
                case 3: searchPatient(); break;
                case 4: assignDoctor(); break;
                case 5: dischargePatient(); break;
                case 6: return;
                default: System.out.println("Invalid choice");
            }
        }
    }
}
