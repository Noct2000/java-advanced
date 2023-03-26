package kvasha.university.java.advanced.mapper;

import kvasha.university.java.advanced.model.Product;
import org.springframework.stereotype.Component;

@Component
public class WorkbookRawRowMapper {
    public String[] toRawRow(Product product) {
        return new String[] {
                product.getTitle(),
                product.getImgLink(),
                product.getDirectLink(),
                product.getDescription(),
                String.valueOf(product.getExternalId()),
                String.valueOf(product.getPrice())
        };
    }
}
