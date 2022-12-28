package priceflow.model;


import lombok.*;
import priceflow.model.dto.PriceDto;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@ToString
@Setter
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "price_id")
    private Long price_id;

    @Column(name = "product_id")
    private String product_id;

    @Column(name = "date")
    private String date;

    @Column(name = "price")
    private Long price;

    @Column(name = "initial")
    private Boolean initial;


    public Price(String product_id, String date, Long price, Boolean initial){
        this.product_id = product_id;
        this.date = date;
        this.price = price;
        this.initial = initial;
    }

    public void setByDto(PriceDto userDto){
        this.product_id = userDto.getProduct_id();
        this.date = userDto.getDate();
        this.price = userDto.getPrice();
        this.initial = userDto.getInitial();
    }

}

