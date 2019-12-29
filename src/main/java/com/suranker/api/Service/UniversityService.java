package com.suranker.api.Service;

import com.suranker.api.Entity.Hospitals;
import com.suranker.api.Entity.Universities;
import com.suranker.api.Repository.HospitalRepository;
import com.suranker.api.Repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UniversityService {

    @Autowired
    UniversityRepository universityRepository;

    public List<Universities> getUniversities(int suburbId) {
        return universityRepository.findBySuburbId(suburbId);
    }
}
