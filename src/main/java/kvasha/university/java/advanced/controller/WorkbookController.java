package kvasha.university.java.advanced.controller;

import java.util.List;
import kvasha.university.java.advanced.mapper.ResourceMapper;
import kvasha.university.java.advanced.model.Product;
import kvasha.university.java.advanced.service.ProductService;
import kvasha.university.java.advanced.service.WorkbookService;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workbooks")
@RequiredArgsConstructor
public class WorkbookController {
    private static final String HTTP_HEADER = "attachment; filename=\"products.xlsx\"";
    private final WorkbookService workbookService;
    private final ProductService productService;
    private final ResourceMapper resourceMapper;

    @GetMapping
    public ResponseEntity<Resource> getProductsWorkbook() {
        List<Product> products = productService.getAll();
        Workbook workbook = workbookService
                .getWorkbookFromProductList(products);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        HTTP_HEADER)
                .body(resourceMapper.toResource(workbook));
    }
}
