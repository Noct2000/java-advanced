package kvasha.university.java.advanced.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExternalProductDto {
    private Long id;
    @JsonProperty("image_main")
    private String mainImgLink;
    private BigDecimal price;
    private String title;
    private String href;
}
