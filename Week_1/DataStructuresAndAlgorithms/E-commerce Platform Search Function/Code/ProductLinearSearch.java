import java.util.*;
class Product {
    int productId;
    String productName;
    String category;
    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
    @Override
    public String toString() {
        return "Product ID: " + productId + "\n" +
               "Name: " + productName + "\n" +
               "Category: " + category + "\n";
    }
}
public class ProductLinearSearch {
    public static Product linearSearch(Product[] products, String name) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine();
        Product[] p = new Product[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for product " + (i + 1) + ":");
            System.out.print("Product ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Product Name: ");
            String name = sc.nextLine();
            System.out.print("Category: ");
            String category = sc.nextLine();
            p[i] = new Product(id, name, category);
        }

        System.out.print("\nEnter product name to search: ");
        String searchName = sc.nextLine();

        Product result = linearSearch(p, searchName);
        System.out.println("\n Linear Search Result:");
        System.out.println(result != null ? result : "Product not found.");

        sc.close();
    }
}
