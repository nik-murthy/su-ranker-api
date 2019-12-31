package com.suranker.api.Controller;

import com.suranker.api.Service.UniversityService;
import com.suranker.api.Util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UniversityController {

    @Autowired
    UniversityService universityService;

    @GetMapping("/api/v1/universities")
    public ResponseEntity<Object> getUniversities(@RequestParam String suburbId) {

        Map<String, Object> responseMap = new HashMap<String, Object>();
        int subId = 0;
        try {
            subId = Integer.parseInt(suburbId);
        } catch (NumberFormatException ex) {
            responseMap.put(Constants.responseMessageParameter, Constants.invalidSuburbIdMessage);
            return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
        }

        Map<String, Object> responseDataParameterMap = new HashMap<String, Object>();
        responseDataParameterMap.put(Constants.responseDataUniversitiesParameter, universityService.getUniversities(subId));
        responseMap.put(Constants.responseDataParameter, responseDataParameterMap);

        return new ResponseEntity<>(responseMap, HttpStatus.ACCEPTED);
    }

}
