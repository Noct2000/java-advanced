package kvasha.university.java.advanced.controller;

import java.util.List;
import kvasha.university.java.advanced.model.Product;
import kvasha.university.java.advanced.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/external-api")
@RequiredArgsConstructor
public class ExternalApiController {
    private final ProductService productService;

    @PostMapping("/sync-products")
    public List<Product> syncGoods(@RequestBody String searchRequest) {
        return productService.getProductsFromApi(searchRequest);
    }
}
