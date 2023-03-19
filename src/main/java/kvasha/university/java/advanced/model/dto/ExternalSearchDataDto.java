package kvasha.university.java.advanced.model.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExternalSearchDataDto {
    private ExternalSearchPaginationDto pagination;
    private List<ExternalProductDto> goods;
}
