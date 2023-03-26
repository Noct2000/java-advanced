package kvasha.university.java.advanced.service;

import java.util.List;
import kvasha.university.java.advanced.model.Product;

public interface ProductService {
    List<Product> getProductsFromApi(String searchRequest);

    List<Product> saveProducts(List<Product> products);

    Integer getCountOfAllProducts();

    List<Product> getAll();

    void deleteAll();
}
