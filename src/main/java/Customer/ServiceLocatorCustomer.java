package Customer;

public final class ServiceLocatorCustomer {

    private static CustomerController customerController;
    private static CustomerRepository customerRepository;

    private ServiceLocatorCustomer() {
    }

    static CustomerRepository getCustomerRepository() {
        if (customerRepository == null) {
            customerRepository = new CustomerRepositoryImpl();
        }
        return customerRepository;
    }

    public static CustomerController getCustomerController() {
        if (customerController == null) {
            customerController = new CustomerController();
        }
        return customerController;
    }
}
