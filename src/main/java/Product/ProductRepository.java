package Product;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public interface ProductRepository {
    Map<Double, Product> findAll();

    Product findById(double productId);

    void saveOrUpdate(double productId, Product product) throws IOException;

    void delete(double productId);

    void loadState() throws IOException;

    void countSave() throws IOException;

    void loadID() throws FileNotFoundException;
}
