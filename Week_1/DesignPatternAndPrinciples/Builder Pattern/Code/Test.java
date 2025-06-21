public class Test {
    public static void main(String[] args) {
        Computer c = new Computer.Builder()
                        .setCPU("Intel i7")
                        .setRam("16GB")
                        .setStorage("1TB SSD")
                        .build();

        c.display();
    }
}
