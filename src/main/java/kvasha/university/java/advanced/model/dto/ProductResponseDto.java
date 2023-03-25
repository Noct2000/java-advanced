package kvasha.university.java.advanced.model.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {
    private String title;
    private String imgLink;
    private String directLink;
    private String description;
    private Long externalId;
    private BigDecimal price;
}
