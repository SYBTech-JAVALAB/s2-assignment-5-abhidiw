package Assignments;
import java.util.Scanner;


// Parent Class
class Employee1 {
    String name;
    int id;
    double salary;

    // Parent Constructor
    Employee1(String name, int id, double salary) throws Exception {

        if (name == null || name.trim().isEmpty()) {
            throw new Exception("Employee name cannot be empty.");
        }

        if (salary < 0) {
            throw new Exception("Salary cannot be negative.");
        }

        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void displayDetails() {
    	System.out.println("======= Employee Management System======");
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Salary: " + salary);
    }
}

// Developer Class
class Developer extends Employee1 {

    String language;

    Developer(String name, int id, double salary, String language) throws Exception {
        super(name, id, salary);
        this.language = language;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Developer");
        System.out.println("Programming Language: " + language);
    }
}

// Manager Class
class Manager extends Employee1 {

    int teamSize;

    Manager(String name, int id, double salary, int teamSize) throws Exception {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Manager");
        System.out.println("Team Size: " + teamSize);
    }
}

// Main Class
public class Assignment5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter Role (Developer/Manager): ");
            String role = sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();

            if (role.equalsIgnoreCase("Developer")) {

                sc.nextLine();
                System.out.print("Enter Programming Language: ");
                String lang = sc.nextLine();

                Developer d = new Developer(name, id, salary, lang);
                d.displayDetails();

            } else if (role.equalsIgnoreCase("Manager")) {

                System.out.print("Enter Team Size: ");
                int team = sc.nextInt();

                Manager m = new Manager(name, id, salary, team);
                m.displayDetails();

            } else {
                throw new Exception("Invalid role entered");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}