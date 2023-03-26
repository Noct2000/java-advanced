package kvasha.university.java.advanced.service.impl;

import java.util.List;
import kvasha.university.java.advanced.mapper.WorkbookRawRowMapper;
import kvasha.university.java.advanced.model.Product;
import kvasha.university.java.advanced.service.WorkbookService;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkbookServiceImpl implements WorkbookService {
    private static final String[] HEADER = {
            "TITLE",
            "IMAGE LINK",
            "DIRECT LINK",
            "PRODUCT DESCRIPTION",
            "EXTERNAL ID",
            "PRICE"
    };
    private static final int HEADER_ROW_INDEX = 0;
    private static final String SHEET_NAME = "Products";
    private final WorkbookRawRowMapper workbookRawRowMapper;

    @Override
    public Workbook getWorkbookFromProductList(List<Product> products) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(SHEET_NAME);
        writeHeader(sheet);
        writeProductsToWorkbook(products, sheet);
        return workbook;
    }

    private void writeProductsToWorkbook(List<Product> products, Sheet sheet) {
        for (int i = 0; i < products.size(); i++) {
            Row row = sheet.createRow(i + 1);
            String[] rawRow = workbookRawRowMapper
                    .toRawRow(products.get(i));
            for (int j = 0; j < rawRow.length; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(rawRow[j]);
            }
        }
    }

    private void writeHeader(Sheet sheet) {
        Row row = sheet.createRow(HEADER_ROW_INDEX);
        for (int i = 0; i < HEADER.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(HEADER[i]);
        }
    }
}
