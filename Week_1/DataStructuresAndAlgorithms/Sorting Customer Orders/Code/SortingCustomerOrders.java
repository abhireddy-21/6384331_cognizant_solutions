import java.util.Scanner;
class Order {
    int orderId;
    String customerName;
    double totalPrice;
    Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }
    @Override
    public String toString() {
        return "\nOrder ID: " + orderId + "\nName: " + customerName + "\nPrice: $" + totalPrice;
    }
}
public class SortingCustomerOrders {
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }
    public static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice < pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }
    public static void displayOrders(Order[] orders) {
        for (Order o : orders) {
            System.out.println(o);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of orders: ");
        int n = sc.nextInt();
        sc.nextLine();
        Order[] orders = new Order[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Order " + (i + 1) + ":");
            System.out.print("Order ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Customer Name: ");
            String name = sc.nextLine();
            System.out.print("Total Price: ");
            double price = sc.nextDouble();
            orders[i] = new Order(id, name, price);
        }
        int choice;
        do {
            System.out.println("\n=== Sorting Menu ===");
            System.out.println("1. Bubble Sort by Total Price");
            System.out.println("2. Quick Sort by Total Price");
            System.out.println("3. Display Orders");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    bubbleSort(orders);
                    System.out.println("\nOrders sorted using Bubble Sort:");
                    displayOrders(orders);
                    break;
                case 2:
                    quickSort(orders, 0, orders.length - 1);
                    System.out.println("\nOrders sorted using Quick Sort:");
                    displayOrders(orders);
                    break;
                case 3:
                    System.out.println("\nCurrent Orders:");
                    displayOrders(orders);
                    break;
                case 4:
                    System.out.println("Exiting program. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
        sc.close();
    }
}
