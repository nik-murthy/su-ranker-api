package com.suranker.api.Controller;


import com.suranker.api.Model.SuburbModel;
import com.suranker.api.Util.Constants;
import com.suranker.api.Entity.Suburb;
import com.suranker.api.Service.SuburbService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SuburbController {

    @Autowired
    SuburbService suburbService;

    @CrossOrigin
    @GetMapping(value="/api/v1/suburbs")
    public ResponseEntity<Object> getSuburbs(@RequestParam(defaultValue = Constants.defaultStateSelection) String state,
                                              @RequestParam(defaultValue = Constants.defaultPageNo) String pageNo,
                                              @RequestParam(required = false) String mmp,
                                              @RequestParam(defaultValue = Constants.propertyTypeHouse) String type,
                                              @RequestParam(defaultValue = Constants.defaultSortOrder) String sortBy) {

        //Create map of parameters to be passed to the service
        Map<String, String> paramMap = new HashMap<>();

        //Request parameter validation
        Map<String, Object> responseMap = new HashMap<String, Object>();
        if(!NumberUtils.isParsable(pageNo) || !isInteger(pageNo)) {
            responseMap.put(Constants.responseMessageParameter, Constants.invalidPageNumberParamMessage);
            return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
        }
        paramMap.put(Constants.pageNumberParameter, pageNo);

        if(!StringUtils.isBlank(mmp)) {
            if(!NumberUtils.isParsable(pageNo) || !isInteger(pageNo)) {
                responseMap.put(Constants.responseMessageParameter, Constants.invalidMaximumMedianPriceParamMessage);
                return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
            } else {
                paramMap.put(Constants.maximumMedianPriceParameter, mmp);
            }
        }

        if(!Constants.allowedStateValues.contains(state)) {
            responseMap.put(Constants.responseMessageParameter, Constants.invalidStateParameterMessage);
            return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
        }
        if(!Constants.allowedTypeValues.contains(type)) {
            responseMap.put(Constants.responseMessageParameter, Constants.invalidTypeParameterMessage);
            return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
        }

        if(!Constants.allowedSortValues.contains(sortBy)) {
            responseMap.put(Constants.responseMessageParameter, Constants.invalidSortParameterMessage);
            return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
        }
        paramMap.put(Constants.sortParameter, sortBy);

        paramMap.put(Constants.stateParameter, state);
        paramMap.put(Constants.pageNumberParameter, pageNo);
        if(!StringUtils.isBlank(mmp)) {
            paramMap.put(Constants.maximumMedianPriceParameter, mmp);
        }
        paramMap.put(Constants.propertyTypeParameter, type);


        //Create Response Entity
        Map<String, Object> responseDataParameterMap = new HashMap<String, Object>();

        //Fetch Results and return response
        try {
            Page<Suburb> suburbsReturned = suburbService.getSuburbs(paramMap);
            responseDataParameterMap.put(Constants.responseDataSuburbsParameter, suburbsReturned.toList());
            responseDataParameterMap.put(Constants.responseDataNumPagesParameter, suburbsReturned.getTotalPages());
            responseDataParameterMap.put(Constants.responseDataNumResultsParameter, suburbsReturned.getTotalElements());
            responseMap.put(Constants.responseMessageParameter, Constants.successfulResponseMessage);
            responseMap.put(Constants.responseDataParameter, responseDataParameterMap);

        } catch (Exception e) {
            responseMap.put(Constants.responseMessageParameter, e.getMessage());
            return new ResponseEntity<>(responseMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(responseMap, HttpStatus.ACCEPTED);
    }

    @CrossOrigin
    @GetMapping("/api/v1/suburb")
    public ResponseEntity<Object> getSuburb(@RequestParam String suburbId) {
        Map<String, Object> responseMap = new HashMap<String, Object>();
        if(!isInteger(suburbId)
                || (Integer.parseInt(suburbId) < 1)
                || (Integer.parseInt(suburbId) > Constants.numSuburbs)) {
            responseMap.put(Constants.responseMessageParameter, Constants.invalidSuburbIdMessage);
            return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
        }

        Map<String, Object> responseDataParameterMap = new HashMap<String, Object>();
        try {
            SuburbModel suburb = suburbService.getSuburb(Integer.parseInt(suburbId));
            responseDataParameterMap.put(Constants.responseDataSuburbParameter, suburb);
            responseMap.put(Constants.responseMessageParameter, Constants.successfulResponseMessage);
            responseMap.put(Constants.responseDataParameter, responseDataParameterMap);
        } catch (Exception e){
            responseMap.put(Constants.responseMessageParameter, e.getMessage());
            return new ResponseEntity<>(responseMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Object>(responseMap, HttpStatus.ACCEPTED);
    }

    private boolean isInteger(String param) {
        try {
            int testInteger = Integer.parseInt(param);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
