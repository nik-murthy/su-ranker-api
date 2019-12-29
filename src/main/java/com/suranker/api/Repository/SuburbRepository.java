package com.suranker.api.Repository;

import com.suranker.api.Entity.Suburbs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SuburbRepository extends PagingAndSortingRepository<Suburbs, Integer> {
    Page<Suburbs> findByMedianHousePriceNotNull(Pageable pageable);

    @Query("select c from suburbs c where median_house_price is not null and state<=:state")
    Page<Suburbs> findByStateAndMedianHousePriceNotNull(String state, Pageable pageable);

    @Query("select c from suburbs c where median_house_price is not null and median_house_price<=:medianHousePrice")
    Page<Suburbs> findByMedianHousePriceLessThanEqual(@Param("medianHousePrice") int medianHousePrice,
                                                      Pageable pageable);

    @Query("select c from suburbs c where median_unit_price is not null and median_unit_price<=:medianUnitPrice")
    Page<Suburbs> findByMedianUnitPriceLessThanEqual(@Param("medianUnitPrice") int medianUnitPrice,
                                                     Pageable pageable);

    @Query("select c from suburbs c where state=:state and median_house_price is not null " +
            "and median_house_price<=:medianHousePrice")
    Page<Suburbs> findByStateAndMedianHousePriceLessThanEqual(@Param("medianHousePrice") int medianUnitPrice,
                                                             @Param("state") String state,
                                                             Pageable pageable);

    @Query("select c from suburbs c where state=:state and median_unit_price is not null " +
            "and median_unit_price<=:medianUnitPrice")
    Page<Suburbs> findByStateAndMedianUnitPriceLessThanEqual(@Param("medianUnitPrice") int medianUnitPrice,
                                                             @Param("state") String state,
                                                             Pageable pageable);

}
