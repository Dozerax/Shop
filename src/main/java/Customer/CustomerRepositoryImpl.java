package Customer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;
public class CustomerRepositoryImpl implements CustomerRepository {

    private final static String FILEPATH = "src/main/resources/customers.json";
    private final static String FILEPATHID = "src/main/resources/counterCustomers.json";
    private Map<Double, Customer> customersMap = new HashMap<Double, Customer>();
    private Gson gson = new Gson();
    private FileWriter fileWriter;

    public Map<Double, Customer> findAll() {
        return customersMap;
    }

    public Customer findById(double customerId) {
        return customersMap.get(customerId);
    }

    public void delete(double customerId) {
        customersMap.remove(customerId);
    }

    public void saveOrUpdate(Customer customer) throws IOException {
        customersMap.put(customer.getCustomerId(), customer);
        String json = gson.toJson(customersMap);
        fileWriter = new FileWriter(FILEPATH);
        fileWriter.write(json);
        fileWriter.close();
        countSave();
    }

    @Override
    public void countSave() throws IOException {
        String json = gson.toJson(CustomerController.getCustomerID());
        fileWriter = new FileWriter(FILEPATHID);
        fileWriter.write(json);
        fileWriter.close();
    }

    @Override
    public void loadState() throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader(FILEPATH));
        Type type = new TypeToken<HashMap<Double, Customer>>(){}.getType();
        customersMap = gson.fromJson(bf,type);
        loadID();
    }

    @Override
    public void loadID() throws FileNotFoundException {
        BufferedReader bf = new BufferedReader(new FileReader(FILEPATHID));
        Type type = new TypeToken<Double>(){}.getType();
        double id = gson.fromJson(bf,type);
        CustomerController.setCustomerID(id+1);
    }
}
