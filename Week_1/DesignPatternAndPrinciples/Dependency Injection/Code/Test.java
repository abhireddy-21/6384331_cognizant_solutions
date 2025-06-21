public class Test {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);
        System.out.println();
        service.displayCustomerDetails("C001");
        System.out.println();
        service.displayCustomerDetails("C003"); 
        System.out.println();
    }
}
