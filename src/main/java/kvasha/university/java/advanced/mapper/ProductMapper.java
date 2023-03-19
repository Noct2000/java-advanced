package kvasha.university.java.advanced.mapper;

import kvasha.university.java.advanced.model.Product;
import kvasha.university.java.advanced.model.dto.ExternalDescriptionResponseDto;
import kvasha.university.java.advanced.model.dto.ExternalProductDto;
import kvasha.university.java.advanced.service.RozetkaDescriptionFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductMapper {
    private final RozetkaDescriptionFeignClient rozetkaDescriptionFeignClient;

    public Product toModel(ExternalProductDto externalProductDto) {
        Product product = new Product();
        product.setPrice(externalProductDto.getPrice());
        product.setExternalId(externalProductDto.getId());
        product.setTitle(externalProductDto.getTitle());
        product.setDirectLink(externalProductDto.getHref());
        product.setImgLink(externalProductDto.getMainImgLink());
        ExternalDescriptionResponseDto description = rozetkaDescriptionFeignClient
                .getDescription(product.getExternalId());
        product.setDescription(description.getData().getText());
        return product;
    }
}
