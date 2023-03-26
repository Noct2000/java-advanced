package kvasha.university.java.advanced.controller;

import kvasha.university.java.advanced.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/count")
    public Integer getCountOfAllProducts() {
        return productService.getCountOfAllProducts();
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAll() {
        productService.deleteAll();
        return ResponseEntity.ok().build();
    }
}
