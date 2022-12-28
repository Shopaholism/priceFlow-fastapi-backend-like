package priceflow.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import priceflow.model.Price;

import java.util.List;
import java.util.Optional;


@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
    @Query("select p from Price p where p.product_id = ?1")
    Optional<Price> findByProduct_id(String product_id);

    @Query("select p from Price p where p.product_id = ?1")
    List<Price> findListByProduct_id(String product_id);


    @Override
    List<Price> findAll();
}
