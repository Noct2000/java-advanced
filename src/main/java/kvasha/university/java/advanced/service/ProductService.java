package kvasha.university.java.advanced.service;

import java.util.List;
import kvasha.university.java.advanced.model.Product;

public interface ProductService {
    List<Product> getProductsFromApi(String searchRequest);
}