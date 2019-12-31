package com.suranker.api.Service;

import com.suranker.api.Entity.University;
import com.suranker.api.Repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UniversityService {

    @Autowired
    UniversityRepository universityRepository;

    public List<University> getUniversities(int suburbId) {
        return universityRepository.findBySuburbId(suburbId);
    }
}
