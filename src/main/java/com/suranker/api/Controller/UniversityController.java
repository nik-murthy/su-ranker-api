package com.suranker.api.Controller;

import com.suranker.api.Entity.Hospitals;
import com.suranker.api.Entity.Universities;
import com.suranker.api.Service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UniversityController {

    @Autowired
    UniversityService universityService;

    @GetMapping("/api/v1/universities")
    public List<Universities> getUniversities(@RequestParam String suburbId) {
        return universityService.getUniversities(Integer.parseInt(suburbId));
    }

}
