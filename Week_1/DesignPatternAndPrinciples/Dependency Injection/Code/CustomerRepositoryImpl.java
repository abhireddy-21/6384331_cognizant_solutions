import java.util.HashMap;
import java.util.Map;
public class CustomerRepositoryImpl implements CustomerRepository {
    private Map<String, Customer> database = new HashMap<>();
    public CustomerRepositoryImpl() {
        database.put("C001", new Customer("C001", "Rahul", "rahul@example.com"));
        database.put("C002", new Customer("C002", "Ravi", "ravi@example.com"));
    }
    @Override
    public Customer findCustomerById(String id) {
        return database.get(id);
    }
}
