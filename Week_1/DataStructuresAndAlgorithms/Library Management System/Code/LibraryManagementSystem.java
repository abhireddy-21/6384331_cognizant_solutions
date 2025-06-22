import java.util.*;
class Book {
    int bookId;
    String title;
    String author;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "\nBook ID: " + bookId + "\nTitle: " + title + "\nAuthor: " + author;
    }
}
public class LibraryManagementSystem {
    static Scanner sc = new Scanner(System.in);
    public static void linearSearch(Book[] books, String key) {
        boolean found = false;
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(key)) {
                System.out.println("Book Found:\n" + b);
                found = true;
            }
        }
        if (!found) System.out.println("Book not found.");
    }
    public static void binarySearch(Book[] books, String key) {
        Arrays.sort(books, Comparator.comparing(b -> b.title.toLowerCase()));
        int low = 0, high = books.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(key);
            if (cmp == 0) {
                System.out.println("Book Found:\n" + books[mid]);
                return;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Book not found.");
    }
    public static void main(String[] args) {
        System.out.print("Enter number of books: ");
        int n = sc.nextInt(); sc.nextLine();
        Book[] books = new Book[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Book " + (i + 1));
            System.out.print("Book ID: ");
            int id = sc.nextInt(); sc.nextLine();
            System.out.print("Title: ");
            String title = sc.nextLine();
            System.out.print("Author: ");
            String author = sc.nextLine();
            books[i] = new Book(id, title, author);
        }
        int choice;
        do {
            System.out.println("\n--- Library Search Menu ---");
            System.out.println("1. Linear Search by Title");
            System.out.println("2. Binary Search by Title");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt(); sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter book title to search (Linear): ");
                    String key1 = sc.nextLine();
                    linearSearch(books, key1);
                    break;
                case 2:
                    System.out.print("Enter book title to search (Binary): ");
                    String key2 = sc.nextLine();
                    binarySearch(books, key2);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 3);
    }
}
