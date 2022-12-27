package likeservice.model.dto;

import likeservice.model.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ItemDTO {
    private Long product_id;

    private String title;

    private String link;

    private String image;

    private Long lprice;

    private Long hprice;

    private String mall_name;

    private Integer product_type;

    private String brand;

    private String maker;

    private String category1;

    private String category2;

    private String category3;

    private String category4;

    public ItemDTO(Item item){
        this.title = item.getTitle();
        this.link = item.getLink();
        this.image = item.getImage();
        this.lprice = item.getLprice();
        this.hprice = item.getHprice();
        this.mall_name = item.getMall_name();
        this.product_type = item.getProduct_type();
        this.brand = item.getBrand();
        this.maker = item.getMaker();
        this.category1 = item.getCategory1();
        this.category2 = item.getCategory2();
        this.category3 = item.getCategory3();
        this.category4 = item.getCategory4();
    }

}
