package kvasha.university.java.advanced.servise;

import kvasha.university.java.advanced.model.dto.ExternalSearchResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "rozetka-api", url = "https://search.rozetka.com.ua/ua/search/api/v6/")
public interface RozetkaFeignClient {
    @GetMapping
    ExternalSearchResponseDto searchProduct(@RequestParam String text, @RequestParam Integer page);
}
