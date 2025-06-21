public class Test {
    public static void main(String[] args) {
        Image img1 = new ProxyImage("nature.jpg");
        Image img2 = new ProxyImage("city.jpg");
        Image img3 = new ProxyImage("animal.jpg");
        img1.display();
        System.out.println();
        img2.display();
        System.out.println();
        img3.display(); 
    }
}
