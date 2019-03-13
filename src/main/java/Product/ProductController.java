package Product;

import java.io.IOException;
import java.util.Map;

public class ProductController {

    private static double productID = 0.2;
    private ProductRepository productRepository = ServiceLocatorProduct.getProductRepository();

    public void addProduct(String productName, double price) throws IOException {
        Product product = new Product(productID, productName, price);
        productRepository.saveOrUpdate(productID, product);
        productID++;
    }

    public Map<Double, Product> allProduct() {
        return productRepository.findAll();
    }

    public Product findByIdProduct(double productId) {
        return productRepository.findById(productId);
    }

    public void removeProduct(double productId) {
        productRepository.delete(productId);
    }

    public void loadStateProduct() throws IOException {
        productRepository.loadState();
    }

    static double getproductID() {
        return productID;
    }

    static void setProductID(double productID) {
        ProductController.productID = productID;
    }
}
