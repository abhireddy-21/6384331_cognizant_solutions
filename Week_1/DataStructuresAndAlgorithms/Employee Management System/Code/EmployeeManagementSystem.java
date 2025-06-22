import java.util.Scanner;
class Employee {
    int employeeId;
    String name;
    String position;
    double salary;
    Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "\nID: " + employeeId + "\nName: " + name + "\nPosition: " + position + "\nSalary: $" + salary;
    }
}
public class EmployeeManagementSystem {
    static final int MAX = 100;
    static Employee[] employees = new Employee[MAX];
    static int count = 0;
    public static void addEmployee(Scanner sc) {
        if (count >= MAX) {
            System.out.println("Employee list full.");
            return;
        }
        System.out.print("Enter ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Position: ");
        String pos = sc.nextLine();
        System.out.print("Enter Salary: ");
        double sal = sc.nextDouble();
        employees[count++] = new Employee(id, name, pos, sal);
        System.out.println("Employee added.");
    }
    public static void searchEmployee(Scanner sc) {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                System.out.println("Found:\n" + employees[i]);
                return;
            }
        }
        System.out.println("Employee not found.");
    }
    public static void traverseEmployees() {
        if (count == 0) {
            System.out.println("No employees to display.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }
    public static void deleteEmployee(Scanner sc) {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                // Shift remaining
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                System.out.println("Employee deleted.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- Employee Management Menu ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. View All Employees");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1: addEmployee(sc); break;
                case 2: searchEmployee(sc); break;
                case 3: traverseEmployees(); break;
                case 4: deleteEmployee(sc); break;
                case 5: System.out.println("Exiting."); break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 5);
        sc.close();
    }
}
