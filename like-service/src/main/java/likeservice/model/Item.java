package likeservice.model;

import likeservice.model.dto.ItemDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@ToString
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id", nullable = false)
    private Long product_id;

    @Column(name = "title")
    private String title;

    @Column(name = "link")
    private String link;

    @Column(name = "image")
    private String image;

    @Column(name = "lprice")
    private Long lprice;

    @Column(name = "hprice")
    private Long hprice;

    @Column(name = "mall_name")
    private String mall_name;

    @Column(name = "product_type")
    private Integer product_type;

    @Column(name = "brand")
    private String brand;

    @Column(name = "maker")
    private String maker;

    @Column(name = "category1")
    private String category1;

    @Column(name = "category2")
    private String category2;

    @Column(name = "category3")
    private String category3;

    @Column(name = "category4")
    private String category4;

    public Item(String title, String link, String image, Long lprice, Long hprice, String mall_name, Integer product_type, String brand, String maker, String category1, String category2, String category3, String category4){
        this.title = title;
        this.link = link;
        this.image = image;
        this.lprice = lprice;
        this.hprice = hprice;
        this.mall_name = mall_name;
        this.product_type = product_type;
        this.brand = brand;
        this.maker = maker;
        this.category1 = category1;
        this.category2 = category2;
        this.category3 = category3;
        this.category4 = category4;
    }

    public void setByDto(ItemDTO itemDTO){
        this.title = itemDTO.getTitle();
        this.link = itemDTO.getLink();
        this.image = itemDTO.getImage();
        this.lprice = itemDTO.getLprice();
        this.hprice = itemDTO.getHprice();
        this.mall_name = itemDTO.getMall_name();
        this.product_type = itemDTO.getProduct_type();
        this.brand = itemDTO.getBrand();
        this.maker = itemDTO.getMaker();
        this.category1 = itemDTO.getCategory1();
        this.category2 = itemDTO.getCategory2();
        this.category3 = itemDTO.getCategory3();
        this.category4 = itemDTO.getCategory4();
    }
}
