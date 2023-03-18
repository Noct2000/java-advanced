package kvasha.university.java.advanced.controller;

import java.util.List;
import java.util.stream.Collectors;
import kvasha.university.java.advanced.mapper.ProductMapper;
import kvasha.university.java.advanced.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/external-api")
@RequiredArgsConstructor
public class ExternalApiController {
    private final ProductMapper productMapper;

    @PostMapping("/sync-products")
    @SneakyThrows
    public List<Product> syncGoods(@RequestBody String externalEndpoint) {
        Document doc = Jsoup.connect(externalEndpoint)
                .header("Accept-Encoding", "gzip, deflate")
                .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:23.0)"
                        + " Gecko/20100101 Firefox/23.0")
                .maxBodySize(2048000)
                .timeout(600000)
                .get();
        return doc.getElementsByClass("goods-tile__inner")
                .stream()
                .map(productMapper::toModel)
                .collect(Collectors.toList());
    }
}
