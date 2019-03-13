package Menu;

import Product.ProductController;
import Product.ServiceLocatorProduct;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class MenuProductsMethods {

    private ProductController productController = ServiceLocatorProduct.getProductController();
    private Scanner scanner = new Scanner(System.in);

    void addProduct() {
        System.out.println("Enter product name and price in one line (productName price)");
        try {
            String[] arr = scanner.nextLine().split(" ");
            System.out.println(Arrays.toString(arr));
            productController.addProduct(arr[0], Double.parseDouble(arr[1]));
            System.out.println("Product added\n");
        } catch (NullPointerException ex) {
            System.out.println("Error: Null pointer exception");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Error: Array index out of bounds exception, Enter (productName price) try again");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e){
            System.out.println("Error: Number format Exception, Enter (productName price) try again");
        }
    }

    void PrintAllProducts() {
        System.out.println(productController.allProduct() + "\n");
    }

    void findByIDProducts() {
        if (!scanner.hasNextDouble()){
            System.out.println("Error: format id (number.2) try again");
        } else {
            System.out.println(productController.findByIdProduct(scanner.nextDouble()) + "\n");
        }
    }

    void removeProducts() {
        if (!scanner.hasNextDouble()){
            System.out.println("Error: format id (number.2) try again");
        } else {
            productController.removeProduct(scanner.nextDouble());
        }
    }

    void editProduct() {
        System.out.println("Method not found");
    }
}
