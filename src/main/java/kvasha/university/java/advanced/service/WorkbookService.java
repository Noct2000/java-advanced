package kvasha.university.java.advanced.service;

import java.util.List;
import kvasha.university.java.advanced.model.Product;
import org.apache.poi.ss.usermodel.Workbook;

public interface WorkbookService {
    Workbook getWorkbookFromProductList(List<Product> products);
}
