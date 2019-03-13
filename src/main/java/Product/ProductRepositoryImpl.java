package Product;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class ProductRepositoryImpl implements ProductRepository{

    private final static String FILEPATH = "src/main/resources/product.json";
    private final static String FILEPATHID = "src/main/resources/counterProducts.json";
    private Map<Double, Product> productsMap = new HashMap<Double, Product>();
    private Gson gson = new Gson();
    private FileWriter fileWriter;

    @Override
    public Map<Double, Product> findAll() {
        return productsMap;
    }

    @Override
    public Product findById(double productId) {
        return productsMap.get(productId);
    }

    @Override
    public void delete(double productId) {
        productsMap.remove(productId);
    }

    @Override
    public void saveOrUpdate(double productId, Product product) throws IOException {
        productsMap.put(productId, product);
        productsMap.put(product.getProductId(), product);
        String json = gson.toJson(productsMap);
        fileWriter = new FileWriter(FILEPATH);
        fileWriter.write(json);
        fileWriter.close();
        countSave();
    }

    @Override
    public void countSave() throws IOException {
        String json = gson.toJson(ProductController.getproductID());
        fileWriter = new FileWriter(FILEPATHID);
        fileWriter.write(json);
        fileWriter.close();
    }

    @Override
    public void loadState(){
        try {
            BufferedReader bf = new BufferedReader(new FileReader(FILEPATH));
            Type type = new TypeToken<HashMap<Double, Product>>(){}.getType();
            productsMap = gson.fromJson(bf,type);
            loadID();
        } catch (FileNotFoundException e){
            System.out.println("Error: File (" + FILEPATH +  ") not found");
        }
    }

    @Override
    public void loadID() {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(FILEPATHID));
            Type type = new TypeToken<Double>(){}.getType();
            double id = gson.fromJson(bf,type);
            ProductController.setProductID(id+1);
        } catch (FileNotFoundException e){
            System.out.println("Error: File (" + FILEPATHID +  ") not found");
        }
    }
}