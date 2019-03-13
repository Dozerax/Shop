import Customer.CustomerController;
import Customer.ServiceLocatorCustomer;
import Menu.MenuCustomer;
import Menu.MenuProduct;
import Product.ProductController;
import Product.ServiceLocatorProduct;

import java.io.IOException;
import java.util.Scanner;

public class App {

    private CustomerController customerController = ServiceLocatorCustomer.getCustomerController();
    private ProductController productController = ServiceLocatorProduct.getProductController();
    private MenuCustomer menuCustomer = new MenuCustomer();
    private MenuProduct menuProduct = new MenuProduct();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        App app = new App();
        app.init();
        app.menu();
    }

    private void init() throws IOException {
        customerController.loadStateCustomer();
        productController.loadStateProduct();
    }

    private void menu() throws Exception {
        String s = "";
        while (!s.equals("exit")) {
            System.out.println("1 - Customer menu");
            System.out.println("2 - Product menu ");
            System.out.println("3 - Order menu");
            System.out.println("4 - Exit");
            s = scanner.next();
            switch (s) {
                case "1":
                    menuCustomer.menu();
                    break;
                case "2":
                    menuProduct.menu();
                    break;
                case "3":
                    System.out.println("Menu not found");
                    break;
                case "4":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Error: enter 1,2,3 or 4\n");
                    break;
            }
        }
    }
}
