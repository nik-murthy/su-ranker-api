package com.suranker.api.Controller;

import com.suranker.api.Entity.Hospitals;
import com.suranker.api.Service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HospitalController {

    @Autowired
    HospitalService hospitalService;

    @GetMapping("/api/v1/hospitals")
    public List<Hospitals> getHospitals(@RequestParam String suburbId) {
        return hospitalService.getHospitals(Integer.parseInt(suburbId));
    }
}
