package Menu;

import Customer.CustomerController;
import Customer.ServiceLocatorCustomer;

import java.util.Arrays;
import java.util.Scanner;

class MenuCustomerMethods {

    private CustomerController customerController = ServiceLocatorCustomer.getCustomerController();
    private Scanner scanner = new Scanner(System.in);

    void registration() throws Exception {
        System.out.println("Enter customer first name, last name and address in one line (firstName lastName address)");
        try {
            String[] arr = scanner.nextLine().split(" ");
            System.out.println(Arrays.toString(arr));
            customerController.addCustomer(arr[0], arr[1], arr[2]);
            System.out.println("Registration successful\n");
        } catch (NullPointerException ex) {
            System.out.println("Error: Null pointer exception");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Error: Array index out of bounds exception, Enter (firstName lastName address) try again");
        }
    }

    void authorization() {
        System.out.println("Method not found\n");
    }

    void printAllCustomers() {
        System.out.println(customerController.allCustomers() + "\n");
    }

    void findByIDCustomers() {
        if (!scanner.hasNextDouble()){
            System.out.println("Error: format id (number.1) try again");
        } else {
            System.out.println(customerController.findByIdCustomer(scanner.nextDouble()) + "\n");
        }
    }

    void removeCustomers() {
        if (!scanner.hasNextDouble()){
            System.out.println("Error: format id (number.1) try again");
        } else {
            customerController.removeCustomer(scanner.nextDouble());
        }
    }
}
