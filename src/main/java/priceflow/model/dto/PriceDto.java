package priceflow.model.dto;


import lombok.*;
import priceflow.model.Price;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@NoArgsConstructor
@ToString
public class PriceDto {
    private String product_id;
    private String date;
    private Long price;
    private Boolean initial;


    public PriceDto(Price user){
        this.product_id = user.getProduct_id();
        this.date = user.getDate();
        this.price = user.getPrice();
        this.initial = user.getInitial();
    }

}
