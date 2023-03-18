package kvasha.university.java.advanced.model;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Product {
    private String title;
    private String imgLink;
    private String directLink;
    private String description;
    private Long externalId;
    private BigDecimal price;
}
