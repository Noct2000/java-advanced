package kvasha.university.java.advanced.service.impl;

import java.util.ArrayList;
import java.util.List;
import kvasha.university.java.advanced.mapper.ProductMapper;
import kvasha.university.java.advanced.model.Product;
import kvasha.university.java.advanced.model.dto.ExternalProductDto;
import kvasha.university.java.advanced.model.dto.ExternalSearchResponseDto;
import kvasha.university.java.advanced.service.ProductService;
import kvasha.university.java.advanced.service.RozetkaSearchFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProductServiceImpl implements ProductService {
    private static final int START_PAGE_NUMBER = 1;

    private final RozetkaSearchFeignClient rozetkaSearchFeignClient;
    private final ProductMapper productMapper;

    @Override
    public List<Product> getProductsFromApi(String searchRequest) {
        String clearSearchRequest = searchRequest.replaceAll(" ", "+");
        ExternalSearchResponseDto externalSearchResponseDto = rozetkaSearchFeignClient
                .searchProduct(searchRequest, START_PAGE_NUMBER);
        List<Product> products = new ArrayList<>();
        mapProducts(externalSearchResponseDto, products);

        fetchProducts(
                products,
                externalSearchResponseDto.getData().getPagination().getTotalPages(),
                clearSearchRequest);
        return products;
    }

    private void mapProducts(
            ExternalSearchResponseDto externalSearchResponseDto,
            List<Product> products
    ) {
        for (ExternalProductDto productDto : externalSearchResponseDto.getData().getGoods()) {
            products.add(productMapper.toModel(productDto));
        }
    }

    private void fetchProducts(
            List<Product> products,
            Integer totalPages,
            String clearSearchRequest
    ) {
        for (int page = START_PAGE_NUMBER + 1; page <= totalPages; page++) {
            ExternalSearchResponseDto externalSearchResponseDto = rozetkaSearchFeignClient
                    .searchProduct(clearSearchRequest, page);
            mapProducts(externalSearchResponseDto, products);
            log.info("page={}", page);

        }
    }
}
