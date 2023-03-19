package kvasha.university.java.advanced.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExternalSearchPaginationDto {
    @JsonProperty("shown_page")
    private Integer shownPage;
    @JsonProperty("total_pages")
    private Integer totalPages;
}
