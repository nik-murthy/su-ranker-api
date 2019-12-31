package com.suranker.api.Service;

import com.suranker.api.Entity.Hospital;
import com.suranker.api.Repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HospitalService {

    @Autowired
    HospitalRepository hospitalRepository;

    public List<Hospital> getHospitals(int suburbId) {
        return hospitalRepository.findBySuburbId(suburbId);
    }
}
