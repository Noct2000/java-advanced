package kvasha.university.java.advanced.service;

import kvasha.university.java.advanced.model.dto.ExternalDescriptionResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "rozetka-description", url = "${ROZETKA_DESCRIPTION}")
public interface RozetkaDescriptionFeignClient {
    @GetMapping
    ExternalDescriptionResponseDto getDescription(@RequestParam Long goodsId);
}
