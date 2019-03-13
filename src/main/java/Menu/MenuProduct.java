package Menu;

import java.util.Scanner;

public class MenuProduct {
    private Scanner scanner = new Scanner(System.in);
    private MenuProductsMethods menuMethods = new MenuProductsMethods();

    public void menu(){
        String s = "";
        while (!s.equals("exit")) {
            System.out.println("1 - Add new product");
            System.out.println("2 - Print all products ");
            System.out.println("3 - Find customers by id");
            System.out.println("4 - Remove customers by id");
            System.out.println("6 - Back to main menu");
            System.out.println("7 - Exit");
            s = scanner.next();
            switch (s) {
                case "1":
                    menuMethods.addProduct();
                    break;
                case "2":
                    menuMethods.PrintAllProducts();
                    break;
                case "3":
                    menuMethods.findByIDProducts();
                    break;
                case "4":
                    menuMethods.removeProducts();
                    break;
                case "5":
                    menuMethods.editProduct();
                    break;
                case "6":

                    break;
                case "7":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Error: enter 1,2,3,4,6 or 7\n");
                    break;
            }
        }
    }
}
