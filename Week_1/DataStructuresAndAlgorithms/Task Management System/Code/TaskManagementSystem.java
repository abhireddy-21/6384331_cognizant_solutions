import java.util.Scanner;
class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }

    @Override
    public String toString() {
        return "\nTask ID: " + taskId + "\nTask Name: " + taskName + "\nStatus: " + status;
    }
}
public class TaskManagementSystem {
    static Task head = null;
    public static void addTask(Scanner sc) {
        System.out.print("Enter Task ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Task Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Status: ");
        String status = sc.nextLine();
        Task newTask = new Task(id, name, status);
        if (head == null) {
            head = newTask;
        } else {
            Task temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newTask;
        }
        System.out.println("Task added.");
    }
    public static void searchTask(Scanner sc) {
        System.out.print("Enter Task ID to search: ");
        int id = sc.nextInt();
        Task temp = head;
        while (temp != null) {
            if (temp.taskId == id) {
                System.out.println("Found:\n" + temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Task not found.");
    }

    public static void traverseTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Task temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
    public static void deleteTask(Scanner sc) {
        System.out.print("Enter Task ID to delete: ");
        int id = sc.nextInt();
        if (head == null) {
            System.out.println("No tasks to delete.");
            return;
        }
        if (head.taskId == id) {
            head = head.next;
            System.out.println("Task deleted.");
            return;
        }
        Task prev = head;
        Task curr = head.next;
        while (curr != null) {
            if (curr.taskId == id) {
                prev.next = curr.next;
                System.out.println("Task deleted.");
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        System.out.println("Task not found.");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- Task Management Menu ---");
            System.out.println("1. Add Task");
            System.out.println("2. Search Task");
            System.out.println("3. View All Tasks");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1: addTask(sc); break;
                case 2: searchTask(sc); break;
                case 3: traverseTasks(); break;
                case 4: deleteTask(sc); break;
                case 5: System.out.println("Exiting."); break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 5);
        sc.close();
    }
}
