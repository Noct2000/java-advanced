package kvasha.university.java.advanced.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Product {
    @Id
    @GeneratedValue(generator = "product_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "product_id_seq",
            sequenceName = "product_id_seq",
            allocationSize = 1)
    private Long id;
    private String title;
    private String imgLink;
    private String directLink;
    @Column(length = 10000)
    private String description;
    private Long externalId;
    private BigDecimal price;
}
