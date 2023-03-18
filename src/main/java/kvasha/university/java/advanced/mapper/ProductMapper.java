package kvasha.university.java.advanced.mapper;

import java.math.BigDecimal;
import kvasha.university.java.advanced.model.Product;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product toModel(Element rawProduct) {
        Product product = new Product();
        Element productPicture = rawProduct
                .getElementsByClass("goods-tile__picture ng-star-inserted")
                .stream()
                .findAny()
                .orElseThrow(() -> new RuntimeException("No product card"));
        Element img = productPicture.getElementsByTag("img")
                .stream()
                .findAny()
                .orElseThrow(() -> new RuntimeException("No img tag"));
        product.setTitle(img.attr("title"));
        product.setImgLink(img.attr("src"));
        product.setDirectLink(productPicture.attr("href"));
        Element priceSpan = rawProduct.getElementsByClass("goods-tile__price-value")
                .stream()
                .findAny()
                .orElseThrow(() -> new RuntimeException("No pan with price"));
        product.setPrice(new BigDecimal(priceSpan.text().replaceAll("\\D", "")));
        product.setExternalId(Long.valueOf(rawProduct.attr("data-goods-id")));
        return product;
    }
}
