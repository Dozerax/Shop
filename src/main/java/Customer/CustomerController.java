package Customer;

import java.io.IOException;
import java.util.Map;

public class CustomerController {

    private static double customerID = 0.1;
    private CustomerRepository customerRepository = ServiceLocatorCustomer.getCustomerRepository();

    public void addCustomer(String firstName, String lastName, String address) throws IOException {
        Customer customer = new Customer(customerID, firstName, lastName, address);
        customerRepository.saveOrUpdate(customer);
        customerID++;
    }

    public Map<Double, Customer> allCustomers() {
        return customerRepository.findAll();
    }

    public Customer findByIdCustomer(double customerId) {
        return customerRepository.findById(customerId);
    }

    public void removeCustomer(double customerId) {
        customerRepository.delete(customerId);
    }

    public void loadStateCustomer() throws IOException {
        customerRepository.loadState();
    }

    static double getCustomerID() {
        return customerID;
    }

    static void setCustomerID(double customerID) {
        CustomerController.customerID = customerID;
    }
}