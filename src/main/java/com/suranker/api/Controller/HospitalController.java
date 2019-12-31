package com.suranker.api.Controller;

import com.suranker.api.Service.HospitalService;
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
public class HospitalController {

    @Autowired
    HospitalService hospitalService;

    @GetMapping("/api/v1/hospitals")
    public ResponseEntity<Object> getHospitals(@RequestParam String suburbId) {

        Map<String, Object> responseMap = new HashMap<String, Object>();
        int subId = 0;
        try {
            subId = Integer.parseInt(suburbId);
        } catch (NumberFormatException ex) {
            responseMap.put(Constants.responseMessageParameter, Constants.invalidSuburbIdMessage);
            return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
        }
        Map<String, Object> responseDataParameterMap = new HashMap<String, Object>();
        responseDataParameterMap.put(Constants.responseDataHospitalsParameter, hospitalService.getHospitals(subId));

        return new ResponseEntity<>(responseMap, HttpStatus.ACCEPTED);

    }
}
