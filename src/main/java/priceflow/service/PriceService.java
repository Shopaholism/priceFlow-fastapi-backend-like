package priceflow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priceflow.model.Price;
import priceflow.model.dto.PriceDto;
import priceflow.repository.PriceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PriceService {

    private final PriceRepository priceRepository;
    @Autowired
    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }


    public void savePriceByPriceDto(PriceDto priceDto){
        if (priceRepository.findByProduct_id(priceDto.getProduct_id()).isPresent()){
            Optional<Price> price = priceRepository.findByProduct_id(priceDto.getProduct_id());
            price.get().setPrice(priceDto.getPrice());
            priceRepository.save(price.get());
        }
        else{
            Price price = null;
            price.setByDto(priceDto);
            priceRepository.save(price);
        }
    }

    public List<Price> getPricesByProductId(String product_id){
        System.out.println(product_id);
        List<Price> prices = priceRepository.findListByProduct_id(product_id);
        return prices;
    }

    public Long getLeastPriceByProductId(String product_id){
        List<Price> prices = priceRepository.findListByProduct_id(product_id);
        Long minprice = null;
        for(Price price : prices){
            Long cur_price = price.getPrice();
            if(minprice == null){
                minprice = cur_price;
            }
            else{
                if( minprice > cur_price){
                    minprice = cur_price;
                }
            }
        }
        return minprice;
    }

    public Long getInitialPriceByProductId(String product_id){
        List<Price> prices = priceRepository.findListByProduct_id(product_id);

        for(Price price : prices){
            if (price.getInitial()) {
                return price.getPrice();
            }
        }
        return 0L;
    }
}
