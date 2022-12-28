package priceflow;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import priceflow.model.Price;
import priceflow.model.dto.PriceDto;
import priceflow.repository.PriceRepository;

@SpringBootTest
@ContextConfiguration(classes = PriceServiceApplication.class)
class PriceServiceApplicationTests {

	Price price;

	PriceDto priceDto;

	PriceRepository priceRepository;
	@Test
	public void Insert(){
		Price price = new Price("test1","20121210", 1L, true);
		System.out.println(String.valueOf(price));

//        System.out.println(testJson);
//        ObjectMapper objectMapper = new ObjectMapper();
//        SurveyAnswerDto surveyAnswerDto = objectMapper.readValue(testJson, SurveyAnswerDto.class);
//        Long survey_id = surveyAnswerDto.getSurvey_id();
//
	}

}
