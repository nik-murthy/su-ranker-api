package com.suranker.api.Service;

import com.suranker.api.Entity.Lga;
import com.suranker.api.Model.SuburbModel;
import com.suranker.api.Repository.*;
import com.suranker.api.Util.Constants;
import com.suranker.api.Entity.Suburb;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SuburbService {

    @Autowired
    SuburbRepository suburbRepository;

    @Autowired
    HospitalRepository hospitalRepository;

    @Autowired
    UniversityRepository universityRepository;

    @Autowired
    WikipediaSummariesRepository wikipediaSummariesRepository;

    @Autowired
    LgaRepository lgaRepository;

    public Page<Suburb> getSuburbs(Map<String, String> paramMap) {

        Page<Suburb> suburbs;

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
                            maximumMedianPrice, pageable);
                } else {
                    suburbs = suburbRepository.findByStateAndMedianUnitPriceLessThanEqual(
                            maximumMedianPrice, paramMap.get(Constants.stateParameter), pageable);
                }
            } else {
                if(paramMap.get(Constants.stateParameter).equals(Constants.defaultStateSelection)) {
                    suburbs = suburbRepository.findByMedianHousePriceLessThanEqual(
                            maximumMedianPrice, pageable);
                } else {
                    suburbs = suburbRepository.findByStateAndMedianHousePriceLessThanEqual(
                            maximumMedianPrice, paramMap.get(Constants.stateParameter), pageable);
                }
            }
        } else {
            if(paramMap.get(Constants.stateParameter).equals(Constants.defaultStateSelection)) {
                suburbs = suburbRepository.findByMedianHousePriceNotNull(pageable);

            } else {
                suburbs = suburbRepository.findByStateAndMedianHousePriceNotNull(
                        paramMap.get(Constants.stateParameter), pageable);
            }
        }
        return suburbs;
    }

    public SuburbModel getSuburb(int suburbId) {

        SuburbModel suburbModel = new SuburbModel();
        suburbModel.setSuburbInfo(suburbRepository.findBySuburbId(suburbId, PageRequest.of(0, 1))
                .getContent().get(0));

        int lgaId = suburbModel.getSuburbInfo().getLga_id();
        Lga lga = lgaRepository.findByLgaId(lgaId).get(0);
        suburbModel.setLga(lgaRepository.findByLgaId(suburbModel.getSuburbInfo().getLga_id()).get(0));
        suburbModel.setHospitals(hospitalRepository.findBySuburbId(suburbId));
        suburbModel.setUniversities(universityRepository.findBySuburbId(suburbId));
        suburbModel.setWikiSummary(wikipediaSummariesRepository.findBySuburbId(suburbId).get(0));

        return suburbModel;
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
