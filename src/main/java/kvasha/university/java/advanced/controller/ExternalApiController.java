package kvasha.university.java.advanced.controller;

import kvasha.university.java.advanced.mapper.ProductMapper;
import kvasha.university.java.advanced.model.dto.ExternalSearchResponseDto;
import kvasha.university.java.advanced.servise.RozetkaSearchFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/external-api")
@RequiredArgsConstructor
public class ExternalApiController {
    private final ProductMapper productMapper;
    private final RozetkaSearchFeignClient rozetkaSearchFeignClient;

    @PostMapping("/sync-products")
    public ExternalSearchResponseDto syncGoods(@RequestBody String externalEndpoint) {
        return rozetkaSearchFeignClient.searchProduct("notekia+flip", 1);
    }
}
