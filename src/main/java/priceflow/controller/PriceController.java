package priceflow.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priceflow.model.Price;
import priceflow.model.dto.PriceDto;
import priceflow.repository.PriceRepository;
import priceflow.service.PriceService;

import java.util.List;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@ResponseBody
@RequiredArgsConstructor
public class PriceController {

    @Autowired
    PriceService priceService;

    PriceRepository priceRepository;
    @GetMapping("/price/all")
    public String test(){
        return priceRepository.findAll().toString();
    }

    @PostMapping("/price/update")
    public void updateProductPrice(@RequestParam PriceDto priceDto) {
        priceService.savePriceByPriceDto(priceDto);
    }

    @GetMapping("/price/{productId}")
    public List<Price> getPricesByProductId(@PathVariable String productId){
        return priceService.getPricesByProductId(productId);
    }

    @GetMapping("/price/lowest/{productId}")
    public Long getLowestPriceByProductId(@PathVariable String productId){
        return priceService.getLeastPriceByProductId(productId);
    }

    @GetMapping("/price/initial/{productId}")
    public Long getInitialPriceByProductId(@PathVariable String productId){
        return priceService.getInitialPriceByProductId(productId);
    }
}

