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
public class ProductBinarySearch {
    public static Product binarySearch(Product[] products, String name) {
        int low = 0, high = products.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(name);
            if (cmp == 0)
                return products[mid];
            else if (cmp < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return null;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine();
        Product[] products = new Product[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for product " + (i + 1) + ":");
            System.out.print("Product ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Product Name: ");
            String name = sc.nextLine();
            System.out.print("Category: ");
            String category = sc.nextLine();
            products[i] = new Product(id, name, category);
        }
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));
        System.out.print("\nEnter product name to search: ");
        String searchName = sc.nextLine();
        Product result = binarySearch(products, searchName);
        System.out.println("\nBinary Search Result:");
        System.out.println(result != null ? result : "Product not found.");
        sc.close();
    }
}
