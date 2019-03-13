package Customer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public interface CustomerRepository {
    Map<Double, Customer> findAll();

    Customer findById(double customerId);

    void saveOrUpdate(Customer customer) throws IOException;

    void delete(double customerId);

    void loadState() throws IOException;

    void countSave() throws IOException;

    void loadID() throws FileNotFoundException;
}
