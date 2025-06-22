import java.util.*;
public class InventoryManagementSystem {
    static class Product {
        int productId;
        String productName;
        int quantity;
        double price;
        Product(int productId, String productName, int quantity, double price) {
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }
        @Override
        public String toString() {
            return "Product ID: " + productId + "\n" +
           "Name: " + productName + "\n" +
           "Quantity: " + quantity + "\n" +
           "Price: $" + price + "\n";
        }
    }
    static class Inventory {
        HashMap<Integer, Product> inventory = new HashMap<>();
        void addProduct(Product p) {
            if (inventory.containsKey(p.productId)) {
                System.out.println("Product already exists!");
            } else {
                inventory.put(p.productId, p);
                System.out.println("Product added successfully.");
            }
        }
        void updateProduct(int productId, String name, int quantity, double price) {
            Product p = inventory.get(productId);
            if (p != null) {
                p.productName = name;
                p.quantity = quantity;
                p.price = price;
                System.out.println("Product updated.");
            } else {
                System.out.println("Product not found.");
            }
        }
        void deleteProduct(int productId) {
            if (inventory.remove(productId) != null) {
                System.out.println("Product removed.");
            } else {
                System.out.println("Product not found.");
            }
        }
        void viewInventory() {
            if (inventory.isEmpty()) {
                System.out.println("Inventory is empty.");
            } else {
                for (Product p : inventory.values()) {
                    System.out.println(p);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory inv = new Inventory();
        while (true) {
            System.out.println("\n1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. View Inventory");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    inv.addProduct(new Product(id, name, qty, price));
                    break;
                case 2:
                    System.out.print("Enter Product ID to update: ");
                    int uid = sc.nextInt();1
                    sc.nextLine();
                    System.out.print("Enter New Name: ");
                    String uname = sc.nextLine();
                    System.out.print("Enter New Quantity: ");
                    int uqty = sc.nextInt();
                    System.out.print("Enter New Price: ");
                    double uprice = sc.nextDouble();
                    inv.updateProduct(uid, uname, uqty, uprice);
                    break;
                case 3:
                    System.out.print("Enter Product ID to delete: ");
                    int did = sc.nextInt();
                    inv.deleteProduct(did);
                    break;
                case 4:
                    inv.viewInventory();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
