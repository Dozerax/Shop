package Product;

public class ServiceLocatorProduct {

    private static ProductController productController;
    private static ProductRepository productRepository;

    private ServiceLocatorProduct(){
    }

    public static ProductController getProductController(){
        if (productController == null){
            productController = new ProductController();
        }
        return productController;
    }

    static ProductRepository getProductRepository(){
        if (productRepository == null){
            productRepository = new ProductRepositoryImpl();
        }
        return productRepository;
    }
}
