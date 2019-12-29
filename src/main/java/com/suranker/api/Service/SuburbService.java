package com.suranker.api.Service;

import com.suranker.api.Constants;
import com.suranker.api.Entity.Suburbs;
import com.suranker.api.Repository.SuburbRepository;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class SuburbService {

    @Autowired
    SuburbRepository suburbRepository;

    public List<Suburbs> getSuburbs(Map<String, String> paramMap) {

        List<Suburbs> suburbs;

        Pageable pageable = getPageNumberAndSort(paramMap);

        int maximumMedianPrice = 0;
        if (paramMap.containsKey(Constants.maximumMedianPriceParameter)) {
            maximumMedianPrice = getParsedIntegerValue(paramMap.get(Constants.maximumMedianPriceParameter));
        }
        boolean isPropertyTypeHouse = true;
        if (!paramMap.get(Constants.propertyTypeParameter).equals(Constants.propertyTypeHouse)) {
            isPropertyTypeHouse = false;
        }

        //Determine which query to execute based on parameters provided
        if (maximumMedianPrice > 0) {
            if (!isPropertyTypeHouse) {
                if(paramMap.get(Constants.stateParameter).equals(Constants.defaultStateSelection)) {
                    suburbs = suburbRepository.findByMedianUnitPriceLessThanEqual(
                            maximumMedianPrice, pageable).toList();
                } else {
                    suburbs = suburbRepository.findByStateAndMedianUnitPriceLessThanEqual(
                            maximumMedianPrice, paramMap.get(Constants.stateParameter), pageable).toList();
                }
            } else {
                if(paramMap.get(Constants.stateParameter).equals(Constants.defaultStateSelection)) {
                    suburbs = suburbRepository.findByMedianHousePriceLessThanEqual(
                            maximumMedianPrice, pageable).toList();
                } else {
                    suburbs = suburbRepository.findByStateAndMedianHousePriceLessThanEqual(
                            maximumMedianPrice, paramMap.get(Constants.stateParameter), pageable).toList();
                }
            }
        } else {
            suburbs = suburbRepository.findByMedianHousePriceNotNull(pageable).toList();
        }

        return suburbs;
    }

    private int getParsedIntegerValue(String parameter) {
        if (NumberUtils.isParsable(parameter)) {
            return Integer.parseInt(parameter);
        } else {
            return 0;
        }
    }

    private Pageable getPageNumberAndSort(Map<String, String> paramMap){
        Pageable pageable = PageRequest.of(
                getParsedIntegerValue(paramMap.get(Constants.pageNumberParameter)) - 1,
                10,
                Sort.by("total").descending().
                        and(Sort.by("skew").ascending()));

        return pageable;
    }

}
