package Menu;

import java.util.Scanner;

public class MenuCustomer {

    private Scanner scanner = new Scanner(System.in);
    private MenuCustomerMethods menuMethods = new MenuCustomerMethods();

    public void menu() throws Exception {
        String s = "";
        while (!s.equals("exit")) {
            System.out.println("1 - Registration");
            System.out.println("2 - Authorization");
            System.out.println("3 - Print all customer");
            System.out.println("4 - Find customers by id");
            System.out.println("5 - Remove customers by id");
            System.out.println("6 - Back to main menu");
            System.out.println("7 - Exit");
            s = scanner.next();
            switch (s) {
                case "1":
                    menuMethods.registration();
                    break;
                case "2":
                    menuMethods.authorization();
                    break;
                case "3":
                    menuMethods.printAllCustomers();
                    break;
                case "4":
                    menuMethods.findByIDCustomers();
                    break;
                case "5":
                    menuMethods.removeCustomers();
                    break;
                case "6":

                    break;
                case "7":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Error: enter 1,2,3,4,5,6 or 7\n");
                    break;
            }
        }
    }
}
